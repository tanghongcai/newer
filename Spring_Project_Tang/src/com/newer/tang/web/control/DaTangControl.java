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
	
	//����ҵ������Dao�෽��
	@Resource(name="employeeService")
	IEmployeeService serviceDao;

	@Resource(name="roleDAO")
	IRoleDAO roleDao;
	
	
	public DaTangControl() {
		super();
		System.out.println("���ƿ�����ʵ����");
	}
	
	public boolean isBlank(String param) {
		// true���ı���û��ֵ
		return "".equals(param) || param == null;
	}
	
	//װ���¼��
	@RequestMapping("/emp_input.do")
	public String input_emp(Model model){
		Employee emp=new Employee();
		Role role=new Role();
		
		EmployeeForm form=new EmployeeForm(emp, role);
		//��ѯȫ����ɫ
		List<Role> allRoles=roleDao.queryAll();
		model.addAttribute("roles", allRoles);
		model.addAttribute("form", form);
		return "login.jsp";
	}
	
	/**
	 * ʵ�ֵ�¼��ת����
	 */
	@RequestMapping("/login.do")
	public String empLogin(@ModelAttribute("form") EmployeeForm employee,Model model,HttpSession session){
		System.out.println("Ա����¼-��empLogin");
		//��ת��·��
		String path="";
		System.out.println("�û�����"+employee.getEmp().getEmployeeName()+",���룺"+employee.getEmp().getPassword()+",��ɫ��ţ�"+employee.getRole().getRoleId());
		Employee emp=serviceDao.checkLogin(employee);
		if(emp!=null){
			//true:���ڵ�¼�û�
			if(emp.getRole().getRoleId()==employee.getRole().getRoleId()){
				//true��¼�û����ڶ�Ӧ�Ľ�ɫ���
				System.out.println("��¼�û����ڶ�Ӧ�Ľ�ɫ���");
				//���û�����Ự��Χ
				session.setAttribute("emp", emp);
				String roleName=emp.getRole().getRoleName();
				if(roleName.equals("ϵͳ����Ա")){
					path="redirect:/admin_login_success.do";
				}else if(roleName.equals("����")){
					path="redirect:/manager_login_success.do";
				}else if(roleName.equals("Ա��")){
					path="redirect:/employee_login_success.do";
				}
			}else{
				//false��¼�û������ڶ�Ӧ�Ľ�ɫ���
				System.out.println("��¼�û������ڶ�Ӧ�Ľ�ɫ���");
				model.addAttribute("msg", "���û��޴˽�ɫ");
				path="error.jsp";
			}
		}else{
			System.out.println("������");
			//false:�����ڵ�¼�û�
			model.addAttribute("msg", "�û������������");
			path= "error.jsp";
		}
		return path;
	}
	
	
	
	//�˳�
	@RequestMapping("invalidate.do")
	public String invalidate(HttpSession session){
		session.invalidate();
		return "emp_input.do";
	}
	
	
}
