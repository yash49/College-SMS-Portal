package controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BranchDAO;
import dao.DesignationDAO;
import dao.StaffDAO;
import vo.*;

/**
 * Servlet implementation class StaffController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
		
		if(flag.equals("loadDesignationAndBranch"))
		{	
			loadDesignation(request,response);
			loadBranch(request,response);
			response.sendRedirect("admin/addStaff.jsp");		
		}
		
		if(flag.equals("searchStaff"))
		{	
			String to=request.getParameter("to");
			searchStaff(request, response);
			if(to.equals("viewSmsHistory"))
				response.sendRedirect("admin/viewStaffForHistory.jsp");
			if(to.equals("viewStaff"))
				response.sendRedirect("admin/viewStaff.jsp");
		}
		
		if(flag.equals("deleteStaff"))
		{	
			deleteStaff(request,response);
			searchStaff(request, response);
			response.sendRedirect("admin/viewStaff.jsp");
		} 
		
		if(flag.equals("editStaff"))
		{	
			editStaff(request,response);
			loadDesignation(request,response);
			loadBranch(request,response);
			response.sendRedirect("admin/editStaff.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertStaff"))
		{	
			insertStaff(request,response);
			response.sendRedirect("admin/addStaff.jsp");
		}
		
		if(flag.equals("updateStaff"))
		{	
			updateStaff(request,response);
			searchStaff(request, response);
			response.sendRedirect("admin/viewStaff.jsp");
		}
		
		if(flag.equals("updatePassword"))
		{	
			updatePassword(request,response);
			response.sendRedirect("staff/index.jsp");
		}
		
	}
	
	protected void loadBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		BranchDAO branchDAO=new BranchDAO();
		
		List branchList=branchDAO.searchBranch();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("branchList",branchList);
	}
	
	protected void loadDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		DesignationDAO designationDAO=new DesignationDAO();
		
		List designationList=designationDAO.searchDesignation();
		
		HttpSession session=request.getSession();
	
		session.setAttribute("designationList",designationList);
		
	}
	
	protected void insertStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String staffFirstName=(String)request.getParameter("staffFirstName");
			String staffLastName=(String)request.getParameter("staffLastName");
			String staffMobile=(String)request.getParameter("staffMobile");
			String staffEmail=(String)request.getParameter("staffEmail");
			String staffGender=request.getParameter("staffGender");
			String staffDesignation=(String)request.getParameter("staffDesignation");
			String staffBranch=(String)request.getParameter("staffBranch");
			String staffAddress=(String)request.getParameter("staffAddress");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setEmail(staffEmail);
			loginVO.setUserRoll("staff");
			
			SendPassword sendPassword=new SendPassword();
			loginVO.setPassword(sendPassword.sendPassword(staffMobile,loginVO));
	
			StaffDAO staffDAO=new StaffDAO();
			
			staffDAO.insertLogin(loginVO);
			
			StaffVO staffVO=new StaffVO();
			
			staffVO.setStaffFirstName(staffFirstName);
			staffVO.setStaffLastName(staffLastName);
			staffVO.setStaffDesignation(staffDesignation);
			staffVO.setStaffBranch(staffBranch);
			staffVO.setStaffGender(staffGender);
			staffVO.setStaffMobile(staffMobile);
			staffVO.setStaffAddress(staffAddress);
			staffVO.setLoginVO(loginVO);
			
			staffDAO.insertStaff(staffVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	

	protected void searchStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		StaffDAO staffDAO=new StaffDAO();
		
		List staffList=staffDAO.searchStaff();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("staffList",staffList);
		
		List loginList=staffDAO.searchLogin();
		
		session.setAttribute("loginList",loginList);

	}

	protected void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int staffId=Integer.parseInt(request.getParameter("staffId"));
		int loginId=Integer.parseInt(request.getParameter("loginId"));
		
		StaffDAO staffDAO=new StaffDAO();
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		staffDAO.deleteLogin(loginVO);
		
		StaffVO staffVO=new StaffVO();
		staffVO.setStaffId(staffId);
		staffDAO.deleteStaff(staffVO);
		
	}

	protected void editStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int staffId=Integer.parseInt(request.getParameter("staffId"));
		
		StaffVO staffVO=new StaffVO();
		staffVO.setStaffId(staffId);
		
		StaffDAO staffDAO=new StaffDAO();
		
		List staffList=staffDAO.editStaff(staffVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("staffList",staffList);
	}
	protected void updateStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {

			StaffDAO staffDAO=new StaffDAO();
			
			int staffId=Integer.parseInt(request.getParameter("staffId"));
			String staffFirstName=(String)request.getParameter("staffFirstName");
			String staffLastName=(String)request.getParameter("staffLastName");
			String staffMobile=(String)request.getParameter("staffMobile");
			String staffGender=(String)request.getParameter("staffGender");
			String staffDesignation=(String)request.getParameter("staffDesignation");
			String staffBranch=(String)request.getParameter("staffBranch");
			String staffAddress=(String)request.getParameter("staffAddress");
			
			int loginId=Integer.parseInt(request.getParameter("loginId"));
			String staffEmail=(String)request.getParameter("staffEmail");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			loginVO.setEmail(staffEmail);
			loginVO.setUserRoll("staff");
			String loginPassword=request.getParameter("loginPassword");
			loginVO.setPassword(loginPassword);
			
			staffDAO.updateLogin(loginVO);
			
			StaffVO staffVO=new StaffVO();
			staffVO.setStaffId(staffId);
			staffVO.setStaffFirstName(staffFirstName);
			staffVO.setStaffLastName(staffLastName);
			staffVO.setStaffDesignation(staffDesignation);
			staffVO.setStaffBranch(staffBranch);
			staffVO.setStaffGender(staffGender);
			staffVO.setStaffMobile(staffMobile);
			staffVO.setStaffAddress(staffAddress);
			staffVO.setLoginVO(loginVO);
			
			staffDAO.updateStaff(staffVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session=request.getSession();
			
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

