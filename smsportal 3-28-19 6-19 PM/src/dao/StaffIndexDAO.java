package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import vo.LoginVO;

public class StaffIndexDAO {
	
	public static String getMyStudents(LoginVO loginVO)
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String myStudent="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(studentVO.studentId) FROM StudentVO studentVO where loginId = :loginId");
				query.setParameter("loginId", loginVO.getId());
				
				Long count = (Long)query.uniqueResult();
				
				myStudent = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return myStudent;
	}
	
	
	public static String getPendingFutureSms(LoginVO loginVO)
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String pendingFutureSms="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(futureSmsVO.futureSmsId) FROM FutureSmsVO futureSmsVO where loginId = :loginId and isSent = 'no'");
				query.setParameter("loginId", loginVO.getId());
				
				Long count = (Long)query.uniqueResult();
				
				pendingFutureSms = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return pendingFutureSms;
	}
	
	
	public static String getMyGroup(LoginVO loginVO)
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String myGroup="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(groupNamesVO.groupNameId) FROM GroupNamesVO groupNamesVO where loginId = :loginId");
				query.setParameter("loginId", loginVO.getId());
				
				Long count = (Long)query.uniqueResult();
				
				myGroup = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return myGroup;
	}
	
	
	public static String getMySmsTemplates(LoginVO loginVO)
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String mySmsTemplates="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(smsTemplateVO.smsTemplateId) FROM SmsTemplateVO smsTemplateVO where loginId = :loginId");
				query.setParameter("loginId", loginVO.getId());
				
				Long count = (Long)query.uniqueResult();
				
				mySmsTemplates = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return mySmsTemplates;
	}
	
	
	public static String getStaffName(LoginVO loginVO)
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String staffName="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT staffVO.staffFirstName,staffVO.staffLastName FROM StaffVO staffVO where loginId = :loginId");
				query.setParameter("loginId", loginVO.getId());
				
				
				List<Object[]> staffs= (List<Object[]>)query.list();
				
				String firstName="";
				String lastName="";
				
				
			     for(Object[] staff: staffs){

			    	 firstName = (String)staff[0];
			    	 lastName = (String)staff[1];
			     }
				
				staffName = firstName+" "+lastName;
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return staffName;
	}
}
