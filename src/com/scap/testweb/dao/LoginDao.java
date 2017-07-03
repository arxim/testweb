package com.scap.testweb.dao;


import com.scap.testweb.utils.DbConnector;

public class LoginDao {
	public boolean getEmailPassword(String email,String md5){
		boolean s=false;
		String data = "select EMAIL,PASSWORD from LEAVE_MST_USER where EMAIL = '"+email+"' and PASSWORD = '"+md5+"'";
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.getConnection();
			if(dbconn.getData(data).size()==1){
				s=true;
			}
			else{
				s=false;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return s;
	}
}
