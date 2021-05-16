package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FutureSmsDAO;
import dao.SmsTemplateDAO;
import vo.FutureSmsVO;
import vo.LoginVO;
import vo.SmsTemplateVO;

/**
 * Servlet implementation class FutureSmsController
 */
@WebServlet("/FutureSmsController")
public class FutureSmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FutureSmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchFutureSms"))
		{	
			searchFutureSms(request, response);
			response.sendRedirect("staff/viewFutureSms.jsp");
		}
		
		if(flag.equals("deleteFutureSms"))
		{	
			deleteFutureSms(request, response);
			searchFutureSms(request, response);
			response.sendRedirect("staff/viewFutureSms.jsp");
		}   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");

		if(flag.equals("insertFutureSms"))
		{	
			String to=request.getParameter("to");

			if(to.equals("futureSms")){
				insertFutureSms(request,response);
				response.sendRedirect("staff/sendFutureSms.jsp");
			}
				
			
			if(to.equals("futureSmsViaPhonebook"))
			{	
				insertFutureSmsViaPhonebook(request,response);
				response.sendRedirect("staff/sendFutureSmsViaPhonebook.jsp");
			}
		} 
		
	}
	
	protected void insertFutureSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session = request.getSession();
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginId);
		
		String mobileNumber=request.getParameter("mobileNumber");
		String senderIdName=request.getParameter("senderIdName");
		String message=request.getParameter("message");
		String dateTime=request.getParameter("dateTime");
		//System.out.println(dateTime);
		
		ConvertingDateTime convertingDateTime = new ConvertingDateTime();
		long timestamp = convertingDateTime.convertToTimestamp(dateTime);
		
		FutureSmsVO futureSmsVO = new FutureSmsVO();
		
		futureSmsVO.setIsSent("no");
		futureSmsVO.setMobile(mobileNumber);
		futureSmsVO.setMessage(message);
		futureSmsVO.setSenderId(senderIdName);
		futureSmsVO.setLoginVO(loginVO);
		futureSmsVO.setTimestamp(timestamp);
		
		FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
		futureSmsDAO.insertFutureSms(futureSmsVO);
		
	}
	
	protected void insertFutureSmsViaPhonebook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session = request.getSession();
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginId);
		
		String mobileNumber[]=request.getParameterValues("mobileNumber");
		String senderIdName=request.getParameter("senderIdName");
		String message=request.getParameter("message");
		String dateTime=request.getParameter("dateTime");
		//System.out.println(dateTime);
		
		ConvertingDateTime convertingDateTime = new ConvertingDateTime();
		long timestamp = convertingDateTime.convertToTimestamp(dateTime);
		
		FutureSmsVO futureSmsVO = new FutureSmsVO();
		for (int j = 0; j < mobileNumber.length; j++) {
			
			futureSmsVO.setIsSent("no");
			futureSmsVO.setMobile(mobileNumber[j]);
			futureSmsVO.setMessage(message);
			futureSmsVO.setSenderId(senderIdName);
			futureSmsVO.setLoginVO(loginVO);
			futureSmsVO.setTimestamp(timestamp);
			
			FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
			futureSmsDAO.insertFutureSms(futureSmsVO);
			
		}
		
	}
	
	protected void searchFutureSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		HttpSession seesion=request.getSession();
		
		int loginId=(Integer)seesion.getAttribute("loginId");
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
		
		List<FutureSmsVO> ls=futureSmsDAO.searchFutureSms(loginVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("futureSmsList",ls);

	}
	
	protected void deleteFutureSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int futureSmsId= Integer.parseInt(request.getParameter("futureSmsId"));
		
		FutureSmsVO futureSmsVO = new FutureSmsVO();
		
		futureSmsVO.setFutureSmsId(futureSmsId);
		
		FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
		
		futureSmsDAO.deleteFutureSms(futureSmsVO);
	}   
	

}
