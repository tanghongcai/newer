package demo;

import java.util.List;

public interface IUserRoleDAO {
	//使用SQL语句查询角色名称为’super管理员’的用户id和姓名
	public List<Role> selectUser(String roleName);
		
	//使用SQL语句查询角色id为’3’的用户姓名和其真实姓名
	public List<Role> selectRole(int id);
		
	//使用SQL语句查询角色id不为’3’的用户姓名和其真实姓名
	public List<Role> selectNRole(int id);
	
	//查询拥有角色的用户人数
	public int RoleCount();

	//查询拥有角色超过两个的用户信息
	public List<User> SelectRoleUser();
}
