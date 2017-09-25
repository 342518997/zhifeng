package com.zhifen;

import com.zhifeng.dao.RoleDao;
import com.zhifeng.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testrole {

    private RoleDao dao;

    @Before
    public void init(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        dao = context.getBean(RoleDao.class);

    }
    @Test
    public void createRoleTest(){

        Role role = new Role();

        role.setRole("员工");
        role.setDescription("公司员工");
        role.setResourceIdsStr("21,31");
        role.setAvailable(true);
        Role role1 = dao.createRole(role);
        System.out.println(role.getId());

    }
}
