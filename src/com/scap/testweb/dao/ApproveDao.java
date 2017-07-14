package com.scap.testweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.scap.testweb.model.User;
import com.scap.testweb.utils.DbConnector;

public class ApproveDao {
	public List<User> selectData (String status){
//		String sql = "SELECT LEAVE_MST_USER.[ID], LEAVE_MST_LEAVE.[REQUEST_DATE], LEAVE_MST_USER.[FIRST_NAME], LEAVE_MST_USER.[LAST_NAME], "
//					+ "LEAVE_MST_USER.[DEPARTMENT], LEAVE_MST_USER.[POSITION], LEAVE_MST_LEAVE.[LEAVE_TYPE], "
//					+ "LEAVE_MST_LEAVE.[STATUS], LEAVE_MST_LEAVE.[APPROVE_DATE] FROM LEAVE_MST_USER, LEAVE_MST_LEAVE ";
//		if (status != null && !status.isEmpty()) {
//			sql += "WHERE (LEAVE_MST_USER.FIRST_NAME != 'NULL') AND (LEAVE_MST_LEAVE.STATUS = '"+status+"') AND (LEAVE_MST_USER.ID = LEAVE_MST_LEAVE.EMPLOYEE_ID)";
//		}
		
		String sql = " SELECT LEAVE_MST_USER.[ID], LEAVE_MST_LEAVE.[REQUEST_DATE], LEAVE_MST_USER.[FIRST_NAME], LEAVE_MST_USER.[LAST_NAME], " 
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
				user.setUserId(rs.getString("ID"));
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
		
		
//		ArrayList<HashMap<String,String>> data = null;
//		
//		try{
//			dbconn.doConnect();
//			data = dbconn.getData(sql);
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			System.out.println(e);
//			}
		return users;
	}
	
	
	
}
