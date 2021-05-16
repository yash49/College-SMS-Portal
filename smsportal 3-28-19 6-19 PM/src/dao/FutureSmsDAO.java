package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.FutureSmsVO;
import vo.LoginVO;
import vo.SmsTemplateVO;

public class FutureSmsDAO {
	
	public void insertFutureSms(FutureSmsVO futureSmsVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(futureSmsVO);
			
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
	
	public List<FutureSmsVO> searchFutureSms(LoginVO loginVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<FutureSmsVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from FutureSmsVO where loginId="+loginVO.getId());
				
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
	
	public List<FutureSmsVO> getFutureSms() throws IllegalStateException
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<FutureSmsVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from FutureSmsVO");
				
				ls = q.list();
				
				session.close();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				
				sessionFactory.close();
			}
			
		return ls;
	}
	
	public void deleteFutureSms(FutureSmsVO futureSmsVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.delete(futureSmsVO);
					
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
	
	public void updateFutureSms(FutureSmsVO futureSmsVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(futureSmsVO);
					
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
