package com.scap.testweb.service;

public class LoginService {

	public String checkLogin(String email,String pwd){
		if(email=="topandapisit@hotmail.com" && pwd=="5555555"){
			String result="Success";
			return result;
		}
		else{
			if(email!="topandapisit@hotmail.com" && pwd=="5555555"){
				String result="E-mail Incorrect";
				return result;
			}
			else if(email=="topandapisit@hotmail.com" && pwd!="5555555"){
				String result="Password Incorrect";
				return result;
			}
			else{
				String result="E-mail and Password Incorrect";
				return result;
			}
		}
	}
	public static void main(String [] args){
		LoginService service = new LoginService();
		String chkLogin = service.checkLogin("topandapisit@hotmail.com","5555555");
		System.out.println(chkLogin);
	}
}