package demo;

public class User_Role {
	int usersId;
	int roleId;
	public int getUsersId() {
		return usersId;
	}
	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public User_Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User_Role(int usersId, int roleId) {
		super();
		this.usersId = usersId;
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "User_Role [usersId=" + usersId + ", roleId=" + roleId + "]";
	}
	
}
