package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.GroupMembersVO;
import vo.GroupNamesVO;
import vo.LoginVO;
import vo.StudentVO;

public class GroupSmsDAO {

	public void insertGroupName(GroupNamesVO groupNamesVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(groupNamesVO);
			
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public void insertGroupMembers(GroupMembersVO groupMembersVO,String studentId[]) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			StudentVO studentVO=new StudentVO();
			
			for (String i : studentId) 
			{	
				int stu_id=Integer.parseInt(i);
				studentVO.setStudentId(stu_id);
				groupMembersVO.setStudentVO(studentVO);
				session.save(groupMembersVO);
				session.flush();
				session.clear();
			}
				
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public List<GroupNamesVO> searchGroupNames(LoginVO loginVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<GroupNamesVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from GroupNamesVO where loginId="+loginVO.getId());
				
				ls = q.list();

			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
			
			return ls;
	}
	public List<GroupNamesVO> editGroupNames(GroupNamesVO groupNamesVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<GroupNamesVO> ls=null;
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from GroupNamesVO where groupNameId="+groupNamesVO.getGroupNameId());
				
				ls = q.list();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
			
			return ls;
	}
	public List<GroupMembersVO> searchGroupMembers(GroupNamesVO groupNamesVO)
	{	
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<GroupMembersVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from GroupMembersVO where groupNameId="+groupNamesVO.getGroupNameId());
				
				ls = q.list();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
			
			return ls;
	}
	public List<StudentVO> editGroup(GroupNamesVO groupNamesVO)
	{	
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<StudentVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("select studentVO from GroupMembersVO where groupNameId="+groupNamesVO.getGroupNameId());
				
				ls = q.list();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
			
			return ls;
	}
	public void deleteGroupMembers(GroupMembersVO groupMembersVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(groupMembersVO);
			
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	public void deleteGroup(GroupNamesVO groupNamesVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(groupNamesVO);
			
			transaction.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
}
