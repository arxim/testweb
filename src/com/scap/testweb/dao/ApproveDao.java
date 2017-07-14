package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ApproveDao {
	public ArrayList<HashMap<String,String>> selectData (String status){
		String sql = "SELECT LEAVE_MST_LEAVE.[REQUEST_DATE], LEAVE_MST_USER.[FIRST_NAME], LEAVE_MST_USER.[LAST_NAME], "
					+ "LEAVE_MST_USER.[DEPARTMENT], LEAVE_MST_USER.[POSITION], LEAVE_MST_LEAVE.[LEAVE_TYPE], "
					+ "LEAVE_MST_LEAVE.[STATUS], LEAVE_MST_LEAVE.[APPROVE_DATE] FROM LEAVE_MST_USER, LEAVE_MST_LEAVE "
					+ "WHERE (LEAVE_MST_USER.FIRST_NAME != 'NULL')AND (LEAVE_MST_LEAVE.STATUS = '"+status+"') AND (LEAVE_MST_USER.ID = LEAVE_MST_LEAVE.EMPLOYEE_ID)";
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
