package com.scap.testweb.service;

import com.scap.testweb.dao.UserDao;

public class SignUpService {
	public static void main(String[] args) {
		SignUpService service = new SignUpService();
		
		
		boolean chkEmail = service.checkEmail("1234@gmail.com");
		boolean chkPwd = service.chackPassword("1234Test#");
	
		System.out.println(chkEmail);
		System.out.println(chkPwd);
	}

	public boolean checkEmail(String email){
		if(email != null){
			UserDao userDao = new UserDao();
			String chkEmail = userDao.getEmail(email);
			if(email == chkEmail){
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	public boolean chackPassword(String password){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
		if(password.matches(pattern) == true){
			return true;
		}
		else
			return false;
	}
	
	public boolean setSignUp(){
		return true;
	}
	
}
