package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import dao.ComplainDAO;
import vo.ComplainVO;
import vo.LoginVO;

/**
 * Servlet implementation class DynamicSmsController
 */
@MultipartConfig
@WebServlet("/DynamicSmsController")
public class DynamicSmsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicSmsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flag=request.getParameter("flag");
		
		if(flag.equals("sendDynamicSms"))
		{	
			sendDynamicSms(request, response);
			response.sendRedirect("staff/sendDynamicSms.jsp");
		}
		
	}


	protected void sendDynamicSms(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path1 = null;
		File targetFile = null;
		
		HttpSession session=request.getSession();
		
		int loginId=(Integer)session.getAttribute("loginId");
		
		LoginVO loginVO=new LoginVO();
		loginVO.setId(loginId);
		
		try {
			for(Part filepart:request.getParts()){
				if(filepart.getSubmittedFileName() != null && !filepart.getSubmittedFileName().equals("")){
						String filename = filepart.getSubmittedFileName();
						
						InputStream fileContent = filepart.getInputStream();
						byte[] buffer = new byte[fileContent.available()];
						fileContent.read(buffer);
						
						String filePath = getServletContext().getRealPath(request.getServletPath());
						int path = filePath.lastIndexOf('\\');
						path1 = filePath.substring(0, path) + "\\doc\\dynamicSms\\";
						
						 targetFile = new File(path1+filename); 
						 
						OutputStream outStream = new FileOutputStream(targetFile);
						outStream.write(buffer);
						outStream.close();
				      }
				}
			
			System.out.println("********************"+targetFile);
			
			
			
			
			String msg=request.getParameter("message");
			String finalmsg="";
			String l[]=msg.split(" ");
			int maxcolumn=3;
			String sendSmsOrNot=request.getParameter("sendSms");
			String senderId=request.getParameter("senderIdName");
			
			
			FileReader f1=new FileReader(targetFile);
			BufferedReader b1=new BufferedReader(f1);
			String s="";
			
			int totalrecords=0;
			FileReader f2=new FileReader(targetFile);
			BufferedReader b2=new BufferedReader(f2);
			while((s=b2.readLine())!=null){
				totalrecords++;
			}
		
			for(int i=0;i<l.length;i++)
			{
				if(l[i].contains("@#"))
				{
					String a[]=l[i].split("@#");
					
					int m=Integer.parseInt(a[1]);
					if(m>maxcolumn)
					{
						maxcolumn=m;	
					}	
				}
			}
			
		
					
			b1.readLine();
			
			

			String data[]=new String[maxcolumn-2];
			String finalMobileNumber="";
		
			int w=0;
		
		String finalmsgarray[]=new String[totalrecords-1];
			
	
			
			while((s=b1.readLine())!=null){
				
				String[] studentsData = s.split(",");

				String sendSms="";
				String mobileNumber="";
			
				for (int i = 0; i < studentsData.length; i++) {
					
				
					if(i==0)
					{
						StringTokenizer studentMobile = new StringTokenizer(studentsData[i], ".");
						mobileNumber=studentMobile.nextToken();
						System.out.println("Mobile Number : "+ mobileNumber);
					}
					if(i==1)
					{
						sendSms=studentsData[i];
						System.out.println("### " + sendSms);
						if(sendSms.equalsIgnoreCase(sendSmsOrNot))
						{
							finalMobileNumber=finalMobileNumber+mobileNumber+",";
							
						}
					}
					
					for(int columns=2;columns<(maxcolumn);columns++)
					{
							
							if(i==columns)
							{
								StringTokenizer data1 = new StringTokenizer(studentsData[i], ".");
								data[columns-2]=data1.nextToken();
								System.out.println(studentsData[i]);
							}
					}	
				}
			/*	for (int i = 0; i < data.length; i++) {
					System.out.print(data[i]+"|||");
				}*/
				
				if(sendSms.equalsIgnoreCase(sendSmsOrNot))
				{	
					String ans=changemsg(data,msg);
					if(ans != null && !ans.equals(""))
					{
						finalmsgarray[w]=ans;
						w++;
					}
				}
					
			
			
				System.out.println("********************************************     ");
			}
		
		b1.close();
		f1.close();
		
		System.out.println("--------------------------------- "+finalMobileNumber);
		
		for (String msgs : finalmsgarray) {
			System.out.println(msgs);
		}
			
		SendSms sendSmsobj=new SendSms();
		String finalMobileNumberArray[]=finalMobileNumber.split(",");
		
		for (int j = 0; j < finalMobileNumberArray.length; j++) {
			sendSmsobj.sendSMS(finalMobileNumberArray[j], finalmsgarray[j], senderId,loginVO);
		}
			
		
		}catch (Exception e) {
				e.printStackTrace();
			}
		targetFile.delete();
		
	}
	protected String changemsg(String data[],String msg)
	{
		String l[]=msg.split(" ");
		String finalmsg="";
		for(int j=0;j<l.length;j++)
		{
			String a[]=msg.split(" ");
			for(int i=0;i<data.length;i++)
			{
				if(a[j].equalsIgnoreCase("@#"+(i+3)))
				{
					a[j]=data[i];
				
				}
			}
			finalmsg = finalmsg+a[j]+" ";
			
		}
		System.out.println(finalmsg);
		return finalmsg;
	}
}