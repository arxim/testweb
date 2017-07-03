package com.scap.testweb.service;

import java.util.Map;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.scap.testweb.utils.ReadProperties;

public class SendEmailService {
	public String sendEmail(String email,String newPassword){
//		System.out.println("Begin Send Mail");
		ReadProperties prop=new ReadProperties();
		Map<String,String> propData=prop.getDataReadPropertiesFile("mailserver.properties");
		String auth_host = propData.get("auth_host");
		String auth_port = propData.get("auth_port");
		String auth_email = propData.get("auth_email");
		String auth_password = propData.get("auth_password");
		String msg="";
		
		Properties props = new Properties();
		  props.put("mail.smtp.host", auth_host);
		  props.put("mail.smtp.socketFactory.port", auth_port);
		  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", auth_port);
		  
		  // Subject
		  String subject = "New generated password";
		  // Content
		  String body = "Your new password is "+"\""+newPassword+"\"";

		  try {

		   Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		     return new PasswordAuthentication(auth_email, auth_password);
		    }
		   });

		   Message message = new MimeMessage(mailSession);

		   message.setFrom(new InternetAddress(auth_email)); // From

		   /*** Recipient ***/
		   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email)); // To
		   message.setSubject(subject);
//		   message.setContent(body);
		//   message.setText("Hello mr.win, Please do not reply this mail");
		   BodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setText(body);
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   message.setContent(multipart);
		   
		   Transport.send(message);
//		   System.out.println("Send mail success!!");
		   msg = "PASS";
		  }catch (MessagingException e) {
			 msg = "FAIL";
			e.printStackTrace();
		}
		return msg;
	}
}