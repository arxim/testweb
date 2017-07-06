package com.scap.testweb.service;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.*;

import com.scap.testweb.dao.UserDao;

public class SignUpService {
	
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
	
	public boolean checkPassword(String password){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@S#$%^&+=])(?=\\S+$).{6,}";
		if(password.matches(pattern) == true){
			return true;
		}
		else
			return false;
	}
	
	public String cryptWithMD5(String pass){
        try{
        	String s = pass;
        	 MessageDigest m = MessageDigest.getInstance("MD5");
             m.update(s.getBytes(),0,s.length());
             return new BigInteger(1,m.digest()).toString(16);
        }catch(Exception e) {
			 e.printStackTrace();
			 return pass;
        }
    }
	
	public boolean createAccount(String email,String passwd){
		UserDao userDao = new UserDao();
		SignUpService createpwd = new SignUpService();
		String pwd = createpwd.cryptWithMD5(passwd);
		ArrayList<HashMap<String,String>> chkCorrect = userDao.setUserAccount(email,pwd);
		int sizeOfDataUser = chkCorrect.size();
		if(sizeOfDataUser == 1){
			return true;
		}
		else
			return false;
	}
	
	public String chktest(boolean chkEmail,boolean chkPwd,String email,String passwd){
		if(!chkEmail && chkPwd){
			SignUpService service = new SignUpService();
			boolean createUser = service.createAccount(email,passwd);
			if(createUser){
				return "Success";
			}
			else
				return "Failed";
		}
		else if(chkEmail && chkPwd){
				return "ChangeEmail";
			}
		else if(!chkEmail && !chkPwd){
				return "ChangePassword";
			}
		else{
				return "ChangeEmailandPassword";
			}
	}
}
