package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import com.scap.testweb.utils.DbConnector;


public class AlertDao {
	
	public ArrayList<HashMap<String, String>> getDate(String email) {
		String sql = "SELECT "
				+ "CASE WHEN UPDATE_DATE IS NULL THEN CREATE_DATE "
				+ "ELSE UPDATE_DATE END "
				+ "FROM LEAVE_MST_USER "
				+ "WHERE EMAIL = '" + email +"'"; 

		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String, String>> dPast = new ArrayList<HashMap<String, String>>();
		try{
			dbconn.doConnect();
			dPast = dbconn.getData(sql);
			return dPast;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return dPast;
			}
	}	
}
