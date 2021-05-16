package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.BranchDAO;
import dao.ComplainDAO;
import dao.SenderIdDAO;
import vo.BranchVO;
import vo.ComplainVO;
import vo.LoginVO;
import vo.SenderIdVO;

/**
 * Servlet implementation class ComplainController
 */
@MultipartConfig
@WebServlet("/ComplainController")
public class ComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=request.getParameter("flag");
		
		if(flag.equals("searchComplain"))
		{	 
			HttpSession session=request.getSession();
			String userType=(String)session.getAttribute("userType");
			
			searchComplain(request, response);
			
			if(userType.equals("staff"))
				response.sendRedirect("staff/viewComplain.jsp");
			else
		    	response.sendRedirect("admin/viewComplain.jsp");
		}
		
		if(flag.equals("replyComplain"))
		{	
			replyComplain(request,response);
			response.sendRedirect("admin/replyComplain.jsp");
		}
		
		if(flag.equals("deleteComplain"))
		{	 
			HttpSession session=request.getSession();
			String userType=(String)session.getAttribute("userType");
			
			if(userType.equals("staff"))
			{
				deleteComplain(request, response);
				searchComplain(request, response);
				response.sendRedirect("staff/viewComplain.jsp");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertComplain"))
		{	
			insertComplain(request,response);
			response.sendRedirect("staff/addComplain.jsp");
		}
		
		if(flag.equals("updateComplain"))
		{	
			updateComplain(request,response);
			searchComplain(request, response);
			response.sendRedirect("admin/viewComplain.jsp");
		}
	
	}

	protected void insertComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path1 = null;
		File targetFile = null;
		
		String fileName="";
		try {
			
			
			for(Part filepart:request.getParts()){
				if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals("")){
						String filename = filepart.getSubmittedFileName();
						
						InputStream fileContent = filepart.getInputStream();
						byte[] buffer = new byte[fileContent.available()];
						fileContent.read(buffer);
						
						String filePath = getServletContext().getRealPath(request.getServletPath());
						int path = filePath.lastIndexOf('\\');
						path1 = filePath.substring(0, path) + "\\doc\\complain\\";
						
						 targetFile = new File(path1+filename); 
						OutputStream outStream = new FileOutputStream(targetFile);
						outStream.write(buffer);
						outStream.close();
						fileName=filename;
				      }
				}
			
			
			
			HttpSession session=request.getSession();
			
			String complainSubject=(String)request.getParameter("complainSubject");
			String complainDescription=(String)request.getParameter("complainDescription");
			int loginId=(Integer)session.getAttribute("loginId");
			
			Date d = new Date();
			DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String complainDate = date.format(d);
			
			String complainReplyDate="";
			String complainStatus="PENDING";
			
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			ComplainVO complainVO=new ComplainVO();
			
			
			complainVO.setComplainDate(complainDate);
			complainVO.setComplainDescription(complainDescription);
			complainVO.setComplainReply(complainReplyDate);
			complainVO.setComplainReplyDate(complainReplyDate);
			complainVO.setComplainSubject(complainSubject);
			complainVO.setComplainStatus(complainStatus);
			complainVO.setLoginVO(loginVO);
			complainVO.setComplainFileName(fileName);
			complainVO.setComplainFilePath(path1);
			
			ComplainDAO complainDAO=new ComplainDAO();
			complainDAO.insertComplain(complainVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	protected void searchComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
		HttpSession session=request.getSession();
		String userType=(String)session.getAttribute("userType");
		int loginId=(Integer)session.getAttribute("loginId");
		
		ComplainDAO complainDAO=new ComplainDAO();
		
		LoginVO loginVO=new LoginVO();
		loginVO.setUserRoll(userType);
		loginVO.setId(loginId);
		
		List<ComplainVO> complainList=complainDAO.searchComplain(loginVO);
		
		session.setAttribute("complainList",complainList);

	}
	protected void replyComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int complainId = Integer.parseInt(request.getParameter("complainId"));
		
		ComplainVO complainVO=new ComplainVO();
		complainVO.setComplainId(complainId);
		
		ComplainDAO complainDAO=new ComplainDAO();
		
		List ls = complainDAO.editComplain(complainVO);
		
		
		HttpSession session=request.getSession();
		session.setAttribute("complainList",ls);
		
	}
	protected void updateComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session=request.getSession();
			
			int complainId=Integer.parseInt((String)request.getParameter("complainId"));
			String complainSubject=(String)request.getParameter("complainSubject");
			String complainDescription=(String)request.getParameter("complainDescription");
			String complainDate = (String)request.getParameter("complainDate");
			String complainReply=(String)request.getParameter("complainReply");
			String complainStatus="RESOLVED";
			String complainFileName=(String)request.getParameter("complainFileName");
			String complainFilePath=(String)request.getParameter("complainFilePath");
			
			Date d = new Date();
			DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
			String complainReplyDate=date.format(d);
			
			int loginId=Integer.parseInt((String)request.getParameter("loginId"));
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			ComplainVO complainVO=new ComplainVO();
			
			complainVO.setComplainId(complainId);
			complainVO.setComplainDate(complainDate);
			complainVO.setComplainDescription(complainDescription);
			complainVO.setComplainReply(complainReplyDate);
			complainVO.setComplainReply(complainReply);
			complainVO.setComplainReplyDate(complainReplyDate);
			complainVO.setComplainSubject(complainSubject);
			complainVO.setComplainStatus(complainStatus);
			complainVO.setComplainFileName(complainFileName);
			complainVO.setComplainFilePath(complainFilePath);
			complainVO.setLoginVO(loginVO);
			
			ComplainDAO complainDAO=new ComplainDAO();
			
			complainDAO.updateComplain(complainVO);
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	protected void deleteComplain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int complainId= Integer.parseInt(request.getParameter("complainId"));
			ComplainVO complainVO = new ComplainVO();
			complainVO.setComplainId(complainId);
			
			ComplainDAO complainDAO = new ComplainDAO();
			
			List<ComplainVO> ls = complainDAO.editComplain(complainVO);
			ComplainVO complainVO2 = (ComplainVO) ls.get(0);
			String complainFilePath = complainVO2.getComplainFilePath()+complainVO2.getComplainFileName();
			File file = new File(complainFilePath);
			
			file.delete();
			
			complainDAO.deleteComplain(complainVO);
		}   
	
}
