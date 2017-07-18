package com.scap.testweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.scap.testweb.model.User;
import com.scap.testweb.utils.DbConnector;

public class ApproveDao {
	public List<User> selectData (String status){		
		String sql = " SELECT LEAVE_MST_LEAVE.[CODE], LEAVE_MST_LEAVE.[REQUEST_DATE], LEAVE_MST_USER.[FIRST_NAME], LEAVE_MST_USER.[LAST_NAME], " 
				+ " LEAVE_MST_USER.[DEPARTMENT], LEAVE_MST_USER.[POSITION], LEAVE_MST_LEAVE.[LEAVE_TYPE], "
				+ " LEAVE_MST_LEAVE.[STATUS], LEAVE_MST_LEAVE.[APPROVE_DATE] "
				+ " FROM LEAVE_MST_LEAVE "
				+ " JOIN LEAVE_MST_USER ON LEAVE_MST_LEAVE.EMPLOYEE_ID = LEAVE_MST_USER.ID ";
				
		if (status != null && !status.isEmpty()) {
			sql += " WHERE LEAVE_MST_LEAVE.STATUS = '" + status + "'";
		}
					
		DbConnector dbconn = new DbConnector();
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setCode(rs.getString("CODE"));
				user.setRequestDate(rs.getString("REQUEST_DATE"));
				user.setFirstname(rs.getString("FIRST_NAME"));
				user.setLastname(rs.getString("LAST_NAME"));
				user.setDepartment(rs.getString("DEPARTMENT"));
				user.setPosition(rs.getString("POSITION"));
				user.setApproveDate(rs.getString("APPROVE_DATE"));
				user.setLeaveType(rs.getString("LEAVE_TYPE"));
				user.setStatus(rs.getString("STATUS"));
				users.add(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	
	public String approveData (String status, String code){
		//click button change status
		DbConnector dbconn = new DbConnector();
		if(status == "รออนุมัติ"){
			String approveDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			String sql = "UPDATE LEAVE_MST_LEAVE SET STATUS = 'อนุมัติ', APPROVE_DATE = '"+approveDate+"' WHERE CODE = '" + code + "'";
			dbconn.doConnect();
			dbconn.doSave(sql);
			dbconn.doCommit();
			return "อนุมัติ";
		}
		else if(status == "อนุมัติ"){
			String approveDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
			String sql = "UPDATE LEAVE_MST_LEAVE SET STATUS = 'รออนุมัติ', APPROVE_DATE = '"+approveDate+"' WHERE CODE = '" + code + "'";
			dbconn.doConnect();
			dbconn.doSave(sql);
			dbconn.doCommit();
			return "รออนุมัติ";
		}
		return "false";
	}
	
	public ArrayList<HashMap<String,String>> personalInfor (String email){
		//EMAIL => ID (USER)
		String sql = " SELECT * FROM LEAVE_MST_USER WHERE EMAIL = '" + email + "'";
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
	
	public List<User> selectLeave (String userID){		
		String sql = "SELECT LEAVE_MST_LEAVE.[CODE], LEAVE_MST_LEAVE.[REQUEST_DATE], "
				+ "LEAVE_MST_USER.[FIRST_NAME],	LEAVE_MST_USER.[LAST_NAME],	LEAVE_MST_USER.[DEPARTMENT], "
				+ "LEAVE_MST_USER.[POSITION], LEAVE_MST_LEAVE.[LEAVE_TYPE],	LEAVE_MST_LEAVE.[STATUS], "
				+ "LEAVE_MST_LEAVE.[APPROVE_DATE] "
				+ "FROM	LEAVE_MST_LEAVE "
				+ "JOIN LEAVE_MST_USER ON LEAVE_MST_LEAVE.EMPLOYEE_ID = LEAVE_MST_USER.ID "
				+ "WHERE LEAVE_MST_LEAVE.EMPLOYEE_ID = '" + userID + "'";

		DbConnector dbconn = new DbConnector();
		List<User> users = new ArrayList<User>();
		try {
			Connection conn = dbconn.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setCode(rs.getString("CODE"));
				user.setRequestDate(rs.getString("REQUEST_DATE"));
				user.setFirstname(rs.getString("FIRST_NAME"));
				user.setLastname(rs.getString("LAST_NAME"));
				user.setDepartment(rs.getString("DEPARTMENT"));
				user.setPosition(rs.getString("POSITION"));
				user.setApproveDate(rs.getString("APPROVE_DATE"));
				user.setLeaveType(rs.getString("LEAVE_TYPE"));
				user.setStatus(rs.getString("STATUS"));
				users.add(user);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
}
