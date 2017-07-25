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
		   BodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setText(body);
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   message.setContent(multipart);
		   
		   Transport.send(message);
		   msg = "PASS";
		  }catch (MessagingException e) {
			 msg = "FAIL";
			e.printStackTrace();
		}
		return msg;
	}
	
	public String sendRequest(String emailBoss,String typeLeave,String name){
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
		String subject = "คำร้องขออนุมัติ \""+typeLeave+"\" ของ \""+name+"\"";
		// Content
		String body = name+" ได้ส่งคำร้องเพื่อขออนุมัติ  \""+typeLeave+"\" คลิก http://localhost:8080/testweb/index.jsp เพื่อดูรายละเอียดเพิ่มเติม";
		
		try {
			
			Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(auth_email, auth_password);
				}
			});
			
			Message message = new MimeMessage(mailSession);
			
			message.setFrom(new InternetAddress(auth_email)); // From
			
			/*** Recipient ***/
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailBoss)); // To
			message.setSubject(subject);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(body);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			
			Transport.send(message);
			msg = "PASS";
		}catch (MessagingException e) {
			msg = "FAIL";
			e.printStackTrace();
		}
		return msg;
	}
	
	public String sendApprove(String emailBoss,String rqt){
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
		  String subject = "มีข้อความใหม่จากหัวหน้าพนักงาน";
		  // Content
		  String body = rqt;

		  try {

		   Session mailSession = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		     return new PasswordAuthentication(auth_email, auth_password);
		    }
		   });

		   Message message = new MimeMessage(mailSession);

		   message.setFrom(new InternetAddress(auth_email)); // From

		   /*** Recipient ***/
		   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailBoss)); // To
		   message.setSubject(subject);
		   BodyPart messageBodyPart = new MimeBodyPart();
		   messageBodyPart.setText(body);
		   Multipart multipart = new MimeMultipart();
		   multipart.addBodyPart(messageBodyPart);
		   message.setContent(multipart);
		   
		   Transport.send(message);
		   msg = "PASS";
		  }catch (MessagingException e) {
			 msg = "FAIL";
			e.printStackTrace();
		}
		return msg;
	}
}
