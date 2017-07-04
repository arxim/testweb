package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ChangePwdDao {
	public ArrayList<HashMap<String, String>> changePwdDao(String email) {
		String sql = "SELECT PASSWORD FROM LEAVE_MST_USER WHERE EMAIL = '" + email +"'"; 

		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String, String>> pPass = new ArrayList<HashMap<String, String>>();
		try{
			dbconn.doConnect();
			pPass = dbconn.getData(sql);
			return pPass;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return pPass;
			}	
	}

}