package controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.BranchDAO;
import dao.ClassDAO;
import dao.GroupSmsDAO;
import dao.SemesterDAO;
import dao.SenderIdDAO;
import dao.SmsTemplateDAO;
import dao.StudentDAO;
import vo.BranchVO;
import vo.ClassVO;
import vo.GroupNamesVO;
import vo.LoginVO;
import vo.SemesterVO;
import vo.SenderIdVO;
import vo.SmsTemplateVO;
import vo.StudentVO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
@MultipartConfig
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("loadFormData"))
		{	
			loadClass(request,response);
			loadSemester(request, response);
			loadBranch(request,response);
			
			String to=request.getParameter("to");
			if(to.equals("addStudentStatically"))
				response.sendRedirect("staff/addStudentStatically.jsp");
		
			if(to.equals("addStudentDynamically"))
				response.sendRedirect("staff/addStudentDynamically.jsp");
		}
		if(flag.equals("loadSenderId"))
		{
			loadSenderId(request,response);
			loadSmsTemplate(request,response);
			searchStudent(request, response);
			String to=request.getParameter("to");
			if(to.equals("sendQuickSms"))
				response.sendRedirect("staff/sendQuickSms.jsp");
			if(to.equals("sendQuickSmsViaPhonebook"))
				response.sendRedirect("staff/sendQuickSmsViaPhonebook.jsp");
			if(to.equals("sendGroupSms"))
			{
				loadGroup(request, response);
				response.sendRedirect("staff/sendGroupSms.jsp");
			}
			if(to.equals("sendFutureSms"))
				response.sendRedirect("staff/sendFutureSms.jsp");
			if(to.equals("sendFutureSmsViaPhonebook"))
				response.sendRedirect("staff/sendFutureSmsViaPhonebook.jsp");
			if(to.equals("sendStaticSms"))
				response.sendRedirect("staff/sendStaticSms.jsp");
			if(to.equals("sendDynamicSms"))
				response.sendRedirect("staff/sendDynamicSms.jsp");
		}
		if(flag.equals("searchStudent"))
		{	
			searchStudent(request, response);
			response.sendRedirect("staff/viewStudent.jsp");
		}
		
		if(flag.equals("deleteStudent"))
		{	
			deleteStudent(request,response);
			searchStudent(request, response);
			response.sendRedirect("staff/viewStudent.jsp");
		} 
		
		if(flag.equals("editStudent"))
		{	
			editStudent(request,response);
			loadClass(request,response);
			loadSemester(request,response);
			loadBranch(request,response);
			response.sendRedirect("staff/editStudent.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String flag=(String)request.getParameter("flag");
		
		
		if(flag.equals("insertStudent"))
		{	
			insertStudent(request,response);
			response.sendRedirect("staff/addStudentStatically.jsp");
		}

		if(flag.equals("insertStudentDynamically"))
		{	
			insertDynamicStudent(request,response);
			response.sendRedirect("staff/addStudentDynamically.jsp");
		}
		
		if(flag.equals("updateStudent"))
		{	
			updateStudent(request,response);
			searchStudent(request, response);
			response.sendRedirect("staff/viewStudent.jsp");
		}
	
	}

	private void insertDynamicStudent(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		
		String branchId = request.getParameter("studentBranch");
		String semesterId = request.getParameter("studentSemester");
		String classId = request.getParameter("studentClass");
		String shift = request.getParameter("studentShift");
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		System.out.println(branchId+"   "+semesterId+"    "+classId+"    "+shift);
		
		BranchVO branchVO = new BranchVO();
		branchVO.setBranchId(Integer.parseInt(branchId));
		
		SemesterVO semesterVO = new SemesterVO();
		semesterVO.setSemesterId(Integer.parseInt(semesterId));
		
		ClassVO classVO = new ClassVO();
		classVO.setClassId(Integer.parseInt(classId));
		
		String path1 = null;
		File targetFile = null;
		try {
			for(Part filepart:request.getParts()){
				if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals("")){
						String filename = filepart.getSubmittedFileName();
						
						InputStream fileContent = filepart.getInputStream();
						byte[] buffer = new byte[fileContent.available()];
						fileContent.read(buffer);
						
						String filePath = getServletContext().getRealPath(request.getServletPath());
						int path = filePath.lastIndexOf('\\');
						path1 = filePath.substring(0, path) + "\\doc\\student\\";
						
						 targetFile = new File(path1+filename); 
						OutputStream outStream = new FileOutputStream(targetFile);
						outStream.write(buffer);
						outStream.close();
				      }
				}
		
			FileReader f1=new FileReader(targetFile);
			BufferedReader b1=new BufferedReader(f1);
		
			String s="";		
			b1.readLine();
			StudentDAO studentDAO=new StudentDAO();
			while((s=b1.readLine())!=null){
				
				
				StudentVO studentVO = new StudentVO();
				studentVO.setBranchVO(branchVO);
				studentVO.setClassVO(classVO);
				studentVO.setSemesterVO(semesterVO);
				studentVO.setStudentShift(shift);
				studentVO.setLoginVO(loginVO);
				
				String[] studentsData = s.split(",");
				String mobileNumber;
				String enrollmentNumber;
				
				for (int i = 0; i < studentsData.length; i++) {
					
					switch (i) {
					case 0:
						studentVO.setStudentFirstName(studentsData[i]);
						System.out.println("First Name : " + studentsData[i]);
						break;
					case 1:
						studentVO.setStudentLastName(studentsData[i]);
						System.out.println("Last Name : " + studentsData[i]);
						break;
					case 2:
						StringTokenizer studentMobile = new StringTokenizer(studentsData[i], ".");
						mobileNumber=studentMobile.nextToken();
						studentVO.setStudentMobile(mobileNumber);
						System.out.println("Mobile Number : "+ mobileNumber);
						break;
					case 3:
						studentVO.setStudentEmail(studentsData[i]);
						System.out.println("Email : " + studentsData[i]);
						break;
					case 4: 
						studentVO.setStudentGender(studentsData[i]);
						System.out.println("Gender : " + studentsData[i]);
						break;
					case 5:
						StringTokenizer stringTokenizer = new StringTokenizer(studentsData[i], ".");
						enrollmentNumber=stringTokenizer.nextToken();
						studentVO.setStudentEnrollmentNumber(enrollmentNumber);
						System.out.println("Enrollment Number : " + enrollmentNumber);
						break;
					
					}
					
				}
				
				studentDAO.insertStudent(studentVO);
				
				System.out.println("********************************************");
			}
		
		b1.close();
		f1.close();
		
		}catch (Exception e) {
				e.printStackTrace();
			}
		targetFile.delete();
		
	}

	protected void loadBranch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		BranchDAO branchDAO=new BranchDAO();
		
		List<BranchVO> branchList=branchDAO.searchBranch();
		
		HttpSession session=request.getSession();
		
		System.out.println("BRANCHLIST:::::::::::::" + branchList);
		
		session.setAttribute("branchList",branchList);
	}
	
	protected void loadSemester(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		SemesterDAO semesterDAO=new SemesterDAO();
		
		List<SemesterVO> semesterList=semesterDAO.searchSemester();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("semesterList",semesterList);
	}
	protected void loadClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		ClassDAO classDAO=new ClassDAO();
		
		List<ClassVO> classList=classDAO.searchClass();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("classList",classList);
		
	}
	protected void loadSenderId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		SenderIdDAO  senderIdDAO=new SenderIdDAO();
		
		List<SenderIdVO> senderIdList=senderIdDAO.searchSenderId();
		
		HttpSession session=request.getSession();
		
		session.setAttribute("senderIdList",senderIdList);
	}
	protected void loadGroup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		HttpSession session=request.getSession();
		
		GroupSmsDAO groupSmsDAO = new GroupSmsDAO();
		
		int loginId=(Integer)session.getAttribute("loginId");
		LoginVO loginVO = new LoginVO();
		loginVO.setId(loginId);
		
		List<GroupNamesVO> groupNameList = groupSmsDAO.searchGroupNames(loginVO);
		
		session.setAttribute("groupNameList",groupNameList);
	}
	protected void loadSmsTemplate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session=request.getSession();
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		SmsTemplateDAO smsTemplateDAO = new SmsTemplateDAO();
		
		List<SmsTemplateVO> smsTemplateList=smsTemplateDAO.searchSmsTemplate(loginVO);
		
		session.setAttribute("smsTemplateList",smsTemplateList);
	}
	protected void insertStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			
			HttpSession session=request.getSession();
			
			String studentFirstName=(String)request.getParameter("studentFirstName");
			String studentLastName=(String)request.getParameter("studentLastName");
			String studentMobile=(String)request.getParameter("studentMobile");
			String studentEmail=(String)request.getParameter("studentEmail");
			String studentGender=(String)request.getParameter("studentGender");
			String studentEnrollmentNumber=(String)request.getParameter("studentEnrollmentNumber");
			String studentShift=(String)request.getParameter("studentShift");
			
			int studentBranchId = Integer.parseInt(request.getParameter("studentBranchId"));
			int studentSemesterId=Integer.parseInt(request.getParameter("studentSemesterId"));
			int studentClassId=Integer.parseInt(request.getParameter("studentClassId"));
			
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			BranchVO branchVO=new BranchVO();
			branchVO.setBranchId(studentBranchId);
			
			SemesterVO semesterVO=new SemesterVO();
			semesterVO.setSemesterId(studentSemesterId);
			
			ClassVO classVO=new ClassVO();
			classVO.setClassId(studentClassId);
			
			StudentVO studentVO=new StudentVO();
			
			studentVO.setStudentFirstName(studentFirstName);
			studentVO.setStudentLastName(studentLastName);
			studentVO.setStudentMobile(studentMobile);
			studentVO.setStudentEmail(studentEmail);
			studentVO.setStudentGender(studentGender);
			studentVO.setStudentEnrollmentNumber(studentEnrollmentNumber);
			studentVO.setStudentShift(studentShift);
			
			studentVO.setBranchVO(branchVO);
			studentVO.setClassVO(classVO);
			studentVO.setSemesterVO(semesterVO);
			studentVO.setLoginVO(loginVO);
			
			StudentDAO studentDAO=new StudentDAO();
			studentDAO.insertStudent(studentVO);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		
		System.out.println("////////////////////////////"+studentId);
		
		StudentVO studentVO=new StudentVO();
		studentVO.setStudentId(studentId);
		
		StudentDAO studentDAO=new StudentDAO();
		
		studentDAO.deleteStudent(studentVO);
		
	}

	protected void editStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		int studentId=Integer.parseInt(request.getParameter("studentId"));
		
		StudentVO studentVO=new StudentVO();
		studentVO.setStudentId(studentId);
		
		StudentDAO studentDAO=new StudentDAO();
		
		List<StudentVO> studentList=studentDAO.editStudent(studentVO);
		
		HttpSession session=request.getSession();
		
		session.setAttribute("studentList",studentList);
	}

	protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			HttpSession seesion=request.getSession();
			
			int loginId=(Integer)seesion.getAttribute("loginId");
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			int studentId=Integer.parseInt(request.getParameter("studentId"));
			String studentFirstName=(String)request.getParameter("studentFirstName");
			String studentLastName=(String)request.getParameter("studentLastName");
			String studentMobile=(String)request.getParameter("studentMobile");
			String studentEmail=(String)request.getParameter("studentEmail");
			String studentGender=(String)request.getParameter("studentGender");
			String studentEnrollmentNumber=(String)request.getParameter("studentEnrollmentNumber");
			String studentShift=(String)request.getParameter("studentShift");
			
			int studentBranchId = Integer.parseInt(request.getParameter("studentBranchId"));
			int studentSemesterId=Integer.parseInt(request.getParameter("studentSemesterId"));
			int studentClassId=Integer.parseInt(request.getParameter("studentClassId"));
			
			BranchVO branchVO=new BranchVO();
			branchVO.setBranchId(studentBranchId);
			
			SemesterVO semesterVO=new SemesterVO();
			semesterVO.setSemesterId(studentSemesterId);
			
			ClassVO classVO=new ClassVO();
			classVO.setClassId(studentClassId);
			
			StudentVO studentVO=new StudentVO();
			
			studentVO.setStudentId(studentId);
			studentVO.setStudentFirstName(studentFirstName);
			studentVO.setStudentLastName(studentLastName);
			studentVO.setStudentMobile(studentMobile);
			studentVO.setStudentEmail(studentEmail);
			studentVO.setStudentGender(studentGender);
			studentVO.setStudentEnrollmentNumber(studentEnrollmentNumber);
			studentVO.setStudentShift(studentShift);
			
			studentVO.setBranchVO(branchVO);
			studentVO.setClassVO(classVO);
			studentVO.setSemesterVO(semesterVO);
			studentVO.setLoginVO(loginVO);
			
			StudentDAO studentDAO=new StudentDAO();
			studentDAO.updateStudent(studentVO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	
		
}

