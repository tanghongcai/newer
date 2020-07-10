package com.newer.tang.data.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Role;


@Component("roleDAO")
public class RoleDAOimpl extends SqlSessionDaoSupport implements IRoleDAO {
	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
	private void initialize() {
		System.out.println("≥ı ºªØ");
		setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public Role queryById(Integer roleId){
		Role all=null;
		try {
			SqlSession session=super.getSqlSession();
			IRoleDAO dao=session.getMapper(IRoleDAO.class);
			all=dao.queryById(roleId);
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
	
	
	@Override
	public List<Role> queryAll(){
		List<Role> all=null;
		try {
			SqlSession session=super.getSqlSession();
			IRoleDAO dao=session.getMapper(IRoleDAO.class);
			all=dao.queryAll();
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}
}
