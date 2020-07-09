package com.newer.tang.data.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.newer.tang.data.dao.IEmployeeDAO;
import com.newer.tang.data.entity.Employee;
@Repository("employeeDAO")
public class EmployeeDAOimpl extends SqlSessionDaoSupport implements IEmployeeDAO {
	@Resource(name="sqlSessionFactory")
	SqlSessionFactory sqlSessionFactory;
	
	@PostConstruct
	private void initialize() {
		System.out.println("初始化");
		setSqlSessionFactory(sqlSessionFactory);
	}
			
	@Override
	public List<Employee> queryEmployee(String sql, Object[] param) {
		List<Employee> all=null;
		try {
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			all=dao.queryEmployee(sql, param);
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	//根据id查询所有员工
	@Override
	public Employee allQueryEmp(int empId) {
		System.out.println("根据id查询所有员工：");
		Employee all=null;
		try {			
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			all=dao.allQueryEmp(empId);
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return all;
	}

	//分页
	@Override
	public int queryCount1() {
		System.out.println("分页总数：");
		int count=0;
		try {	
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.queryCount1();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return count;
	}

	//分页查询
	@Override
	public List<Employee> queryAll(int pageNo, int pageSize) {
		System.out.println("分页查询：");
		List<Employee> all=null;
		try {	
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			all=dao.queryAll(pageNo, pageSize);
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return all;
	}

	@Override
	public int queryCount() {
		System.out.println("分页总数：");
		int count=0;
		try {	
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			count=dao.queryCount();
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return count;
	}

	//插入员工
		@Override
		public int insertAdmin(Employee emp) {
			System.out.println("插入员工：");
			int count=0;
			try {	
				SqlSession session=super.getSqlSession();
				IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
				count=dao.insertAdmin(emp);
				System.out.println(count);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return count;
		}

		//删除员工
		@Override
		public int deleteAdmin(Employee emp) {
			System.out.println("删除员工：");
			int count=0;
			try {	
				SqlSession session=super.getSqlSession();
				IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
				count=dao.deleteAdmin(emp);
				System.out.println(count);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return count;
		}

		//修改员工
		@Override
		public int updateAdmin(Employee emp) {
			System.out.println("修改员工：");
			int count=0;
			try {
				SqlSession session=super.getSqlSession();
				IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
				count=dao.updateAdmin(emp);
				System.out.println(count);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			return count;
		}

	@Override
	public Employee queryId(int id) {
		System.out.println("根据id查询所有员工：");
		Employee all=null;
		try {	
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			all=dao.queryId(id);
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return all;
	}

	@Override
	public List<Employee> queryAll() {
		List<Employee> all=null;
		try {	
			SqlSession session=super.getSqlSession();
			IEmployeeDAO dao=session.getMapper(IEmployeeDAO.class);
			all=dao.queryAll();
			System.out.println(all);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return all;
	}
		
	
}
