package com.scap.testweb.dao;

import com.scap.testweb.utils.DbConnector;

public class UserDao {
	public String getEmail(String mail){
		String sql = "select email form userAccount where email = mail";
 
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.doConnect();
		}
		catch (Exception e) { System.out.println(e); }
		//String sql = "1234@gmail.com";
 
		return sql;
	}
	
	public void setUserAccount(String userPassword, String userEmail){
		String accout = "INSERT TABLE USERACCOUNT(USER_EMAIL, USER_PASSWORD, DATE)VALUES('userEmail','userPassword');";
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.doConnect();
		}
		catch (Exception e) { System.out.println(e); }
	}
}
