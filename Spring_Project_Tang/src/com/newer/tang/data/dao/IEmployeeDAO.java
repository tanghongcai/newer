package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;

public interface IEmployeeDAO {

		//登录
		public abstract List<Employee> queryEmployee(String sql, Object[] param);
		public abstract Employee allQueryEmp(int empId);
		public abstract int queryCount1();
		//查询所有管理员信息
		public abstract Employee queryAll(Map<Integer, Object> param);
		
		public abstract List<Employee> queryAll();
		public abstract int queryCount();
		//新增管理员
		public abstract int insertAdmin(Employee emp);
		
		//删除管理员信息
		public abstract int deleteAdmin(int id);
		
		//修改分配人员
		public abstract int updateAdmin(Employee emp);

		//根据id查询信息
		public abstract Employee queryId(int id);
}