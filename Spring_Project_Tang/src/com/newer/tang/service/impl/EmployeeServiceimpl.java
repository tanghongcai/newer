package com.newer.tang.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.service.IEmployeeService;
import com.newer.tang.web.util.EmployeeForm;

@Service("employeeService")
public class EmployeeServiceimpl implements IEmployeeService {
	
	@Resource(name="employeeDAO")
	IEmployeeDAO dao;
	
	//登录验证
	/* (non-Javadoc)
	 * @see com.newer.tang.service.impl.IEmployeeService#checkLogin(com.newer.tang.data.entity.Employee)
	 */
	
	@Override
	public Employee checkLogin(EmployeeForm form){
		Employee employee=null;
		//编写sql
		String sql="select *from T_EMPLOYEE where EMPLOYEE_NAME=? and PASSWORD=?";
		//填充参数
		Object[] obj=new Object[]{form.getEmp().getEmployeeName(),form.getEmp().getPassword()};
		//根据dao实现登录的方法
		List<Employee> listEmp=new ArrayList<Employee>();
		listEmp=dao.queryEmployee(sql, obj);
		System.out.println("查询到的员工人数："+listEmp.size());
		if(listEmp!=null && listEmp.size()>0){
			//true存在该用户
			employee=listEmp.get(0);
		}
		return employee;
	}
	
	//---------
	
	//全部查询
		@Override
		public Employee queryAll(Map<Integer, Object> param) {
			
			return dao.queryAll(param);
		}
		@Override
		public int queryCount(){
			return dao.queryCount();
		}

		//新增用户
		@Override
		public int insertUser(Employee emp) {
			
			return dao.insertAdmin(emp);
		}

		@Override
		public int deleteUser(int id) {
			
			return dao.deleteAdmin(id);
		}

		@Override
		public int updateUser(Employee emp) {
			
			return dao.updateAdmin(emp);
		}

		@Override
		public Employee queryId(int id) {
			
			return dao.queryId(id);
		}
	
	//---------
	
	//查询所有员工
	public List<Employee> allEmp(){
		//编写sql
		String sql="select *from T_EMPLOYEE t where ROLE_ID=?";
		List<Employee> listEmp=new ArrayList<Employee>();
		int id=4;
		listEmp=dao.queryEmployee(sql, new Object[]{id});
		System.out.println(listEmp.toString());
		System.out.println("查询到的员工人数："+listEmp.size());
		return listEmp;
	}
	
	//分页查询
	public List<Employee> allEmp(int pageNo,int pageSize){
		//编写sql
		int start=(pageNo-1)*pageSize+1;
		int end=pageNo*pageSize;
		String sql="select *from (select row_number() over(order by EMPLOYEE_ID) no,t.*from T_EMPLOYEE t where ROLE_ID=4) temp where temp.no between ? and ?";
		List<Employee> listEmp=new ArrayList<Employee>();
		listEmp=dao.queryEmployee(sql, new Object[]{start,end});
		System.out.println(listEmp.toString());
		System.out.println("查询到的员工人数："+listEmp.size());
		return listEmp;
	}
	
	public int queryCount1(){
		return dao.queryCount1();
	}
	

	@Override
	public Employee empById(int id) {
		return dao.allQueryEmp(id);
	}

	@Override
	public List<Employee> queryAll() {
		// TODO Auto-generated method stub
		return dao.queryAll();
	}
	
}
