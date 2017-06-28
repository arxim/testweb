package com.scap.testweb.service;


public class Test {

	public static void main(String[] args) {
		LoginService logInSrv = new LoginService();
		String result=logInSrv.verifyLogin("test@hotmail.com", "welcome");
		System.out.println(result);
	}
}
