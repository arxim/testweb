package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ShowListReportDao {
	public ArrayList<HashMap<String,String>> getListDataDB(){ // query select email for check in DB
		String sql = "SELECT * FROM LEAVE_MST_USER";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> result = null;
		try{
			dbconn.doConnect();  //connect DB
			result = dbconn.getData(sql); //select data in DB
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return result;
	}
}
