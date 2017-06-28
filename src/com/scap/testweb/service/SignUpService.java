package com.scap.testweb.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.scap.testweb.dao.UserDao;

public class SignUpService {

	public static void main(String[] args) {
		SignUpService service = new SignUpService();
		String email = "ABC@gmail.com";
		String passwd = "@#+^65ftwdF";
		boolean chkEmail = service.checkEmail(email);
		boolean chkPwd = service.chackPassword(passwd); 
		service.chktest(chkEmail,chkPwd,email,passwd);
	}
	
	public boolean checkEmail(String email){
			UserDao userDao = new UserDao();
			ArrayList<HashMap<String,String>> chkEmail = userDao.getEmail(email);
			int sizeOfData = chkEmail.size();
			if(sizeOfData == 1){
				return true;
			}
			else
				return false;
	}
	
	public boolean chackPassword(String password){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@S#$%^&+=])(?=\\S+$).{6,}";
		if(password.matches(pattern) == true){
			return true;
		}
		else
			return false;
	}
	
	public String cryptWithMD5(String pass){
		   MessageDigest md;
	    try {
	        md = MessageDigest.getInstance("MD5");
	        byte[] passBytes = pass.getBytes();
	        md.reset();
	        byte[] digested = md.digest(passBytes);
	        StringBuffer sb = new StringBuffer();
	        for(int i=0;i<digested.length;i++){
	            sb.append(Integer.toHexString(0xff & digested[i]));
	        }
	        return sb.toString();
	    } catch (NoSuchAlgorithmException ex) {
	        Logger.getLogger(SignUpService.class.getName()).log(Level.SEVERE, null, ex);
	    }
	        return null;
	   }
	
	public boolean createAccount(String email,String passwd){
		UserDao userDao = new UserDao();
		ArrayList<HashMap<String,String>> chkCorrect = userDao.setUserAccount(email,passwd);
		int sizeOfDataUser = chkCorrect.size();
		if(sizeOfDataUser == 1){
			return true;
		}
		else
			return false;
	}
	
	public void chktest(boolean chkEmail,boolean chkPwd,String email,String passwd){
		if(!chkEmail && chkPwd){
			System.out.println("E-mail : Unique");
			System.out.println("Password : Approve");
			//String pwd = service.cryptWithMD5(passwd);
			SignUpService service = new SignUpService();
			boolean createUser = service.createAccount(email,passwd);
			if(createUser){
				System.out.println("Sign up success!!");
			}
			else
				System.out.println("Sign up failed!!");
		}
		else if(chkEmail && chkPwd){
				System.out.println("E-mail : Duplicate");
				System.out.println("Password : Approve");
				System.out.println("Please change e-mail.");
			}
		else if(!chkEmail && !chkPwd){
				System.out.println("E-mail : Unique");
				System.out.println("Password : Do not approve");
				System.out.println("Please change password.");
			}
		else{
				System.out.println("E-mail : Duplicate");
				System.out.println("Password : Do not approve");
				System.out.println("Please change e-mail and password.");
			}
	}
}
