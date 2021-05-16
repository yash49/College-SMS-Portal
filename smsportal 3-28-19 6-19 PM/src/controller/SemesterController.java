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
import dao.SemesterDAO;
import dao.SenderIdDAO;
import vo.BranchVO;
import vo.SemesterVO;

/**
 * Servlet implementation class SemController
 */
@WebServlet("/SemesterController")
public class SemesterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SemesterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
	
		if(flag.equals("searchSemester"))
		{	
			searchSemester(request, response);
			response.sendRedirect("admin/viewSemester.jsp");
		}
		
		if(flag.equals("deleteSemester"))
		{	
			deleteSemester(request,response);
			searchSemester(request, response);
			response.sendRedirect("admin/viewSemester.jsp");
		}   
		
		if(flag.equals("editSemester"))
		{	
			editSemester(request,response);
			response.sendRedirect("admin/editSemester.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertSemester"))
		{	
			insertSemester(request,response);
			response.sendRedirect("admin/addSemester.jsp");
		}
		if(flag.equals("updateSemester"))
		{	
			updateSemester(request,response);
			searchSemester(request, response);
			response.sendRedirect("admin/viewSemester.jsp");
		}
	}
	
	protected void insertSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			int semesterNumber=Integer.parseInt(request.getParameter("semesterNumber"));
			
			SemesterVO semesterVO=new SemesterVO();
			
			semesterVO.setSemesterNumber(semesterNumber);
			
			SemesterDAO semesterDAO=new SemesterDAO();
			
			semesterDAO.insertSemester(semesterVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void searchSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		SemesterDAO semesterDAO=new SemesterDAO();	
		
		List ls=semesterDAO.searchSemester();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);

	}
	
	protected void deleteSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int semesterId= Integer.parseInt(request.getParameter("semesterId"));
		
		SemesterVO semesterVO=new SemesterVO();
		
		semesterVO.setSemesterId(semesterId);
		
		SemesterDAO semesterDAO=new SemesterDAO();
		
		semesterDAO.deleteSemester(semesterVO);
	}   
	
	protected void editSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int semesterId = Integer.parseInt(request.getParameter("semesterId"));
		
		SemesterVO semesterVO=new SemesterVO();
		
		semesterVO.setSemesterId(semesterId);
		
		SemesterDAO semesterDAO=new SemesterDAO();
		
		List ls = semesterDAO.editSemester(semesterVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);
		
	}
	
	protected void updateSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int semesterId = Integer.parseInt(request.getParameter("semesterId"));
			int semesterNumber=Integer.parseInt(request.getParameter("semesterNumber"));
			
			SemesterVO semesterVO=new SemesterVO();
			semesterVO.setSemesterId(semesterId);
			semesterVO.setSemesterNumber(semesterNumber);
			
			SemesterDAO semesterDAO=new SemesterDAO();
			
			semesterDAO.updateSemester(semesterVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
