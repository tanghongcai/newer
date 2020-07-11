package com.newer.tang.web.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.dao.impl.EmployeeDAOimpl;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.service.IEmployeeService;


public class Testc {
	@Resource(name="employeeService")
	IEmployeeService service;
	@Test
	public void Testd(){
		IEmployeeDAO dao=new EmployeeDAOimpl();
		Employee emp=new Employee();
		int count=service.deleteUser(34);	
		System.out.println("É¾³ý¼ÇÂ¼£º"+count);
	}
}
