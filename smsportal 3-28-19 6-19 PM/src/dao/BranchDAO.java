package dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

import vo.BranchVO;

public class BranchDAO {
	
	public void insertBranch(BranchVO branchVO) {
			
			SessionFactory sessionFactory=null;
			Session session=null;
			try {
				 sessionFactory = new Configuration().configure().buildSessionFactory();
					
				 session = sessionFactory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.save(branchVO);
				
				transaction.commit();

				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				session.close();
				sessionFactory.close();
			}
		}
		
	
	public List<BranchVO> searchBranch()
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<BranchVO> ls = null;
			try {
				 sessionFactory = new Configuration().configure().buildSessionFactory();
				
				 session = sessionFactory.openSession();
				
				Query q=session.createQuery("from BranchVO");
				
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
	
	public void deleteBranch(BranchVO branchVO)
	{	
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					 sessionFactory = new Configuration().configure().buildSessionFactory();
						
					 session = sessionFactory.openSession();
					 
					Transaction transaction=session.beginTransaction();
					
					session.delete(branchVO);
					
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
	
	public List editBranch(BranchVO branchVO)
	{		
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			List ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from BranchVO where branchId="+branchVO.getBranchId());
				
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



	public void updateBranch(BranchVO branchVO)
	{
			SessionFactory sessionFactory=null;
			Session session=null;
			
				try {
					 sessionFactory = new Configuration().configure().buildSessionFactory();
					
					 session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(branchVO);
					
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
