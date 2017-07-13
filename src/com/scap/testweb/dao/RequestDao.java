package com.scap.testweb.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class RequestDao {
	public boolean setRequestOnLeave(String employee_id,String boss_id,String typeLeave,String startDate,String endDate,String note,String status){
		String request_date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String rqtData = "INSERT INTO LEAVE_MST_LEAVE(EMPLOYEE_ID,BOSS_ID,LEAVE_TYPE,START_DATE,END_DATE,REQUEST_DATE,NOTE,SATUS) VALUES('"+employee_id+"','"+boss_id+"','"+typeLeave+"','"+startDate+"','"+endDate+"','"+request_date+"','"+note+"','"+status+"')";
		DbConnector dbconn = new DbConnector();
		boolean resultRqt = false;
		try{
			dbconn.doConnect();
			dbconn.doSave(rqtData);
			dbconn.doCommit();
			resultRqt = true;
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return resultRqt;
	}
	
	public ArrayList<HashMap<String, String>> getDataUser(String email){
		String sql = "SELECT * FROM LEAVE_MST_USER WHERE EMAIL='" + email + "'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> resultID = null;
		try{
			dbconn.doConnect();
			resultID = dbconn.getData(sql);
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return resultID;
	}
	
	public ArrayList<HashMap<String, String>> gstDataBoss(String department) {
		String sql = "SELECT * FROM LEAVE_MST_USER WHERE DEPARTMENT ='" + department + "' AND STATUS = 'BOSS'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> result = null;
		try{
			dbconn.doConnect();
			result = dbconn.getData(sql);
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return result;
	}
	
	public ArrayList<HashMap<String, String>> getDataLeave(String id){
		String sql = "SELECT * FROM LEAVE_MST_LEAVE WHERE EMAIL='" + id + "'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> resultFirstName = null;
		try{
			dbconn.doConnect();
			resultFirstName = dbconn.getData(sql);
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return resultFirstName;
	}
	
	
}
