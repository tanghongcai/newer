package demo;

import java.util.List;

import org.junit.Test;

public class TestDAO {
	@Test
	public void Testd(){
		IUserRoleDAO dao=new UserRoleDAOImpl();
		User users=new User();
		Role role=new Role();
		//��ѯ��ɫ����Ϊ��super����Ա�����û�id������
//		List<Role> list=dao.selectUser("����Ա");
//		System.out.println("ȫ����Ϣ"+list.toString());
//		System.out.println("�û�id��"+role.getUser().getUserId());
//		System.out.println("�û�������"+role.getUser().getUserName());
		
		
		//��ѯ��ɫidΪ��3�����û�����������ʵ����
//		List<Role> list=dao.selectRole(3);
//		System.out.println("ȫ����Ϣ"+list.toString());
//		System.out.println("�û�����"+role.getUser().getUserName());
//		System.out.println("��ʵ����"+role.getUser().getRealName());
		
		//��ѯ��ɫid��Ϊ��3�����û�����������ʵ����
//		List<Role> list=dao.selectNRole(3);
//		System.out.println("ȫ����Ϣ"+list.toString());
//		System.out.println("�û�����"+role.getUser().getUserName());
//		System.out.println("��ʵ����"+role.getUser().getRealName());
		
		//��ѯӵ�н�ɫ���û�����
//		int count=dao.RoleCount();
//		System.out.println("ӵ�н�ɫ���û�����"+count);
		
		//��ѯӵ�н�ɫ�����������û���Ϣ
		List<User> user=dao.SelectRoleUser();
		System.out.println("��ѯӵ�н�ɫ�����������û���Ϣ"+user.toString());
	}
}
