package controller;

import java.io.IOException;
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
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 String flag = request.getParameter("flag");
		 
		 HttpSession session = request.getSession();
		 
			 if(flag.equals("login"))
			 {
			    String email = request.getParameter("username");
				String pass = request.getParameter("password");
	
				System.out.println(email + " " + pass);
	
				LoginVO loginVO = new LoginVO();
				loginVO.setEmail(email);
				loginVO.setPassword(pass);
	
				LoginDAO loginDAO = new LoginDAO();
	
				List<LoginVO> list = loginDAO.authentication(loginVO);
	
				if (list != null && list.size() >= 1) {
					LoginVO user = (LoginVO) list.get(0);
	
					int y = user.getId();
					session.setAttribute("loginId", y);
	
					String em = user.getEmail();
					session.setAttribute("Email", em);
	
					String type = user.getUserRoll();
					session.setAttribute("userType", type);
					System.out.println(y);
					
					session.removeAttribute("isPasswordCorrect");
					
					if (type.equalsIgnoreCase("admin")) {
						session.setAttribute("flag","loggedin");
						response.sendRedirect(request.getContextPath()+"/admin/index.jsp");
					} else if (type.equalsIgnoreCase("staff")) {
						session.setAttribute("flag","loggedin");
						response.sendRedirect(request.getContextPath()+"/staff/index.jsp");
					} else {
						session.setAttribute("isPasswordCorrect","NO");
						response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
					}
				} else {
					session.setAttribute("isPasswordCorrect","NO");
					response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
				}
	
			 }
		}

}
