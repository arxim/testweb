package com.scap.testweb.dao;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ShowListReportDao {
	public ArrayList<HashMap<String,String>> getListDataDBNoNameSurname(String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
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
	public ArrayList<HashMap<String,String>> getListDataDBNoName(String surname,String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
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
	public ArrayList<HashMap<String,String>> getListDataDBNoSurname(String name,String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
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
	public ArrayList<HashMap<String,String>> getListDataDB(String name,String surname,String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
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
