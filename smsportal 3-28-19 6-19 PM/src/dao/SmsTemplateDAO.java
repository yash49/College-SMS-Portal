package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.BranchVO;
import vo.LoginVO;
import vo.SmsTemplateVO;

public class SmsTemplateDAO {
	
	public void insertSmsTemplate(SmsTemplateVO smsTemplateVO) {
		
		SessionFactory sessionFactory=null;
		Session session=null;
		
		try
		{
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
			session = sessionFactory.openSession();
			
			Transaction transaction=session.beginTransaction();
			
			session.save(smsTemplateVO);
			
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
	
	public List<SmsTemplateVO> searchSmsTemplate(LoginVO loginVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List<SmsTemplateVO> ls=null;
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from SmsTemplateVO where loginId="+loginVO.getId());
				
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
	
	public void deleteSmsTemplate(SmsTemplateVO smsTemplateVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.delete(smsTemplateVO);
					
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
	
	public List editSmsTemplate(SmsTemplateVO smsTemplateVO)
	{		
		SessionFactory sessionFactory=null;
		Session session=null;
		
			List ls=null;
			try {
				
				sessionFactory = new Configuration().configure().buildSessionFactory();
				
				session = sessionFactory.openSession();
				
				Query q=session.createQuery("from SmsTemplateVO where smsTemplateId="+smsTemplateVO.getSmsTemplateId());
				
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

	public void updateSmsTemplate(SmsTemplateVO smsTemplateVO)
	{
		SessionFactory sessionFactory=null;
		Session session=null;
		
				try {
					
					sessionFactory = new Configuration().configure().buildSessionFactory();
					
					session = sessionFactory.openSession();
					
					Transaction transaction=session.beginTransaction();
					
					session.update(smsTemplateVO);
					
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
