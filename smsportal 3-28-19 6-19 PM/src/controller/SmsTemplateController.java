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

import dao.BranchDAO;
import dao.SmsTemplateDAO;
import vo.BranchVO;
import vo.LoginVO;
import vo.SemesterVO;
import vo.SmsTemplateVO;
import vo.StaffVO;
import vo.SmsTemplateVO;

/**
 * Servlet implementation class SmsTemplateController
 */
@WebServlet("/SmsTemplateController")
public class SmsTemplateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmsTemplateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchSmsTemplate"))
		{	
			searchSmsTemplate(request, response);
			response.sendRedirect("staff/viewSmsTemplate.jsp");
		}
		
		if(flag.equals("deleteSmsTemplate"))
		{	
			deleteSmsTemplate(request, response);
			searchSmsTemplate(request, response);
			response.sendRedirect("staff/viewSmsTemplate.jsp");
		}   
		
		if(flag.equals("editSmsTemplate"))
		{	
			editSmsTemplate(request,response);
			response.sendRedirect("staff/editSmsTemplate.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertSmsTemplate"))
		{	
			insertSmsTemplate(request,response);
			response.sendRedirect("staff/addSmsTemplate.jsp");
		}
		
		if(flag.equals("updateSmsTemplate"))
		{	
			updateSmsTemplate(request,response);
			searchSmsTemplate(request, response);
			response.sendRedirect("staff/viewSmsTemplate.jsp");
		}
		
	}

	protected void insertSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session=request.getSession();
			
			String smsTemplateName=(String)request.getParameter("smsTemplateName");
			String smsTemplateText=(String)request.getParameter("smsTemplateText");
			int loginId=(Integer)session.getAttribute("loginId");
			
			SmsTemplateVO smsTemplateVO=new SmsTemplateVO();
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			smsTemplateVO.setSmsTemplateName(smsTemplateName);
			smsTemplateVO.setSmsTemplateText(smsTemplateText);
			smsTemplateVO.setLoginVO(loginVO);
			
			SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
			smsTemplateDAO.insertSmsTemplate(smsTemplateVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void searchSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		HttpSession seesion=request.getSession();
		
		int loginId=(Integer)seesion.getAttribute("loginId");
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
		
		List<SmsTemplateVO> ls=smsTemplateDAO.searchSmsTemplate(loginVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("smsTemplateList",ls);

	}
	
	protected void deleteSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int smsTemplateId= Integer.parseInt(request.getParameter("smsTemplateId"));
		
		SmsTemplateVO smsTemplateVO=new SmsTemplateVO();
		
		smsTemplateVO.setSmsTemplateId(smsTemplateId);
		
		SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
		
		smsTemplateDAO.deleteSmsTemplate(smsTemplateVO);
		
	}   
	
	protected void editSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int smsTemplateId= Integer.parseInt(request.getParameter("smsTemplateId"));
		
		SmsTemplateVO smsTemplateVO=new SmsTemplateVO();
		
		smsTemplateVO.setSmsTemplateId(smsTemplateId);
		
		SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
		
		List<SmsTemplateVO> ls = smsTemplateDAO.editSmsTemplate(smsTemplateVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);
		
	}
	
	protected void updateSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			HttpSession seesion=request.getSession();
			
			String smsTemplateName=(String)request.getParameter("smsTemplateName");
			String smsTemplateText=(String)request.getParameter("smsTemplateText");
			int smsTemplateId= Integer.parseInt(request.getParameter("smsTemplateId"));
			
			int loginId=(Integer)seesion.getAttribute("loginId");
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			SmsTemplateVO smsTemplateVO=new SmsTemplateVO();
			
			smsTemplateVO.setSmsTemplateName(smsTemplateName);
			smsTemplateVO.setSmsTemplateText(smsTemplateText);
			smsTemplateVO.setSmsTemplateId(smsTemplateId);
			smsTemplateVO.setLoginVO(loginVO);
			
			SmsTemplateDAO smsTemplateDAO=new SmsTemplateDAO();
			smsTemplateDAO.updateSmsTemplate(smsTemplateVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
