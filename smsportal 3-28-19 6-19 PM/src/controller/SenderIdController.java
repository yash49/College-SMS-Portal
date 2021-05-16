package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BranchDAO;
import dao.SenderIdDAO;
import vo.BranchVO;
import vo.SenderIdVO;

/**
 * Servlet implementation class BranchController
 */
@WebServlet("/SenderIdController")
public class SenderIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SenderIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchSenderId"))
		{	
			searchSenderId(request, response);
			response.sendRedirect("admin/viewSenderId.jsp");
		}
		
		if(flag.equals("deleteSenderId"))
		{	
			deleteSenderId(request,response);
			searchSenderId(request, response);
			response.sendRedirect("admin/viewSenderId.jsp");
		}   
	
		if(flag.equals("editSenderId"))
		{	
			editSenderId(request,response);
			response.sendRedirect("admin/editSenderId.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertSenderId"))
		{	
			insertSenderId(request,response);
			searchSenderId(request, response);
			response.sendRedirect("admin/addSenderId.jsp");
		}
		
		if(flag.equals("updateSenderId"))
		{	
			updateSenderId(request,response);
			searchSenderId(request, response);
			response.sendRedirect("admin/viewSenderId.jsp");
		}    

		
	}
	
	protected void insertSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String senderIdName=(String)request.getParameter("senderIdName");
			
			SenderIdVO senderIdVO=new SenderIdVO();
			
			senderIdVO.setSenderIdName(senderIdName);
			
			SenderIdDAO senderIdDAO=new SenderIdDAO();
			
			senderIdDAO.insertSenderId(senderIdVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	protected void searchSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		SenderIdDAO senderIdDAO=new SenderIdDAO();
		
		List senderIdList=senderIdDAO.searchSenderId();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("senderIdList",senderIdList);

	}
	
	protected void deleteSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int senderId= Integer.parseInt(request.getParameter("senderId"));
		
		SenderIdVO senderIdVO=new SenderIdVO();
		
		senderIdVO.setSenderId(senderId);
		
		SenderIdDAO senderIdDAO=new SenderIdDAO();
		
		senderIdDAO.deleteSenderId(senderIdVO);
	}   
	
	protected void editSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		
		SenderIdVO senderIdVO=new SenderIdVO();
		senderIdVO.setSenderId(senderId);
		
		SenderIdDAO senderIdDAO=new SenderIdDAO();
		
		List ls = senderIdDAO.editSenderId(senderIdVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("senderIdList",ls);
		
	}
	
	protected void updateSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String senderIdName=(String)request.getParameter("senderIdName");
			int senderId=Integer.parseInt(request.getParameter("senderId"));
			
			SenderIdVO senderIdVO=new SenderIdVO();
			
			senderIdVO.setSenderId(senderId);
			senderIdVO.setSenderIdName(senderIdName);
			
			SenderIdDAO senderIdDAO=new SenderIdDAO();
			
			senderIdDAO.updateSenderId(senderIdVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
