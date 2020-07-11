package com.newer.tang.data.dao;

import java.util.List;
import java.util.Map;

import com.newer.tang.data.entity.Employee;

public interface IEmployeeDAO {

		//��¼
		public abstract List<Employee> queryEmployee(String sql, Object[] param);
		public abstract Employee allQueryEmp(int empId);
		public abstract int queryCount1();
		//��ѯ���й���Ա��Ϣ
		public abstract Employee queryAll(Map<Integer, Object> param);
		
		public abstract List<Employee> queryAll();
		public abstract int queryCount();
		//��������Ա
		public abstract int insertAdmin(Employee emp);
		
		//ɾ������Ա��Ϣ
		public abstract int deleteAdmin(int id);
		
		//�޸ķ�����Ա
		public abstract int updateAdmin(Employee emp);

		//����id��ѯ��Ϣ
		public abstract Employee queryId(int id);
}