package demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserRoleDAOImpl implements IUserRoleDAO {

	@Override
	public List<Role> selectUser(String roleName) {
		System.out.println("根据角色为管理员查询用户id和姓名：");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectUser(roleName);
			System.out.println("查询的id和姓名是："+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<Role> selectRole(int id) {
		System.out.println("根据角色为3的查询用户姓名和真实姓名：");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectRole(id);
			System.out.println("查询的结果是："+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<Role> selectNRole(int id) {
		System.out.println("根据角色不为3的查询用户姓名和真实姓名：");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectNRole(id);
			System.out.println("查询的结果是："+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public int RoleCount() {
		System.out.println("查询拥有角色的用户人数：");
		int count=0;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			count=dao.RoleCount();
			System.out.println("查询的记录是："+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<User> SelectRoleUser() {
		System.out.println("查询拥有角色超过两个的用户信息：");
		List<User> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.SelectRoleUser();
			System.out.println("查询的结果是："+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
