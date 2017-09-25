package com.zhifen;

import com.zhifeng.dao.OrganizationDao;
import com.zhifeng.dao.ResourceDao;
import com.zhifeng.model.Organization;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestOrganization {
    private OrganizationDao dao;
    @Before
    public void init(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        dao = context.getBean(OrganizationDao.class);
    }
    @Test
    public void  TestfindAllWithExclude(){

        Organization organization =
               dao.findOne(2l);
        List<Organization> list = dao.findAllWithExclude(organization);
        for(Organization organization1 : list){
            System.out.println(organization1.toString());
        }
    }
    @Test
    public void TestMove(){
        Organization source =dao.findOne(4l);
        Organization target =dao.findOne(1l);
        dao.move(source,target);
    }

}
