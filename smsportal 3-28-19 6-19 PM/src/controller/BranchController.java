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
import vo.BranchVO;

/**
 * Servlet implementation class BranchController
 */
@WebServlet("/BranchController")
public class BranchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BranchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("searchBranch"))
		{	
			searchBranch(request, response);
			response.sendRedirect("admin/viewBranch.jsp");
		}
		
		if(flag.equals("deleteBranch"))
		{	
			deleteBranch(request,response);
			searchBranch(request, response);
			response.sendRedirect("admin/viewBranch.jsp");
		}   
		
		if(flag.equals("editBranch"))
		{	
			editBranch(request,response);
			response.sendRedirect("admin/editBranch.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertBranch"))
		{	
			insertBranch(request,response);
			searchBranch(request, response);
			response.sendRedirect("admin/viewBranch.jsp");
		}
		
		if(flag.equals("updateBranch"))
		{	
			updateBranch(request,response);
			searchBranch(request,response);
			response.sendRedirect("admin/viewBranch.jsp");
		}
		
	}
	
	protected void insertBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String branchName=(String)request.getParameter("branchName");
			String branchDescription=(String)request.getParameter("branchDescription");
			
			
			
			BranchVO branchVO=new BranchVO();
			
			branchVO.setBranchName(branchName);
			branchVO.setBranchDescription(branchDescription);
			
			BranchDAO branchDAO=new BranchDAO();
			
			branchDAO.insertBranch(branchVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void searchBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		BranchDAO branchDAO=new BranchDAO();	
		
		List ls=branchDAO.searchBranch();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("list",ls);

	}
	
	protected void deleteBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int branchId= Integer.parseInt(request.getParameter("branchId"));
		
		BranchVO branchVO=new BranchVO();
		
		branchVO.setBranchId(branchId);
		
		BranchDAO branchDAO=new BranchDAO();
		
		branchDAO.deleteBranch(branchVO);
		
	}   
	
	protected void editBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int branchId = Integer.parseInt(request.getParameter("branchId"));
		
		BranchVO branchVO=new BranchVO();
		branchVO.setBranchId(branchId);
		
		BranchDAO branchDAO=new BranchDAO();
		
		List ls = branchDAO.editBranch(branchVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("list",ls);
		
	}
	
	protected void updateBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			String branchName=(String)request.getParameter("branchName");
			String branchDescription=(String)request.getParameter("branchDescription");
			int branchId=Integer.parseInt(request.getParameter("branchId"));
			
			
			BranchVO branchVO=new BranchVO();
			
			branchVO.setBranchName(branchName);
			branchVO.setBranchDescription(branchDescription);
			branchVO.setBranchId(branchId);
			
			BranchDAO branchDAO=new BranchDAO();
			
			branchDAO.updateBranch(branchVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
