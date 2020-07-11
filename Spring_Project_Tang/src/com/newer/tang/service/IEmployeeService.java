package com.newer.tang.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.web.util.EmployeeForm;

public interface IEmployeeService {

		//��¼��֤
		public abstract Employee checkLogin(EmployeeForm form);
		public abstract  List<Employee> allEmp();
		public abstract int queryCount1();
		public abstract  List<Employee> allEmp(int pageNo,int pageSize);
		public abstract Employee empById(int id);
		//��ѯ���й���Ա
		public abstract Employee queryAll(Map<Integer, Object> param);
		public abstract int queryCount();
		public abstract  List<Employee> queryAll();
		//�����û�
		public abstract int insertUser(Employee emp);
		
		//ɾ���û�
		public abstract int deleteUser(int id);
		
		//�����û��޸�
		public abstract int updateUser(Employee emp);
		
		//����id��ѯ
		public abstract Employee queryId(int id);
}