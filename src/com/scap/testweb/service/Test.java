package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.dao.ForgotPwdDao;

public class Test {

	public static void main(String[] args) {
		ForgotPwdDao t= new  ForgotPwdDao();
		ForgotPwdService tt= new  ForgotPwdService();
		
		SignUpService t2 = new SignUpService();
//		boolean a = t2.chackPassword("^+45#5");
		tt.genPassword(6,8);
//		System.out.println(a);
		
//		ArrayList<HashMap<String,String>> result=t.updateGenPassword("topandapisit@hotmail.com","11111111");
//		System.out.println(result);
//		tt.genPassword("topandapisit@hotmail.com");
	}
}
