package demo;

import java.util.List;

public interface IUserRoleDAO {
	//ʹ��SQL����ѯ��ɫ����Ϊ��super����Ա�����û�id������
	public List<Role> selectUser(String roleName);
		
	//ʹ��SQL����ѯ��ɫidΪ��3�����û�����������ʵ����
	public List<Role> selectRole(int id);
		
	//ʹ��SQL����ѯ��ɫid��Ϊ��3�����û�����������ʵ����
	public List<Role> selectNRole(int id);
	
	//��ѯӵ�н�ɫ���û�����
	public int RoleCount();

	//��ѯӵ�н�ɫ�����������û���Ϣ
	public List<User> SelectRoleUser();
}
