package com.newer.tang.web.control;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.newer.tang.data.dao.IRoleDAO;
import com.newer.tang.data.entity.Employee;
import com.newer.tang.service.IEmployeeService;
import com.newer.tang.web.util.PageBean;

@Controller
@SessionAttributes("selectAll")
public class SelectControl {	
	@Resource(name="employeeService")
	IEmployeeService service;
	@Resource(name="roleDAO")
	IRoleDAO roleDao;
	
	
	//�˳�ϵͳ
	@RequestMapping("loging.do")
	public String login(HttpSession session){
		session.removeAttribute("emp");
		return "/emp_input.do";
	}
	
	//Ա�������ѯ
	@RequestMapping("select.do")
	public String selectAll(Model model,HttpServletRequest request){
		int pageNo = 1;
		int pageSize = 3;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		List list=service.queryAll(pageNo,pageSize);
		System.out.println(list);
		PageBean<Employee> pb=new PageBean<Employee>();
		int count=service.queryCount();
		pb.setCount(count);
		pb.setData(list);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		model.addAttribute("pb", pb);
		model.addAttribute("selectAll", list);
		return "admin/empadmin.jsp";
	}
	
	//�û������ѯ
	@RequestMapping("userSelect.do")
	public String userSelect(Model model,HttpServletRequest request){
		int pageNo = 1;
		int pageSize = 3;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		//List list=service.queryAll(pageNo,pageSize);
		List list=service.queryAll();
		System.out.println(list);
		PageBean<Employee> pb=new PageBean<Employee>();
		int count=service.queryCount();
		pb.setCount(count);
		pb.setData(list);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		model.addAttribute("pb", pb);
		model.addAttribute("userSelect", list);
		return "admin/useradmin.jsp";
	}
	
	//������Ա��ѯ
	@RequestMapping("fuser.do")
	public String fuser(Model model,HttpServletRequest request){
		int pageNo = 1;
		int pageSize = 3;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		if (request.getParameter("pageSize") != null) {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}
		List list=service.queryAll(pageNo,pageSize);
		PageBean<Employee> pb=new PageBean<Employee>();
		int count=service.queryCount();
		pb.setCount(count);
		pb.setData(list);
		pb.setPageNo(pageNo);
		pb.setPageSize(pageSize);
		model.addAttribute("pb", pb);
		System.out.println(list);
		model.addAttribute("fuser", list);
		return "admin/empdistribute.jsp";
	}
	
	//ɾ���û�
	@RequestMapping("delete.do")
	public String deleteUser(@ModelAttribute("deleteUser") Employee emp,@RequestParam("radiobutton") Integer id, Model model){			
		emp.setEmployeeId(id);
		System.out.println(id);
		int count=service.deleteUser(emp);
		System.out.println("ִ������"+count);
		return "select.do";
	}
	
	//�޸��û�
		@RequestMapping("updateUser.do")
		public String updateUser(@RequestParam("radiobutton") Integer id,Employee emp,Model model){
			emp.setEmployeeId(id);
			System.out.println("���ݵ�id��"+id);
			Employee all=service.queryId(id);
			System.out.println(all);
			
			List<String> sex = new ArrayList<String>();
			sex.add("��");
			sex.add("Ů");
			model.addAttribute("sexs", sex);
			
			
			List<String> major = new ArrayList<String>();
			major.add("�г�Ӫ��");
			major.add("���");
			major.add("�����");
			major.add("���ڹ���");
			model.addAttribute("major", major);
			
			List<String> edc = new ArrayList<String>();
			edc.add("Сѧ");
			edc.add("����");
			edc.add("����");
			edc.add("��ר");
			edc.add("��ѧ");
			edc.add("˶ʿ");
			edc.add("��ʿ");
			edc.add("��ʿ��");
			model.addAttribute("edcucation", edc);
			
			model.addAttribute("update", all);
			return "admin/persondesc.jsp";
		}
		
		
		@RequestMapping("updateUsers.do")
		public String update(@ModelAttribute() Employee emp, Model model){
			System.out.println("11:scysay;;;"+emp);
			int count=service.updateUser(emp);
			System.out.println("�޸�����"+count);
			return "fuser.do";
		}
	
	//�û�����
	@RequestMapping("userAdd.do")
	public String userAdd(Model model){		
		Employee emp=new Employee();
		emp.setSex("��");
		
		List<String> sex = new ArrayList<String>();
		sex.add("��");
		sex.add("Ů");
		model.addAttribute("sexs", sex);
		
		
		List<String> major = new ArrayList<String>();
		major.add("�г�Ӫ��");
		major.add("���");
		major.add("�����");
		major.add("���ڹ���");
		model.addAttribute("major", major);
		
		List<String> edc = new ArrayList<String>();
		edc.add("Сѧ");
		edc.add("����");
		edc.add("����");
		edc.add("��ר");
		edc.add("��ѧ");
		edc.add("˶ʿ");
		edc.add("��ʿ");
		edc.add("��ʿ��");
		model.addAttribute("edcucation", edc);
		
		model.addAttribute("emp", emp);
		return "forward:/admin/personadd.jsp";
	}
	
	@RequestMapping("userAdds.do")
	public String usersAdd(@ModelAttribute("emp") Employee emp,Model model){
		System.out.println(emp.toString());

		int count=service.insertUser(emp);
		System.out.println("123"+emp.toString());
		System.out.println("��������"+count);
		return "admin/useradmin.jsp";
	}
	
	
}
