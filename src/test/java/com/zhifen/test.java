package com.zhifen;

import com.zhifeng.dao.UserDao;
import com.zhifeng.model.User;
import com.zhifeng.service.PasswordHelper;
import com.zhifeng.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class test {

    private UserDao userDao;
    private UserService service;
    @Before
    public  void init(){
        ApplicationContext context = new
                ClassPathXmlApplicationContext
                ("classpath:spring-config.xml");
          userDao = context.getBean(UserDao.class);
          service = context.getBean(UserService.class);

    }

    @Test
    public void UserfinAllTest(){

        List<User> list =userDao.findAll();

        for(User user : list){

            System.out.println(user.getRoleIdsStr());
        }

    }
    @Test
    public void UsercreateUserTest(){
        User user = new User();
        user.setOrganizationId(3l);
        user.setUsername("admi");
        user.setPassword("123456");
        List<Long> longs = new ArrayList<>();
        longs.add(1l);
        user.setRoleIds( longs);
        user.setLocked(false);

        PasswordHelper passwordHelper = new PasswordHelper();

        passwordHelper.encryptPassword(user);

        System.out.println( user.getSalt()+"  "+user.getPassword());

        User user1 =userDao.createUser(user);

        System.out.println(user1.getId());


    }
    @Test
    public void TestfindRoles(){
      Set<String> strings =
              service.findRoles("admin");
      for(String s : strings){
          System.out.println(s);
      }
    }
    @Test
    public void TestfindPermissions(){
        Set<String> strings =
                service.findPermissions("admin");
        for (String s : strings){
            System.out.println(s);
        }
    }
}
