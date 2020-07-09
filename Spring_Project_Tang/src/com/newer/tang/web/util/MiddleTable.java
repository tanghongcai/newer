package com.newer.tang.web.util;

import java.util.List;

import com.newer.tang.data.entity.Plan;
import com.newer.tang.data.entity.Task;

public class MiddleTable {
	private Task t;
	private List<Plan> listPlan;
	public MiddleTable(Task t, List<Plan> listPlan) {
		super();
		this.t = t;
		this.listPlan = listPlan;
	}
	public MiddleTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task getT() {
		return t;
	}
	public void setT(Task t) {
		this.t = t;
	}
	public List<Plan> getListPlan() {
		return listPlan;
	}
	public void setListPlan(List<Plan> listPlan) {
		this.listPlan = listPlan;
	}
	@Override
	public String toString() {
		return "MiddleTable [t=" + t + ", listPlan=" + listPlan + "]";
	}
	
}
