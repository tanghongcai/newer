package com.newer.tang.data.dao;

import java.util.List;

import com.newer.tang.data.entity.Role;

public interface IRoleDAO {

	/**
	 * 根据编号查询角色
	 * new BeanPropertyRowMapper(Role.class))相当于:new RowMapper()
	 * @param roleId 角色编号
	 * @return
	 */
	public abstract Role queryById(Integer roleId);

	/**
	 * 查询全部角色信息
	 * new BeanPropertyRowMapper(Role.class))相当于:new RowMapper()
	 */
	public abstract List<Role> queryAll();

}