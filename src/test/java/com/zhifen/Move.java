package com.zhifen;

import com.zhifeng.dao.OrganizationDao;
import com.zhifeng.dao.OrganizationDaoImpl;
import com.zhifeng.model.Organization;
import com.zhifeng.spring.JdbcTemplateUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Move {
       @Test
        public void MoveTest(){
           OrganizationDao dao = new OrganizationDaoImpl();
           Organization a =   dao.findOne(3l);
           Organization b =   dao.findOne(2l);
           move(a,b);



     }
    public void  move(Organization a,Organization b){
        JdbcTemplate  jdbcTemplate  = JdbcTemplateUtils.jdbcTemplate();
        String moveSourceSql = "update sys_organization set parent_id=?,parent_ids=? where id=?";
        jdbcTemplate.update(moveSourceSql, a.getId(), a.makeSelfAsParentIds(), b.getId());
        String  lists = "select * from sys_organization a where a.parent_id = ?";
        List<Organization> list= jdbcTemplate.query(lists,new BeanPropertyRowMapper(Organization.class),b.getId());
        if(list.size()>0){
            OrganizationDao dao = new OrganizationDaoImpl();
            Organization aa =   dao.findOne(b.getId());
            Organization bb  =list.get(0);
            move(aa,bb);
        }
        }
}
