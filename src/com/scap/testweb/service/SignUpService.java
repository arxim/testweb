package com.scap.testweb.service;

public class SignUpService {
	
	public static void main(String[] args) {
		SignUpService service = new SignUpService();
		//boolean authen = service.userSignUp("aaaaaa", "1234");
		boolean chkEmail = service.checkEmail("1234@gmail.com");
		boolean chkPwd = service.chackPassword("1234Test#");
		//System.out.println(authen);
		System.out.println(chkEmail);
		System.out.println(chkPwd);
	}
/*
	public boolean userSignUp(String pEmail, String password) {
		boolean status = false;
		if (pEmail != null && !pEmail.isEmpty() ) {
			// dao
		}
		return status;
	}
*/
	public boolean checkEmail(String email){
		if(email == "1234@gmail.com")
			return true;
		else
			return false;
	}

	public boolean chackPassword(String password){
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
		if(password.matches(pattern) == true)
			return true;
		else
			return false;
	}
		/* password validation
		--------------------------------------
		
		  if (txtEmail.equals(dbEmail))
	    	  System.out.println(“มีค่าเท่ากัน”);
	    	  
	    	else
	    	  System.out.println(“มีค่าไม่เท่ากัน”);
		 
		 ---------------------------------------
	      String passwd = "aaZZa44@"; 
	      String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	      System.out.println(passwd.matches(pattern));
	   
	    */
	
}
