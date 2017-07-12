package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ApproveDao {
	public ArrayList<HashMap<String,String>> selectData (String status){
		String sql = "SELECT * FROM WHERE = status";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> data = null;
		try{
			dbconn.doConnect();
			data = dbconn.getData(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		return data;
	}
	
	
	
}
