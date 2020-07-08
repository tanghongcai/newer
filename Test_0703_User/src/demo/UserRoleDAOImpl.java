package demo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserRoleDAOImpl implements IUserRoleDAO {

	@Override
	public List<Role> selectUser(String roleName) {
		System.out.println("���ݽ�ɫΪ����Ա��ѯ�û�id��������");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectUser(roleName);
			System.out.println("��ѯ��id�������ǣ�"+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<Role> selectRole(int id) {
		System.out.println("���ݽ�ɫΪ3�Ĳ�ѯ�û���������ʵ������");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectRole(id);
			System.out.println("��ѯ�Ľ���ǣ�"+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public List<Role> selectNRole(int id) {
		System.out.println("���ݽ�ɫ��Ϊ3�Ĳ�ѯ�û���������ʵ������");
		List<Role> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.selectNRole(id);
			System.out.println("��ѯ�Ľ���ǣ�"+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

	@Override
	public int RoleCount() {
		System.out.println("��ѯӵ�н�ɫ���û�������");
		int count=0;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			count=dao.RoleCount();
			System.out.println("��ѯ�ļ�¼�ǣ�"+count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<User> SelectRoleUser() {
		System.out.println("��ѯӵ�н�ɫ�����������û���Ϣ��");
		List<User> all=null;
		try {
			SqlSession session=MybatisUtil.getSqlSession();
			IUserRoleDAO dao=session.getMapper(IUserRoleDAO.class);
			all=dao.SelectRoleUser();
			System.out.println("��ѯ�Ľ���ǣ�"+all.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return all;
	}

}
