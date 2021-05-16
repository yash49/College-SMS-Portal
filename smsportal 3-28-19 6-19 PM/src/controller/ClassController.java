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
import dao.ClassDAO;
import vo.BranchVO;
import vo.ClassVO;

/**
 * Servlet implementation class ClassController
 */
@WebServlet("/ClassController")
public class ClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String flag=request.getParameter("flag");
	
		if(flag.equals("searchClass"))
		{	
			searchClass(request, response);
			response.sendRedirect("admin/viewClass.jsp");
		}
		
		if(flag.equals("deleteClass"))
		{	
			deleteClass(request,response);
			searchClass(request, response);
			response.sendRedirect("admin/viewClass.jsp");
		}   
		
		if(flag.equals("editClass"))
		{	
			editClass(request,response);
			response.sendRedirect("admin/editClass.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertClass"))
		{	
			insertClass(request,response);
			response.sendRedirect("admin/addClass.jsp");
		}
		
		if(flag.equals("updateClass"))
		{	
			updateClass(request,response);
			searchClass(request,response);
			response.sendRedirect("admin/viewClass.jsp");
		}
		
	}
	
	protected void insertClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String className=(String)request.getParameter("className");
			String classDescription=(String)request.getParameter("classDescription");
			
			ClassVO classVO=new ClassVO();
			
			classVO.setClassName(className);
			classVO.setClassDescription(classDescription);
			
			ClassDAO classDAO=new ClassDAO();
			
			classDAO.insertClass(classVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void searchClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		ClassDAO classDAO=new ClassDAO();
		
		List ls=classDAO.searchClass();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);

	}
	
	protected void deleteClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int classId= Integer.parseInt(request.getParameter("classId"));
		
		ClassVO classVO=new ClassVO();
		
		classVO.setClassId(classId);
		
		ClassDAO classDAO=new ClassDAO();
		
		classDAO.deleteClass(classVO);
	}   
	
	protected void editClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int classId = Integer.parseInt(request.getParameter("classId"));
		
		ClassVO classVO=new ClassVO();
		classVO.setClassId(classId);
		
		ClassDAO classDAO=new ClassDAO();
		
		List ls = classDAO.editClass(classVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("list",ls);
		
	}
	
	protected void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int classId= Integer.parseInt(request.getParameter("classId"));
			String className=(String)request.getParameter("className");
			String classDescription=(String)request.getParameter("classDescription");
			
			ClassVO classVO=new ClassVO();
			
			classVO.setClassId(classId);
			classVO.setClassName(className);
			classVO.setClassDescription(classDescription);
			
			ClassDAO classDAO=new ClassDAO();
			
			classDAO.updateClass(classVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
