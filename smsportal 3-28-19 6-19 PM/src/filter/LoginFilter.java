package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import vo.LoginVO;


 // Servlet Filter implementation class LoginFilter
 
@WebFilter("/*") // Add /* to activate filter
public class LoginFilter implements Filter {

	//private ServletResponse response;

	// Default constructor.
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	 // @see Filter#destroy()
	public void destroy() {
		// TODO Auto-generated method stub
	}

	 // @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		
		
		String flag = (String)session.getAttribute("flag");
		System.out.println("flag    ::::    "+flag);
	
		String uri = ((HttpServletRequest) request).getRequestURI();
		
		System.out.println("<<<<<Before >>>>>>>" + uri);

	
		String h = (String) session.getAttribute("userType");
		
		if (uri.contains("register") || uri.contains("/login.jsp") || uri.contains("/forgotPassword.jsp") || uri.contains("/roboto") || uri.contains("/css")
				|| uri.contains("/js") && !uri.contains(".jsp") || uri.contains("/img") || uri.contains("/images")
				  || uri.contains("/fonts") || uri.contains("/ForgotPasswordController")  || uri.contains("/resetPassword.jsp") || uri.contains("/json.jsp") || uri.contains("/LogoutController") || uri.contains("/LoginController")
				  		|| uri.contains("/error-404.jsp")) 
		{
			System.out.println("<<<<<After >>>>>>>" + uri);
			chain.doFilter(request, response);
		}else if (session.getAttribute("loginId") != null && flag.equals("loggedin") && h != null && !h.equals("")) {
				

				if (h != null && h.equals("admin")) {
					chain.doFilter(request, response);
				} else if (h != null && h.equals("staff")) {
					chain.doFilter(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
					rd.forward(request, response);
				}
			
		}
	
		if (!(uri.contains("register") || uri.contains("/login.jsp") || uri.contains("/forgotPassword.jsp") || uri.contains("/roboto") || uri.contains("/css")
				|| uri.contains("/js") && !uri.contains(".jsp") || uri.contains("/img") || uri.contains("/images")
				  || uri.contains("/fonts")	|| uri.contains("/ForgotPasswordController") || uri.contains("/resetPassword.jsp")|| uri.contains("/error-404.jsp") || uri.contains("/json.jsp") || uri.contains("/LogoutController") || uri.contains("/LoginController")))
		{
			if(flag == null)
			{
				requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	
		

	}

	 // @see Filter#init(FilterConfig)
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
