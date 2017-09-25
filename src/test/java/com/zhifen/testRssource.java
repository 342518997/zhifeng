package com.zhifen;

import com.zhifeng.dao.ResourceDao;
import com.zhifeng.model.Resource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testRssource {


    private ResourceDao dao;
    @Before
    public void init(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        dao = context.getBean(ResourceDao.class);
    }
    @Test
    public void testcreateResource(){

        Resource resource = new Resource();
        resource.setName("客户管理");
        resource.setType(Resource.ResourceType.menu);
        resource.setUrl("/client");
        resource.setParentId(1l);
        resource.setParentIds("0/1/");
        resource.setPermission("client:*");
        resource.setAvailable(true);
        Resource resource1 = dao.createResource(resource);
        System.out.println(resource1.getId());
    }
    @Test
    public void TestMenu(){
/*        Resource.ResourceType resourceType =Resource.ResourceType.menu;
        System.out.println(resourceType);
        Resource resource =new Resource();
        resource.setParentId(1l);
        System.out.println(resource.isRootNode());*/



    }


}

