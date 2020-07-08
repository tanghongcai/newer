package demo;

import java.util.List;

import org.junit.Test;

public class TestDAO {
	@Test
	public void Testd(){
		IUserRoleDAO dao=new UserRoleDAOImpl();
		User users=new User();
		Role role=new Role();
		//查询角色名称为’super管理员’的用户id和姓名
//		List<Role> list=dao.selectUser("管理员");
//		System.out.println("全部信息"+list.toString());
//		System.out.println("用户id："+role.getUser().getUserId());
//		System.out.println("用户姓名："+role.getUser().getUserName());
		
		
		//查询角色id为’3’的用户姓名和其真实姓名
//		List<Role> list=dao.selectRole(3);
//		System.out.println("全部信息"+list.toString());
//		System.out.println("用户姓名"+role.getUser().getUserName());
//		System.out.println("真实姓名"+role.getUser().getRealName());
		
		//查询角色id不为’3’的用户姓名和其真实姓名
//		List<Role> list=dao.selectNRole(3);
//		System.out.println("全部信息"+list.toString());
//		System.out.println("用户姓名"+role.getUser().getUserName());
//		System.out.println("真实姓名"+role.getUser().getRealName());
		
		//查询拥有角色的用户人数
//		int count=dao.RoleCount();
//		System.out.println("拥有角色的用户人数"+count);
		
		//查询拥有角色超过两个的用户信息
		List<User> user=dao.SelectRoleUser();
		System.out.println("查询拥有角色超过两个的用户信息"+user.toString());
	}
}
