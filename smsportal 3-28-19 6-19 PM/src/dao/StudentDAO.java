package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.LoginVO;
import vo.StudentVO;

public class StudentDAO {
	
	static SessionFactory sessionFactory = BaseMethods.getSessionFactory();
	//static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();	
	public void insertStudent(StudentVO studentVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(studentVO);
			
			transaction.commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}
	

	public List<StudentVO> searchStudent(LoginVO loginVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<StudentVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from StudentVO where loginId="+loginVO.getId());
				
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
	
	public void deleteStudent(StudentVO studentVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			System.out.println("//////////"+studentVO.getStudentId());
			
			session.delete(studentVO);
			
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
	public List<StudentVO> editStudent(StudentVO studentVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<StudentVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from StudentVO where studentId="+studentVO.getStudentId());
				
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
	public void updateStudent(StudentVO studentVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.update(studentVO);
			
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
