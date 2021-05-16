package utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BaseMethods {

	public static String getPassword(){
		int num = 0; 
		  String pass = ""; 
		  for (int i = 0; i < 4;i++) {
			  num = (int) (Math.random() * 10); 
			  pass += num;
		  }
		  
		  return pass;
	}
	
	public static void sendMail(String to,String msg){
		final String from = "vpmpsmsportal@gmail.com";
		final String username = "Hello";
		final String password = "vpmp@654";

		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mails.smtp.ssl.trust","smtp.gmail.com");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Forgot Password OTP - VPMP SMS Portal");
			
			  
			
			message.setText(msg);

			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
