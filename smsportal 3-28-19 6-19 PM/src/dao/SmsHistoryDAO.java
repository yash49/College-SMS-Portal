package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.FeedbackVO;
import vo.LoginVO;
import vo.SmsHistoryVO;
import vo.SmsTemplateVO;

public class SmsHistoryDAO {

	public void insertSmsHistory(SmsHistoryVO smsHistoryVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;

		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(smsHistoryVO);
			
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
	
	public List<SmsHistoryVO> searchSmsHistory(LoginVO loginVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;

			List<SmsHistoryVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q;
				
				String userType=loginVO.getUserRoll();
				
					q=session.createQuery("from SmsHistoryVO where loginId="+loginVO.getId());
							
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
	public void deleteSmsHistory(SmsHistoryVO smsHistoryVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;

				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					Query q=session.createQuery("delete SmsHistoryVO where loginId = :login_id");
					q.setParameter("login_id", smsHistoryVO.getLoginVO().getId());
					
					q.executeUpdate();
					
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
