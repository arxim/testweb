package com.scap.testweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.scap.testweb.model.User;
import com.scap.testweb.utils.DbConnector;

public class ShowListReportDao {
	public static String changeformatDateToShow(String dmy){
		String s="";
		SimpleDateFormat sdmy=new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat sdmys=new SimpleDateFormat("dd/mm/yyyy");
		try{
			Date date = sdmy.parse(dmy);
	        s=sdmys.format(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return s;
	}
	public List<User> getListDataDB(String name,String surname,String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
		String sql=" select ROW_NUMBER() OVER(ORDER BY LEAVE_MST_USER.[FIRST_NAME] ASC) AS NO,LEAVE_MST_USER.[FIRST_NAME],"
				+"LEAVE_MST_USER.[LAST_NAME],LEAVE_MST_USER.[DEPARTMENT],LEAVE_MST_USER.[POSITION],LEAVE_MST_LEAVE.[LEAVE_TYPE],"
				+"LEAVE_MST_LEAVE.[START_DATE],LEAVE_MST_LEAVE.[END_DATE] FROM LEAVE_MST_USER" 
				+" JOIN LEAVE_MST_LEAVE ON LEAVE_MST_LEAVE.[EMPLOYEE_ID]=LEAVE_MST_USER.[ID] WHERE (LEAVE_MST_LEAVE.[STATUS]='อนุมัติ')"
				+" AND (LEAVE_MST_LEAVE.[START_DATE] BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"')"
				+" AND (LEAVE_MST_LEAVE.[END_DATE] BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"')";
		if(!name.isEmpty() && name!=null){
			sql+="AND (LEAVE_MST_USER.[FIRST_NAME]='"+name+"')";
		}
		if(!surname.isEmpty() && surname!=null){
			sql+="AND (LEAVE_MST_USER.[LAST_NAME]='"+surname+"')";
		}
		if(!department.isEmpty() && department!=null){
			sql+="AND (LEAVE_MST_USER.[DEPARTMENT]='"+department+"')";
		}
		if(!position.isEmpty() && position!=null){
			sql+="AND (LEAVE_MST_USER.[POSITION]='"+position+"')";
		}
		if(!leavetype.isEmpty() && leavetype!=null){
			sql+="AND (LEAVE_MST_LEAVE.[LEAVE_TYPE]='"+leavetype+"')";
		}
		DbConnector dbconn = new DbConnector();
		List<User> users = new ArrayList<User>();
		try{
			Connection conn = dbconn.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserNo(rs.getString("NO"));
				user.setFirstAndLastname(rs.getString("FIRST_NAME"),rs.getString("LAST_NAME"));
				user.setDepartment(rs.getString("DEPARTMENT"));
				user.setPosition(rs.getString("POSITION"));
				user.setLeaveType(rs.getString("LEAVE_TYPE"));
				user.setStartDate(changeformatDateToShow(rs.getString("START_DATE")));
				user.setEndDate(changeformatDateToShow(rs.getString("END_DATE")));
				users.add(user);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		return users;
	}
}
