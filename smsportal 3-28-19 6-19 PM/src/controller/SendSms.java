package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import dao.SmsHistoryDAO;
import vo.LoginVO;
import vo.SmsHistoryVO;

public class SendSms {

	public Boolean sendSMS(String mobiles,String message,String senderId,LoginVO loginVO)
	{
		
		Boolean status = false ; 
        //Your authentication key
        String authkey = "261082AkbTgLdBjj5c55dc78";
        //Multiple mobiles numbers separated by comma
        //String mobiles = ;
        //Sender ID,While using route4 sender id should be 6 characters long.
        //String senderId = ;
        //Your message to send, Add URL encoding here.
        //String message = ;
        //define route
        String route="4";

        //Prepare Url
        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

        //encoding message
        String encoded_message=URLEncoder.encode(message);

        //Send SMS API
        String mainUrl="http://sms.savvyinfotech.in/api/sendhttp.php?";

        //Prepare parameter string
        StringBuilder sbPostData= new StringBuilder(mainUrl);
        sbPostData.append("authkey="+authkey);
        sbPostData.append("&mobiles="+mobiles);
        sbPostData.append("&message="+encoded_message);
        sbPostData.append("&route="+route);
        sbPostData.append("&sender="+senderId);
        sbPostData.append("&response=json");
        sbPostData.append("&unicode=1");
        //final string
        mainUrl = sbPostData.toString();
        try
        {
            //prepare connection
            myURL = new URL(mainUrl);
            myURLConnection = myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));
            //reading response
            String response = "";
            
            
            while ((response = reader.readLine()) != null)
            {            	System.out.println("::::::::::::"+ response);

            String data = response;
			
            JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(data);
			JSONObject jsonObject =  (JSONObject) obj;
			String s = (String)jsonObject.get("type");
			
            System.out.println("STATUS :::: " + s);
            if(s.equals("success")){
            	status = true;
            }
            
            }reader.close();
            }
        catch (Exception e)
        {
                e.printStackTrace();
        }
        
        
        SmsHistoryVO smsHistoryVO=new SmsHistoryVO();
        
        if(loginVO != null)
        {
    		Date d = new Date();
    		DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
    		String dateString = date.format(d);

        smsHistoryVO.setLoginVO(loginVO);
        smsHistoryVO.setMessage(message);
        smsHistoryVO.setSenderId(senderId);
        smsHistoryVO.setMobileNo(mobiles);
        smsHistoryVO.setDate(dateString);
        
        SmsHistoryDAO smsHistoryDAO = new SmsHistoryDAO();
        smsHistoryDAO.insertSmsHistory(smsHistoryVO);
        }
    
	
	return status;
	}


	
}
