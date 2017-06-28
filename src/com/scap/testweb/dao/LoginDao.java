package com.scap.testweb.dao;

import com.scap.testweb.service.LoginService;
import com.scap.testweb.utils.DbConnector;

public class LoginDao {
	public String chkLogin(String email,String md5){
		String s="";
		String data = "select EMAIL,PASSWORD from LEAVE_MST_SIGNUP_TOPMYZA where EMAIL = '"+email+"' and PASSWORD = '"+md5+"'";
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.getConnection();
			if(dbconn.getData(data).size()==1){
				s="Login Success!!!";
			}
			else{
				s="E-mail or Password wrong!!!";
			}
		}
		catch (Exception e) {
			System.out.println(e);
			s="Can not connect at this time.";
		}
		return s;
	}
}
