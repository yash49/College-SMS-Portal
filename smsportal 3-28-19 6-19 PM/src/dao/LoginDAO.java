package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.LoginVO;
import vo.StaffVO;

public class LoginDAO {
	
	public List authentication(LoginVO loginVO){
		
		List ls = new ArrayList<>();
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Query q=session.createQuery("from LoginVO where email = :email and password = :password");
			q.setParameter("email", loginVO.getEmail());
			q.setParameter("password", loginVO.getPassword());
			
			ls = q.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		
		return ls;
	}

	public List searchByEmail(LoginVO loginVO) {

		List ls = new ArrayList<>();
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Query q=session.createQuery("from LoginVO where email = :email");
			q.setParameter("email", loginVO.getEmail());
			ls = q.list();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
		
		return ls;
	}
	
	public void resetPassword(LoginVO loginVO)
	{
			SessionFactory sessionFactory=null;
			Session session=null;
			
				try {
					 sessionFactory = new Configuration().configure().buildSessionFactory();
					
					 session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(loginVO);
					
					transaction.commit();
					
					
					
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					session.close();
					sessionFactory.close();
				}
	}
}
