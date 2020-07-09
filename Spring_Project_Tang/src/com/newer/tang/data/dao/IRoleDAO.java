package com.newer.tang.data.dao;

import java.util.List;

import com.newer.tang.data.entity.Role;

public interface IRoleDAO {

	/**
	 * ���ݱ�Ų�ѯ��ɫ
	 * new BeanPropertyRowMapper(Role.class))�൱��:new RowMapper()
	 * @param roleId ��ɫ���
	 * @return
	 */
	public abstract Role queryById(Integer roleId);

	/**
	 * ��ѯȫ����ɫ��Ϣ
	 * new BeanPropertyRowMapper(Role.class))�൱��:new RowMapper()
	 */
	public abstract List<Role> queryAll();

}