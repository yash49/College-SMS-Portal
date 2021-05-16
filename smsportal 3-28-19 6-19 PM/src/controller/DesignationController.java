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
import dao.DesignationDAO;
import vo.BranchVO;
import vo.DesignationVO;

/**
 * Servlet implementation class DesignationController
 */
@WebServlet("/DesignationController")
public class DesignationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DesignationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchDesignation"))
		{	
			searchDesignation(request, response);
			response.sendRedirect("admin/viewDesignation.jsp");
		}
		
		if(flag.equals("deleteDesignation"))
		{	
			deleteDesignation(request,response);
			searchDesignation(request, response);
			response.sendRedirect("admin/viewDesignation.jsp");
		}   
		
		if(flag.equals("editDesignation"))
		{	
			editDesignation(request,response);
			response.sendRedirect("admin/editDesignation.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertDesignation"))
		{	
			insertDesignation(request,response);
			response.sendRedirect("admin/addDesignation.jsp");
		}
		
		if(flag.equals("updateDesignation"))
		{	
			updateDesignation(request,response);
			searchDesignation(request,response);
			response.sendRedirect("admin/viewDesignation.jsp");
		}
		
	}
	
	protected void insertDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			String designationName=(String)request.getParameter("designationName");
			String designationDescription=(String)request.getParameter("designationDescription");
			
			DesignationVO designationVO=new DesignationVO();
			
			designationVO.setDesignationName(designationName);
			designationVO.setDesignationDescription(designationDescription);
			
			DesignationDAO designationDAO=new DesignationDAO();
			
			designationDAO.insertDesignation(designationVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
	protected void searchDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		DesignationDAO designationDAO=new DesignationDAO();	
		
		List ls=designationDAO.searchDesignation();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);

	}
	
	protected void deleteDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int designationId= Integer.parseInt(request.getParameter("designationId"));
		
		DesignationVO designationVO=new DesignationVO();
		
		designationVO.setDesignationId(designationId);
		
		DesignationDAO designationDAO=new DesignationDAO();
		
		designationDAO.deleteDesignation(designationVO);
		
	}   
	
protected void editDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int designationId = Integer.parseInt(request.getParameter("designationId"));
		
		DesignationVO designationVO=new DesignationVO();
		designationVO.setDesignationId(designationId);
		
		DesignationDAO designationDAO=new DesignationDAO();
		
		List ls = designationDAO.editDesignation(designationVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("list",ls);
		
	}
	
	protected void updateDesignation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String designationName=(String)request.getParameter("designationName");
			String designationDescription=(String)request.getParameter("designationDescription");
			int designationId=Integer.parseInt(request.getParameter("designationId"));
			
			
			DesignationVO designationVO=new DesignationVO();
			
			designationVO.setDesignationName(designationName);
			designationVO.setDesignationDescription(designationDescription);
			designationVO.setDesignationId(designationId);
			
			DesignationDAO designationDAO=new DesignationDAO();
			
			designationDAO.updateDesignation(designationVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
