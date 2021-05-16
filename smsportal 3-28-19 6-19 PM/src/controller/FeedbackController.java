package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ComplainDAO;
import dao.FeedbackDAO;
import vo.ComplainVO;
import vo.FeedbackVO;
import vo.LoginVO;

/**
 * Servlet implementation class FeedbackController
 */
@WebServlet("/FeedbackController")
public class FeedbackController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchFeedback"))
		{	 
			HttpSession session=request.getSession();
			String userType=(String)session.getAttribute("userType");
			
			searchFeedback(request, response);
			
			if(userType.equals("staff"))
				response.sendRedirect("staff/viewFeedback.jsp");
			else
		    	response.sendRedirect("admin/viewFeedback.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=(String)request.getParameter("flag");
		
		if(flag.equals("insertFeedback"))
		{	
			insertFeedback(request,response);
			response.sendRedirect("staff/addFeedback.jsp");
		}

	}
	
	protected void insertFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession session=request.getSession();
			
			String feedbackSubject=(String)request.getParameter("feedbackSubject");
			String feedbackDescription=(String)request.getParameter("feedbackDescription");
			int starRating=Integer.parseInt(request.getParameter("rating"));
			
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			FeedbackVO feedbackVO=new FeedbackVO();
			
			feedbackVO.setFeedbackSubject(feedbackSubject);
			feedbackVO.setFeedbackDescription(feedbackDescription);
			feedbackVO.setStarRating(starRating);
			feedbackVO.setLoginVO(loginVO);
			
			FeedbackDAO feedbackDAO=new FeedbackDAO();
			
			feedbackDAO.insertFeedback(feedbackVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void searchFeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		HttpSession session=request.getSession();
		String userType=(String)session.getAttribute("userType");
		int loginId=(Integer)session.getAttribute("loginId");
		
		FeedbackDAO feedbackDAO=new FeedbackDAO();
		
		LoginVO loginVO=new LoginVO();
		loginVO.setUserRoll(userType);
		loginVO.setId(loginId);
		
		List<FeedbackVO> feedbackList=feedbackDAO.searchFeedback(loginVO);
		
		session.setAttribute("feedbackList",feedbackList);

	}

}
