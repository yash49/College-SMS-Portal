package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.FeedbackVO;
import vo.FeedbackVO;
import vo.LoginVO;

public class FeedbackDAO {
	
	public void insertFeedback(FeedbackVO feedbackVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(feedbackVO);
			
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
	
	public List<FeedbackVO> searchFeedback(LoginVO loginVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<FeedbackVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q;
				
				String userType=loginVO.getUserRoll();
				
				if(userType.equals("staff"))
					q=session.createQuery("from FeedbackVO where loginId="+loginVO.getId());
				else
					q=session.createQuery("from FeedbackVO");
							
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

}
