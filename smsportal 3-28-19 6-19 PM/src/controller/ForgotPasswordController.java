package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.LoginDAO;
import vo.LoginVO;

/**
 * Servlet implementation class ForgotPasswordController
 */
@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		LoginVO loginVO = new LoginVO();
		loginVO.setEmail(email);
		
		LoginDAO loginDAO = new LoginDAO();
		List<LoginVO> loginList = loginDAO.searchByEmail(loginVO);
		
		HttpSession session = request.getSession();
		
		if(loginList.size() > 0){
			session.setAttribute("messageStatus", true);
			String password = utils.BaseMethods.getPassword();
			
			session.setAttribute("OTP", password);
			
			String finalMSG="Hello User , Your OTP for Resetting Password for VPMP SMS Portal is "+password+".";
			utils.BaseMethods.sendMail(email, finalMSG);
			
				LoginVO loginVO2 = (LoginVO) loginList.get(0);
			//	System.out.println("%%%%%%%%%%%%%%%%%%%%   "+loginVO2.getId());
				
				session.setAttribute("loginIdForChangingPassword",loginVO2.getId());
				session.setAttribute("emailForChangingPassword",loginVO2.getEmail());
				session.setAttribute("userRollForChangingPassword",loginVO2.getUserRoll());
			
			
			
			
		}else{
			session.setAttribute("messageStatus", false);
		}
		response.sendRedirect("admin/json.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");
		
		HttpSession session = request.getSession();

		if(flag.equals("checkOTP"))
		{
				
				
				String otp = request.getParameter("otp");
				String actualotp = (String) session.getAttribute("OTP");
				
				if(otp.equals(actualotp))
				{
					response.sendRedirect("admin/resetPassword.jsp");
				}
				else 
				{
					response.sendRedirect("admin/login.jsp");
				}
			
			session.removeAttribute("OTP");
		
		}
		
		System.out.println("OOOOOOO  :  "+flag);
		
		if(flag.equals("checkResetPassword"))
		{
			
			String newPassword = request.getParameter("newPassword");
			String confirmNewPassword = request.getParameter("confirmNewPassword");
			
			int loginId=0;
			String email = "";
			String userRoll = "";
			
			
				loginId = (Integer) session.getAttribute("loginIdForChangingPassword");
				email = (String) session.getAttribute("emailForChangingPassword");
				userRoll = (String) session.getAttribute("userRollForChangingPassword");
			
		
			
			LoginVO loginVO = new LoginVO();
			
			loginVO.setId(loginId);
			
			loginVO.setEmail(email);
			loginVO.setUserRoll(userRoll);
			
			LoginDAO loginDAO = new LoginDAO();
			
			
			if(newPassword.equals(confirmNewPassword))
			{
				System.out.println(" YYYYYYYYY  "+newPassword);
				loginVO.setPassword(newPassword);
				loginDAO.resetPassword(loginVO);
			}
			
			session.removeAttribute("loginIdForChangingPassword");
			session.removeAttribute("emailForChangingPassword");
			session.removeAttribute("userRollForChangingPassword");
			
			response.sendRedirect("admin/login.jsp");
			
			
		}
		

		if(flag.equals("changePassword"))
		{
			String userType =(String) session.getAttribute("userType");
			
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String confirmNewPassword = request.getParameter("confirmNewPassword");
			
			int loginId=0;
			String email = "";
			String userRoll = "";
			
			LoginVO loginVO2 = new LoginVO();
			LoginDAO loginDAO = new LoginDAO();
			
			LoginVO loginVO = new LoginVO();
		
				loginId = (Integer) session.getAttribute("loginId");
				email = (String) session.getAttribute("Email");
				userRoll = (String) session.getAttribute("userType");
			
			loginVO2.setEmail(email);
			loginVO2.setPassword(oldPassword);
				
			List<LoginVO> list = loginDAO.authentication(loginVO2);
			
			System.out.println(loginId+"      "+"      "+email+"     "+userRoll+"      "+oldPassword+" ++++++++  List SIZE = "+list.size());
			
			if (list != null && list.size() >= 1) 
			{
				loginVO.setId(loginId);
				
				loginVO.setEmail(email);
				loginVO.setUserRoll(userRoll);
				
				System.out.println("+++++++  OLD PASSWORD VERIFIED  +++++++");
				
				System.out.println("+++++++  NEW PASS "+newPassword+" +++++++");
				System.out.println("+++++++  CONFIRM NEW PASS "+confirmNewPassword+" +++++++");
				
				if(newPassword.equals(confirmNewPassword))
				{
					System.out.println(" YYYYYYYYY  "+newPassword);
					loginVO.setPassword(newPassword);
					loginDAO.resetPassword(loginVO);
				}
				
				session.removeAttribute("loginIdForChangingPassword");
				session.removeAttribute("emailForChangingPassword");
				session.removeAttribute("userRollForChangingPassword");
				
				session.removeAttribute("isPasswordCorrect");
				
				
				if(userType.equals("staff"))
					response.sendRedirect("staff/index.jsp");
				
				if(userType.equals("admin"))
					response.sendRedirect("admin/index.jsp");
			}
			else
			{
				
				session.setAttribute("isPasswordCorrect","NO");
				
				if(userType.equals("staff"))
					response.sendRedirect("staff/changePasswordStaff.jsp");
				
				if(userType.equals("admin"))
					response.sendRedirect("admin/changePasswordAdmin.jsp");

			}
			
			
		}
		}
	}


