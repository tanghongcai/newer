package com.newer.tang.web.util;

import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Task;

public class EmpTaskForm {
	private Employee emp;
	private Task t;
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public Task getT() {
		return t;
	}
	public void setT(Task t) {
		this.t = t;
	}
	public EmpTaskForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmpTaskForm(Employee emp, Task t) {
		super();
		this.emp = emp;
		this.t = t;
	}
	@Override
	public String toString() {
		return "EmpTaskForm [emp=" + emp + ", t=" + t + "]";
	}
	
}
