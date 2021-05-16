package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.ComplainVO;
import vo.LoginVO;
import vo.SenderIdVO;

public class ComplainDAO {
	
	public void insertComplain(ComplainVO complainVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();

			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(complainVO);
			
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
	public List<ComplainVO> searchComplain(LoginVO loginVO)
	{
			
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<ComplainVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q;
				
				String userType=loginVO.getUserRoll();
				
				if(userType.equals("staff"))
					q=session.createQuery("from ComplainVO where loginId="+loginVO.getId());
				else
					q=session.createQuery("from ComplainVO");
							
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
	
	public List editComplain(ComplainVO complainVO)
	{		
			List ls=null;
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from ComplainVO where complainId="+complainVO.getComplainId());
				
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
	
	public void updateComplain(ComplainVO complainVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(complainVO);
					
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
	
	public void deleteComplain(ComplainVO complainVO)
	{	
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					 sessionFactory = new Configuration().configure().buildSessionFactory();
						
					 session = sessionFactory.openSession();
					 
					Transaction transaction=session.beginTransaction();
					
					session.delete(complainVO);
					
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
