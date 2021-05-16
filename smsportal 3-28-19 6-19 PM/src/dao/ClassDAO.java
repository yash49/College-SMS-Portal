package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.ClassVO;

public class ClassDAO {

	
	public void insertClass(ClassVO classVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(classVO);
			
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
	
	public List<ClassVO> searchClass()
	{
			SessionFactory sessionFactory=null;
			Session session=null;
			
			List<ClassVO> ls = null;
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from ClassVO");
				
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
	
	public void deleteClass(ClassVO classVO)
	{
			
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.delete(classVO);
					
					transaction.commit();
					
					sessionFactory.close();
				} catch (HibernateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					session.close();
					sessionFactory.close();
				}
			} 
	
	public List editClass(ClassVO classVO)
	{			
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from ClassVO where classId="+classVO.getClassId());
				
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

	public void updateClass(ClassVO classVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(classVO);
					
					transaction.commit();
					
					session.close();
					
					sessionFactory.close();
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
