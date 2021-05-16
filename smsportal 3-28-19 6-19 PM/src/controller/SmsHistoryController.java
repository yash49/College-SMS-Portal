package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import dao.FeedbackDAO;
import dao.SemesterDAO;
import dao.SmsHistoryDAO;
import dao.StaffIndexDAO;
import vo.FeedbackVO;
import vo.LoginVO;
import vo.SemesterVO;
import vo.SmsHistoryVO;
import vo.SmsTemplateVO;

/**
 * Servlet implementation class SmsHistoryController
 */
@WebServlet("/SmsHistoryController")
public class SmsHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmsHistoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String flag=request.getParameter("flag");
		
		if(flag.equals("searchSmsHistory"))
		{	 
			searchSmsHistory(request, response);
			response.sendRedirect("staff/viewSmsHistory.jsp");
		
		}
		
		if(flag.equals("searchSmsHistoryByAdmin"))
		{	 
			searchSmsHistoryByAdmin(request, response);
			response.sendRedirect("admin/viewSmsHistory.jsp");
		
		}
		
		if(flag.equals("deleteSmsHistory"))
		{	 
			deleteSmsHistory(request, response);
			response.sendRedirect("StaffController?flag=searchStaff&to=viewSmsHistory");
		
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void searchSmsHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session=request.getSession();
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		SmsHistoryDAO smsHistoryDAO=new SmsHistoryDAO();
		
		LoginVO loginVO=new LoginVO();
	
		loginVO.setId(loginId);
		
		List<SmsHistoryVO> smsHistoryList=smsHistoryDAO.searchSmsHistory(loginVO);
		
		session.setAttribute("smsHistoryList",smsHistoryList);

	}
	protected void searchSmsHistoryByAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session=request.getSession();
		
		int loginId=Integer.parseInt(request.getParameter("loginId"));
		
		SmsHistoryDAO smsHistoryDAO=new SmsHistoryDAO();
		
		LoginVO loginVO=new LoginVO();
	
		loginVO.setId(loginId);
		
		List<SmsHistoryVO> smsHistoryList=smsHistoryDAO.searchSmsHistory(loginVO);
		
		session.setAttribute("smsHistoryList",smsHistoryList);
		
		String staffName = StaffIndexDAO.getStaffName(loginVO);
		
		session.setAttribute("staffName",staffName);

		
		
	}
	protected void deleteSmsHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int loginId= Integer.parseInt(request.getParameter("loginId"));
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		SmsHistoryVO smsHistoryVO = new SmsHistoryVO();
		smsHistoryVO.setLoginVO(loginVO);

		SmsHistoryDAO smsHistoryDAO = new SmsHistoryDAO();
		smsHistoryDAO.deleteSmsHistory(smsHistoryVO);
	}  
}
