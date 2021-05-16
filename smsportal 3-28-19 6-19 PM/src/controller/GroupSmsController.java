package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Param;

import dao.GroupSmsDAO;
import dao.SmsTemplateDAO;
import dao.StudentDAO;
import vo.GroupMembersVO;
import vo.GroupNamesVO;
import vo.LoginVO;
import vo.SmsTemplateVO;
import vo.StudentVO;

/**
 * Servlet implementation class GroupSmsController
 */
@WebServlet("/GroupSmsController")
public class GroupSmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupSmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	String flag=request.getParameter("flag");
		
		if(flag.equals("loadStudent"))
		{	
			searchStudent(request, response);
			response.sendRedirect("staff/addGroup.jsp");
		}
		
		if(flag.equals("viewGroupNames"))
		{	
			searchGroupNames(request, response);
			response.sendRedirect("staff/viewGroup.jsp");
		}
		
		
		if(flag.equals("viewGroupMembers"))
		{	
			searchGroupMembers(request, response);
			response.sendRedirect("staff/viewGroupMembers.jsp");
		}
		
		if(flag.equals("deleteGroupMember"))
		{	
			deleteGroupMembers(request, response);
			searchGroupMembers(request, response);
			response.sendRedirect("staff/viewGroupMembers.jsp");
		}
		
		if(flag.equals("deleteGroup"))
		{	
			deleteGroup(request, response);
			searchGroupNames(request, response);
			response.sendRedirect("staff/viewGroup.jsp");
		}
		
		if(flag.equals("editGroup"))
		{	
			searchStudent(request, response);
			editGroup(request, response);
			response.sendRedirect("staff/editGroup.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("insertGroup"))
		{	
			insertGroup(request, response);
			response.sendRedirect("staff/addGroup.jsp");
		}
		if(flag.equals("updateGroup"))
		{	
			updateGroup(request, response);
			searchGroupNames(request, response);
			response.sendRedirect("staff/viewGroup.jsp");
		}
		if(flag.equals("sendGroupSms"))
		{	
			sendGroupSms(request, response);
			response.sendRedirect("staff/sendGroupSms.jsp");
		}
		
	}
	
	protected void searchStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session=request.getSession();
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		StudentDAO studentDAO=new StudentDAO();
		
		List<StudentVO> studentList=studentDAO.searchStudent(loginVO);
		
		session.setAttribute("studentList",studentList);
	}
	protected void insertGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session=request.getSession();
			
			String groupName=(String)request.getParameter("groupName");
			String studentId[]=request.getParameterValues("studentId");
		
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			GroupNamesVO groupNamesVO=new GroupNamesVO();
			
			groupNamesVO.setLoginVO(loginVO);
			groupNamesVO.setGroupName(groupName);
			
			GroupSmsDAO groupSmsDAO = new GroupSmsDAO();
			groupSmsDAO.insertGroupName(groupNamesVO);
			
			GroupMembersVO groupMembersVO = new GroupMembersVO();
			groupMembersVO.setGroupNamesVO(groupNamesVO);
			
			groupSmsDAO.insertGroupMembers(groupMembersVO, studentId);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void searchGroupNames(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session=request.getSession();
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		List<GroupNamesVO> groupNamesList=groupSmsDAO.searchGroupNames(loginVO);
		
		session.setAttribute("groupNamesList",groupNamesList);
	}
	protected void searchGroupMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session= request.getSession();
		
		int groupNameId=Integer.parseInt(request.getParameter("groupNameId"));
		
		GroupNamesVO groupNamesVO = new GroupNamesVO();
		groupNamesVO.setGroupNameId(groupNameId);;
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		List<GroupMembersVO> groupMembersList=groupSmsDAO.searchGroupMembers(groupNamesVO);
		
		session.setAttribute("groupMembersList",groupMembersList);
	}
	protected void editGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		HttpSession session= request.getSession();
		
		int groupNameId=Integer.parseInt(request.getParameter("groupNameId"));
		
		GroupNamesVO groupNamesVO = new GroupNamesVO();
		groupNamesVO.setGroupNameId(groupNameId);;
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		List<StudentVO> groupMembersList=groupSmsDAO.editGroup(groupNamesVO);
		
		List<GroupNamesVO> groupNamesList=groupSmsDAO.editGroupNames(groupNamesVO);
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		StudentDAO studentDAO=new StudentDAO();
		
		List<StudentVO> studentList=studentDAO.searchStudent(loginVO);
		
		/*List<StudentVO> students = studentList;
		
		students.removeAll(studentList);
		
		for (StudentVO student : studentList) {
			for (StudentVO member : groupMembersList) {
				if(student.getStudentId() != member.getStudentId())
				{ 
					students.add(student);
				}
			}
		}
		
		System.out.println("Before  ++++++   "+studentList.size());
		studentList.removeAll(groupMembersList);
		System.out.println("After   ++++++   "+students.size());
		
	*/	
	
		
		session.setAttribute("studentList",studentList);
		
		session.setAttribute("groupMembersList",groupMembersList);	
		
		session.setAttribute("groupNamesList", groupNamesList);
	}
	protected void deleteGroupMembers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int groupMemberId= Integer.parseInt(request.getParameter("groupMemberId"));
		
		GroupMembersVO groupMembersVO=new GroupMembersVO();
		
		groupMembersVO.setGroupMemberId(groupMemberId);
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		groupSmsDAO.deleteGroupMembers(groupMembersVO);
		
	}   
	protected void deleteGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int groupNameId= Integer.parseInt(request.getParameter("groupNameId"));
		
		GroupNamesVO groupNamesVO=new GroupNamesVO();
		
		groupNamesVO.setGroupNameId(groupNameId);
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		groupSmsDAO.deleteGroup(groupNamesVO);
		
	}
	protected void updateGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		session.removeAttribute("groupNameId");
		
		int groupNameId= Integer.parseInt(request.getParameter("groupNameId"));
		
		GroupNamesVO groupNamesVOForDelete=new GroupNamesVO();
		
		groupNamesVOForDelete.setGroupNameId(groupNameId);
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		
		groupSmsDAO.deleteGroup(groupNamesVOForDelete);
		
		System.out.println("Delete Completed +++++++++++++++");
		
		try {
			
			String groupName=(String)request.getParameter("groupName");
			String studentId[]=request.getParameterValues("studentId");
		
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			GroupNamesVO groupNamesVOForInsert=new GroupNamesVO();
			
			groupNamesVOForInsert.setLoginVO(loginVO);
			groupNamesVOForInsert.setGroupName(groupName);
			
			groupSmsDAO.insertGroupName(groupNamesVOForInsert);
			
			GroupMembersVO groupMembersVO = new GroupMembersVO();
			groupMembersVO.setGroupNamesVO(groupNamesVOForInsert);
			
			groupSmsDAO.insertGroupMembers(groupMembersVO, studentId);
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void sendGroupSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int groupNameId=Integer.parseInt(request.getParameter("groupNameId"));
		String senderIdName=request.getParameter("senderIdName");
		String message=request.getParameter("message");
		
		HttpSession session=request.getSession();
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		System.out.println(senderIdName);
		
		GroupNamesVO groupNamesVO = new GroupNamesVO();
		groupNamesVO.setGroupNameId(groupNameId);

		GroupMembersVO groupMembersVO=new GroupMembersVO();
		groupMembersVO.setGroupNamesVO(groupNamesVO);
		
		GroupSmsDAO groupSmsDAO=new GroupSmsDAO();
		List<GroupMembersVO> groupMemberList=groupSmsDAO.searchGroupMembers(groupNamesVO);
		
		String mobileNumber = "";
		
		for (GroupMembersVO groupMembers : groupMemberList) {
			mobileNumber=mobileNumber+groupMembers.getStudentVO().getStudentMobile()+",";
		}
		
		SendSms sendSMS=new SendSms();
		sendSMS.sendSMS(mobileNumber, message,senderIdName,loginVO);
		
	}
}
