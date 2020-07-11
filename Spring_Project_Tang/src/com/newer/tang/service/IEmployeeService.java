package com.newer.tang.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.web.util.EmployeeForm;

public interface IEmployeeService {

		//登录验证
		public abstract Employee checkLogin(EmployeeForm form);
		public abstract  List<Employee> allEmp();
		public abstract int queryCount1();
		public abstract  List<Employee> allEmp(int pageNo,int pageSize);
		public abstract Employee empById(int id);
		//查询所有管理员
		public abstract Employee queryAll(Map<Integer, Object> param);
		public abstract int queryCount();
		public abstract  List<Employee> queryAll();
		//新增用户
		public abstract int insertUser(Employee emp);
		
		//删除用户
		public abstract int deleteUser(int id);
		
		//分配用户修改
		public abstract int updateUser(Employee emp);
		
		//根据id查询
		public abstract Employee queryId(int id);
}