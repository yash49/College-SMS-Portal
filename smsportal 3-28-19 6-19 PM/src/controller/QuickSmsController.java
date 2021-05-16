package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import vo.LoginVO;
import vo.StudentVO;

/**
 * Servlet implementation class QuickSMS
 */
@WebServlet("/QuickSmsController")
public class QuickSmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuickSmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");

		if(flag.equals("sendQuickSms"))
		{	
			sendQuickSms(request,response);
			response.sendRedirect("staff/sendQuickSms.jsp");
		} 
		if(flag.equals("sendQuickSmsViaPhonebook"))
		{	
			sendQuickSmsViaPhonebook(request,response);
			response.sendRedirect("staff/sendQuickSmsViaPhonebook.jsp");
		} 
	}
	protected void sendQuickSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String mobileNumber=request.getParameter("mobileNumber");
		String senderIdName=request.getParameter("senderIdName");
		String message=request.getParameter("message");
		
		HttpSession session=request.getSession();
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		System.out.println(senderIdName);
		
		SendSms sendSMS=new SendSms();
		sendSMS.sendSMS(mobileNumber, message,senderIdName,loginVO);
		
	}
	protected void sendQuickSmsViaPhonebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String mobileNumber[]=request.getParameterValues("mobileNumber");
		
		String senderIdName=request.getParameter("senderIdName");
		String message=request.getParameter("message");
		String mobile="";
		System.out.println(senderIdName);
		
		HttpSession session=request.getSession();
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		SendSms sendSMS=new SendSms();
		for(int i=0;i<mobileNumber.length;i++)
		{
				mobile=mobile+mobileNumber[i]+",";	
		}
		
		sendSMS.sendSMS(mobile, message,senderIdName,loginVO);	
	}
	
}
