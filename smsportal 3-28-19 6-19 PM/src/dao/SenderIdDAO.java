package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

import vo.BranchVO;
import vo.SenderIdVO;

public class SenderIdDAO {
	
	static SessionFactory sessionFactory = BaseMethods.getSessionFactory();
	//static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
	public void insertSenderId(SenderIdVO senderIdVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(senderIdVO);
			
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
	
	
	public List<SenderIdVO> searchSenderId()
	{
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<SenderIdVO> ls=null;
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from SenderIdVO");
				
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
	
	public void deleteSenderId(SenderIdVO senderIdVO)
	{			
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.delete(senderIdVO);
					
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

	public List editSenderId(SenderIdVO senderIdVO)
	{		
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from SenderIdVO where senderId="+senderIdVO.getSenderId());
				
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



	public void updateSenderId(SenderIdVO senderIdVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(senderIdVO);
					
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
