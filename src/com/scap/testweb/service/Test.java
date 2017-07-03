package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.dao.ForgotPwdDao;

import java.security.*;
import java.math.*;

public class Test {
    public String cryptWithMD5(String pass) throws Exception{
        String s=pass;
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger(1,m.digest()).toString(16);
    }
	public static void main(String[] args) throws Exception {
		Test g=new Test();
//		ForgotPwdDao t= new  ForgotPwdDao();
//		ForgotPwdService tt= new  ForgotPwdService();
//		SignUpService t2 = new SignUpService();
//		String e= tt.genPassword(6,8);
//		System.out.println(e);
//	    boolean p=t2.chackPassword(e);
//	    System.out.println(p);
//		System.out.println(a);
		
//		ArrayList<HashMap<String,String>> result=t.updateGenPassword("topandapisit@hotmail.com","11111111");
//		System.out.println(result);
//		tt.genPassword("topandapisit@hotmail.com");	     
		String pass=g.cryptWithMD5("This is a test");
		System.out.println(pass);
	}
}
