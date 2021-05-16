package controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vo.LoginVO;

/**
 * Servlet implementation class SendStaticSms
 */
@MultipartConfig
@WebServlet("/StaticSmsController")
public class StaticSmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaticSmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("sendStaticSms")){
			sendStaticSms(request, response);
			response.sendRedirect("staff/sendStaticSms.jsp");
		}
		
	}
	
	protected void sendStaticSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		
			String senderIdName=request.getParameter("senderIdName");
			String message=request.getParameter("message");
			String sendSmsOrNot=request.getParameter("sendSms");
			HttpSession session=request.getSession();
			
			int loginId=(Integer)session.getAttribute("loginId");
			
			LoginVO loginVO=new LoginVO();
			loginVO.setId(loginId);
			
			
			SendSms sendSMS=new SendSms();

		String path1 = null;
		File targetFile = null;
		String mobiles="";
		
		
		try {
			for(Part filepart:request.getParts()){
				if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals("")){
						String filename = filepart.getSubmittedFileName();
						
						InputStream fileContent = filepart.getInputStream();
						byte[] buffer = new byte[fileContent.available()];
						fileContent.read(buffer);
						
						String filePath = getServletContext().getRealPath(request.getServletPath());
						int path = filePath.lastIndexOf('\\');
						path1 = filePath.substring(0, path) + "\\doc\\";
						
						 targetFile = new File(path1+filename); 
						 
						OutputStream outStream = new FileOutputStream(targetFile);
						outStream.write(buffer);
						outStream.close();
				      }
				}
			
			System.out.println("********************"+targetFile);
			
			FileReader f1=new FileReader(targetFile);
			BufferedReader b1=new BufferedReader(f1);
		
			String s="";		
			b1.readLine();
			while((s=b1.readLine())!=null){
				
				String[] studentsData = s.split(",");

				String sendSms="";
				String mobileNumber="";
				
				
				for (int i = 0; i < studentsData.length; i++) {
					
					switch (i) {
					
					case 0:
						StringTokenizer studentMobile = new StringTokenizer(studentsData[i], ".");
						mobileNumber=studentMobile.nextToken();
						System.out.println("Mobile Number : "+ mobileNumber);
						break;
					case 1:
						sendSms=studentsData[i];
						System.out.println("Absent : " + sendSms);
						break;
				
					}
					  
					if(sendSms.equalsIgnoreCase(sendSmsOrNot))
					{
						mobiles=mobiles+mobileNumber+",";
					}
					
				}
				
				
				System.out.println("********************************************     ");
			}
			
			sendSMS.sendSMS(mobiles, message, senderIdName,loginVO);
		b1.close();
		f1.close();
		
		}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
	

