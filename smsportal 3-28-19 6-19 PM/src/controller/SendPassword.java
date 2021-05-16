package controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import vo.LoginVO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SendPassword {
	
		String sendPassword(String mobileNumber,LoginVO loginVO) 
		{ 

			// A strong password has Cap_chars, Lower_chars, 
			// numeric value and symbols. So we are using all of 
			// them to generate our password 
			int num = 0; 
			String pass = ""; 
			for (int i = 0; i < 6; i++) 
			{ num = (int) (Math.random() * 10); pass += num; }
			
			
			
			LoginVO loginVO2=new LoginVO();
			
			
			SendSms sendSMS=new SendSms();
			sendSMS.sendSMS(mobileNumber, "Your Username is "+loginVO.getEmail()+" And Password is "+pass+" for VPMP SMS portal", "VPMPPT",loginVO2);
			
			return pass;
		} 
}
