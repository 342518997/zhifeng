package com.zhifen;

import com.zhifeng.dao.ResourceDao;
import com.zhifeng.dao.ResourceDaoImpl;
import com.zhifeng.model.Resource;
import com.zhifeng.service.ResourceService;
import com.zhifeng.service.ResourceServiceImpl;
import org.junit.Test;

import java.util.List;

public class ResourceType {
    @Test
    public void Type(){

        ResourceDao  resourceDao = new ResourceDaoImpl();

        List<Resource>resources =resourceDao.findAll();
        for(Resource resource : resources){
            System.out.println(resource.getType().getInfo());
        }
    }
    @Test
    public void Resource(){
        Resource resource = new Resource();
      Resource.ResourceType[] resourceTypes = resourceTypes();
      for(Resource.ResourceType resourceType : resourceTypes){
          resource.setType(resourceType);
      }

        System.out.println(resource.getType());


     }
    public Resource.ResourceType[] resourceTypes() {
        return Resource.ResourceType.values();
    }
}
