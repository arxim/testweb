package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.dao.UserDao;

public class SignUpService {
	public static void main(String[] args) {
		SignUpService service = new SignUpService();
		String email = "pear11@gmail.com";
		String passwd = "1234Test#";
		boolean chkEmail = service.checkEmail(email);
		boolean chkPwd = service.chackPassword(passwd);  
		if(chkEmail == false && chkPwd == true){
			System.out.println("E-mail : Unique email");
			System.out.println("Password : Approve password");
			boolean createUser = service.createAccount(email,passwd);
			if(createUser == true){
				System.out.println("Sign up success!!");
			}
			else
				System.out.println("Sign up failed!!");
		}
		else{
			if(chkEmail == true && chkPwd == true){
				System.out.println("E-mail : Duplicate email");
				System.out.println("Password : Approve password");
			}
			if(chkEmail == false && chkPwd == false){
				System.out.println("E-mail : Unique email");
				System.out.println("Password : Do not approve");
			}
		}
	}

	public boolean checkEmail(String email){
		if(email != null){
			UserDao userDao = new UserDao();
			ArrayList<HashMap<String,String>> chkEmail = userDao.getEmail(email);
			int sizeOfData = chkEmail.size();
			if(sizeOfData == 1){
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
	
	public boolean createAccount(String email,String passwd){
		UserDao userDao = new UserDao();
		ArrayList<HashMap<String,String>> chkCorrect = userDao.setUserAccount(email,passwd);
		//System.out.println(chkCorrect);
		int sizeOfDataUser = chkCorrect.size();
		if(sizeOfDataUser == 1){
			return true;
		}
		else
			return false;
	}
}
