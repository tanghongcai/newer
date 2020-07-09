package com.newer.tang.data.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.entity.Role;
import com.newer.tang.data.util.DBUtil;

@Component("roleDAO")
public class RoleDAOimpl implements IRoleDAO {
	JdbcTemplate jdbcTemplate=new JdbcTemplate(DBUtil.getDataSource());
	
	/* (non-Javadoc)
	 * @see com.newer.tang.data.dao.impl.IRoleDAO#queryById(java.lang.Integer)
	 */
	@Override
	public Role queryById(Integer roleId){
		return (Role) jdbcTemplate.queryForObject("select *from T_ROLE where ROLE_ID=?", new Object[]{roleId}, new BeanPropertyRowMapper(Role.class));
	}
	
	/* (non-Javadoc)
	 * @see com.newer.tang.data.dao.impl.IRoleDAO#queryAll()
	 */
	@Override
	public List<Role> queryAll(){
		return jdbcTemplate.query("select *from T_ROLE", new BeanPropertyRowMapper(Role.class));
	}
}
