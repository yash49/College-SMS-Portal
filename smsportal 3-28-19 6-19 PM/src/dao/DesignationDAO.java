package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.DesignationVO;

public class DesignationDAO {

	public void insertDesignation(DesignationVO designationVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(designationVO);
			
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
	
	public List searchDesignation()
	{
			List ls=null;
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from DesignationVO");
				
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
	
	public void deleteDesignation(DesignationVO designationVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.delete(designationVO);
					
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
	public List editDesignation(DesignationVO designationVO)
	{		
			List ls=null;
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from DesignationVO where designationId="+designationVO.getDesignationId());
				
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



	public void updateDesignation(DesignationVO designationVO)
	{
				
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(designationVO);
					
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
