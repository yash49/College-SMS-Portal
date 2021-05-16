package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.*;

public class StaffDAO {
	
	public void insertLogin(LoginVO loginVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		    session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(loginVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	public void insertStaff(StaffVO staffVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		    session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(staffVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		}
	
	public List<StaffVO> searchStaff()
	{
			SessionFactory sessionFactory=null;
			Session session=null;
		
			List<StaffVO> ls=null;
			try {
				 sessionFactory = new Configuration().configure().buildSessionFactory();		
				
				 session = sessionFactory.openSession();
				
				Query q=session.createQuery("from StaffVO");
				
				ls = q.list();
				
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();
			}
			
		return ls;
	}
	
public void deleteLogin(LoginVO loginVO) {
	
		SessionFactory sessionFactory=null;
		Session session=null;
	
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(loginVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		}

	public void deleteStaff(StaffVO staffVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.delete(staffVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		}
	
	public void updateStaff(StaffVO staffVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(staffVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		}
	public void updateLogin(LoginVO loginVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(loginVO);
			
			transaction.commit();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		}
	public List<StaffVO> editStaff(StaffVO staffVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<StaffVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from StaffVO where staffId="+staffVO.getStaffId());
				
				ls = q.list();

			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();
			}
			
			return ls;
	}
	
	public List<LoginVO> searchLogin()
	{
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<LoginVO> ls=null;
			try {
				 sessionFactory = new Configuration().configure().buildSessionFactory();
				
				 session = sessionFactory.openSession();
				
				Query q=session.createQuery("from LoginVO");
				
				ls = q.list();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();
			}
			
		return ls;
	}
	public void updatePassword(LoginVO loginVO,String newPassword) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			String hqlUpdate = "update LoginVO set password = :newPassword where id = :loginId";
			
			Query q = session.createQuery( hqlUpdate );
			
			String loginId=Integer.toString(loginVO.getId());
			
	        q.setString( "newPassword", newPassword);
	        q.setString( "loginId", loginId);
	        q.executeUpdate();
			
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
