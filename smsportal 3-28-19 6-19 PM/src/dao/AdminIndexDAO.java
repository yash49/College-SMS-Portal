package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AdminIndexDAO {

	public static ArrayList<Object[]> getGraphData()
	{
			 
			SessionFactory sessionFactory=null;
			Session session=null;
			
			List ls=null;
			ArrayList<Object[]> studentBranchList = new ArrayList<Object[]>();
			
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				
				Query q=session.createQuery("SELECT COUNT(studentVO.studentId),studentVO.branchVO.branchName FROM StudentVO studentVO GROUP BY studentVO.branchVO.branchId");
			//	"SELECT student.course, COUNT(student.course) FROM Student student GROUP BY student.course"
			
				
				ls = q.list();
				
				for(Iterator it=q.iterate();it.hasNext();)
				  {
					
				   Object[] row = (Object[]) it.next();
				   
				   studentBranchList.add(row);
				 
				   /*System.out.print("Branch Name: " + row[1]);
				   System.out.println(" | Number of Students: " + row[0]);*/
				  }
		
				
			
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return studentBranchList;
	}
	
	
	public static String getTotalSms()
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String totalSms="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(smsHistoryVO.smsHistoryId) FROM SmsHistoryVO smsHistoryVO");
				
				Long count = (Long)query.uniqueResult();
				
				totalSms = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return totalSms;
	}
	
	public static String getTotalStaff()
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String totalStaff="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(staffVO.staffId) FROM StaffVO staffVO");
				
				Long count = (Long)query.uniqueResult();
				
				totalStaff = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return totalStaff;
	}
	
	public static String getTotalPendingComplains()
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String pendingComplains="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(complainVO.complainId) FROM ComplainVO complainVO where complainStatus = 'PENDING'");
				
				Long count = (Long)query.uniqueResult();
				
				pendingComplains = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return pendingComplains;
	}
	
	
	public static String getTotalSenderId()
	{
			
			SessionFactory sessionFactory=null;
			Session session=null;
			
			
			String totalSenderId="";
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();

				session = sessionFactory.openSession();
				Query query = session.createQuery("SELECT COUNT(senderIdVO.senderId) FROM SenderIdVO senderIdVO");
				
				Long count = (Long)query.uniqueResult();
				
				totalSenderId = count.toString();
				
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				session.close();
				sessionFactory.close();

			}
			
			return totalSenderId;
	}
	
}
