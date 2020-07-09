package com.newer.tang.web.control;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.data.entity.Plan;
import com.newer.tang.data.entity.Role;
import com.newer.tang.data.entity.Task;
import com.newer.tang.service.IEmployeeService;

import com.newer.tang.web.util.EmpTaskForm;
import com.newer.tang.web.util.EmployeeForm;
import com.newer.tang.web.util.MiddleTable;
import com.newer.tang.web.util.PageBean;
import com.newer.tang.web.util.TaskPlanDTO;

@Controller
@SessionAttributes("form")
public class DaTangControl {
	
	//根据业务层调用Dao类方法
	@Resource(name="employeeService")
	IEmployeeService serviceDao;

	@Resource(name="roleDAO")
	IRoleDAO roleDao;
	
	
	public DaTangControl() {
		super();
		System.out.println("大唐控制器实例化");
	}
	
	public boolean isBlank(String param) {
		// true：文本框没有值
		return "".equals(param) || param == null;
	}
	
	//装填登录表单
	@RequestMapping("/emp_input.do")
	public String input_emp(Model model){
		Employee emp=new Employee();
		Role role=new Role();
		
		EmployeeForm form=new EmployeeForm(emp, role);
		//查询全部角色
		List<Role> allRoles=roleDao.queryAll();
		model.addAttribute("roles", allRoles);
		model.addAttribute("form", form);
		return "login.jsp";
	}
	
	/**
	 * 实现登录跳转方法
	 */
	@RequestMapping("/login.do")
	public String empLogin(@ModelAttribute("form") EmployeeForm employee,Model model,HttpSession session){
		System.out.println("员工登录-》empLogin");
		//跳转的路径
		String path="";
		System.out.println("用户名："+employee.getEmp().getEmployeeName()+",密码："+employee.getEmp().getPassword()+",角色编号："+employee.getRole().getRoleId());
		Employee emp=serviceDao.checkLogin(employee);
		if(emp!=null){
			//true:存在登录用户
			if(emp.getRole().getRoleId()==employee.getRole().getRoleId()){
				//true登录用户存在对应的角色编号
				System.out.println("登录用户存在对应的角色编号");
				//将用户存入会话范围
				session.setAttribute("emp", emp);
				String roleName=emp.getRole().getRoleName();
				if(roleName.equals("系统管理员")){
					path="redirect:/admin_login_success.do";
				}else if(roleName.equals("主管")){
					path="redirect:/manager_login_success.do";
				}else if(roleName.equals("员工")){
					path="redirect:/employee_login_success.do";
				}
			}else{
				//false登录用户不存在对应的角色编号
				System.out.println("登录用户不存在对应的角色编号");
				model.addAttribute("msg", "该用户无此角色");
				path="error.jsp";
			}
		}else{
			System.out.println("不存在");
			//false:不存在登录用户
			model.addAttribute("msg", "用户名或密码错误！");
			path= "error.jsp";
		}
		return path;
	}
	
	
	
	//退出
	@RequestMapping("invalidate.do")
	public String invalidate(HttpSession session){
		session.invalidate();
		return "emp_input.do";
	}
	
	
}
