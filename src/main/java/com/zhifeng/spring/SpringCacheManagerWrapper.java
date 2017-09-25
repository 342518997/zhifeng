package com.zhifeng.spring;

import net.sf.ehcache.Ehcache;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.cache.support.SimpleValueWrapper;

import java.util.*;

/**
 * 包装Spring cache抽象
 * <p>User:
 * <p>Date: 13-3-23 上午8:26
 * <p>Version: 1.0
 */

public class SpringCacheManagerWrapper implements CacheManager {

    private org.springframework.cache.CacheManager cacheManager;



    /**
     * 设置spring cache manager
     *
     * @param cacheManager
     */
    public void setCacheManager(org.springframework.cache.CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
    /*根据名字获取一个缓存对象*/
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        org.springframework.cache.Cache cache = cacheManager.getCache(s);
        return new SpringCacheWrapper(cache);
    }

    /*实现cache*/
    static class SpringCacheWrapper implements Cache {
        private org.springframework.cache.Cache springcache;

        SpringCacheWrapper(org.springframework.cache.Cache springcache) {
            this.springcache = springcache;
        }

        //根据Key获取缓存中的值
        public Object get(Object o) throws CacheException {
            Object value = springcache.get(o);
            if (value instanceof SimpleValueWrapper) {
                return ((SimpleValueWrapper) value).get();
            }
            return value;
        }
        //往缓存中放入key-value，返回缓存中之前的值
        public Object put(Object o, Object o2) throws CacheException {
            springcache.put(o, o2);
            return o2;
        }
        //移除缓存中key对应的值，返回该值
        public Object remove(Object o) throws CacheException {
            springcache.evict(o);
            return null;
        }
        //清空整个缓存
        public void clear() throws CacheException {
            springcache.clear();
        }
        //返回缓存大小
        public int size() {
            if(springcache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springcache.getNativeCache();
                return ehcache.getSize();
            }
            throw new UnsupportedOperationException("invoke spring cache abstract size method not supported");
        }

        //获取缓存中所有的key
        public Set keys() {
            if(springcache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springcache.getNativeCache();
                return new HashSet(ehcache.getKeys());
            }
            throw new UnsupportedOperationException("invoke spring cache abstract keys method not supported");
        }

        //获取缓存中所有的value
        public Collection values() {
            if(springcache.getNativeCache() instanceof Ehcache) {
                Ehcache ehcache = (Ehcache) springcache.getNativeCache();
                List keys = ehcache.getKeys();
                if (!CollectionUtils.isEmpty(keys)) {
                    List values = new ArrayList(keys.size());
                    for (Object key : keys) {
                        Object value = get(key);
                        if (value != null) {
                            values.add(value);
                        }
                    }
                    return Collections.unmodifiableList(values);
                } else {
                    return Collections.emptyList();
                }
            }
            throw new UnsupportedOperationException("invoke spring cache abstract values method not supported");
        }
    }
}

