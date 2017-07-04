package com.scap.testweb.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.dao.ChangePwdDao;

public class ChangePwdService {
	public boolean ConfirmPwd(String email, String pass){
		ChangePwdDao passDao = new ChangePwdDao();
		ArrayList<HashMap<String, String>> chkPwd = passDao.changePwdDao(email);
		String dbPwd = chkPwd.get(0).get("PASSWORD");
		if(pass == dbPwd){
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
	
	public static String cryptWithMD5(String pass){
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
	
	
/*	public boolean ConfirmPwd(String email, String pass){
		ChangePwdDao passDao = new ChangePwdDao();
		ArrayList<HashMap<String, String>> chkPwd = passDao.ChangePwdDao(email);
		if(pass == chkPwd){
			return true;
		}
		else
			return false;
	}		*/

}
