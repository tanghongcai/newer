package com.newer.tang.web.util;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Role;

public class EmployeeForm {
	Employee emp;//表单员工
	Role role;//表单角色
	public EmployeeForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeForm(Employee emp, Role role) {
		super();
		this.emp = emp;
		this.role = role;
	}
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "EmployeeForm [emp=" + emp + ", role=" + role + "]";
	}
	
}
