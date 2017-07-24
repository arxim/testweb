package com.scap.testweb.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class EditRequestDao {

	public ArrayList<HashMap<String, String>> getDataLeave(long id){
		String sql = "SELECT * FROM LEAVE_MST_LEAVE WHERE CODE='" + id + "'";
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
	
	public ArrayList<HashMap<String, String>> getDataUserId(String id){
		String sql = "SELECT * FROM LEAVE_MST_USER WHERE ID='" + id + "'";
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
	
	public boolean setEditRequestOnLeave(String leave_code,String typeLeave,String startDate,String endDate,String dateDiff,String note){
		String update_date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String sql = "UPDATE LEAVE_MST_LEAVE SET LEAVE_TYPE = '"+ typeLeave +"', START_DATE = '"+ startDate +"', END_DATE = '"+ endDate +"', NUM_LEAVE = '"+ dateDiff +"',REQUEST_DATE = '"+ update_date +"', NOTE = '"+ note +"' WHERE CODE='"+ leave_code +"'";
		DbConnector dbconn = new DbConnector();
		boolean result = false;
		try{
			dbconn.doConnect();
			dbconn.doSave(sql);
			dbconn.doCommit();
			result = true;
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return result;
	}
	
	public boolean setApprove(long code, String status){
		String approve_date = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String sql = "UPDATE LEAVE_MST_LEAVE SET APPROVE_DATE = '"+ approve_date +"', STATUS = '"+ status +"' WHERE CODE='"+ code +"';";
		DbConnector dbconn = new DbConnector();
		boolean result = false;
		try{
			dbconn.doConnect();
			dbconn.doSave(sql);
			dbconn.doCommit();
			result = true;
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return result;
	}
	
}
