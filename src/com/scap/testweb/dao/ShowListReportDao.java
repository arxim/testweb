package com.scap.testweb.dao;

import java.sql.SQLData;
import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ShowListReportDao {
	public ArrayList<HashMap<String,String>> getListDataDBNoNameSurname(String department,String position,String fDBMinday,String fDBMaxday,String leavetype){ // query select email for check in DB
		String sql = "select ROW_NUMBER() OVER(ORDER BY LEAVE_MST_USER.FIRST_NAME ASC) AS NO,LEAVE_MST_USER.FIRST_NAME,"
				+" LEAVE_MST_USER.LAST_NAME,LEAVE_MST_USER.DEPARTMENT,LEAVE_MST_USER.POSITION,LEAVE_MST_LEAVE.LEAVE_TYPE,LEAVE_MST_LEAVE.START_DATE,LEAVE_MST_LEAVE.END_DATE "
				+" from LEAVE_MST_USER,LEAVE_MST_LEAVE " 
				+" WHERE (LEAVE_MST_USER.ID=LEAVE_MST_LEAVE.EMPLOYEE_ID) AND (LEAVE_MST_LEAVE.STATUS='อนุมัติ') " 
				+" AND (LEAVE_MST_USER.DEPARTMENT='"+department+"') AND (LEAVE_MST_USER.POSITION='"+position+"') "
				+" AND (LEAVE_MST_LEAVE.START_DATE BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"') "
				+" AND (LEAVE_MST_USER.LEAVE_TYPE='" + leavetype + "') ";
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
		String sql = "select ROW_NUMBER() OVER(ORDER BY LEAVE_MST_USER.FIRST_NAME ASC) AS NO,LEAVE_MST_USER.FIRST_NAME,"
				+"LEAVE_MST_USER.LAST_NAME,LEAVE_MST_USER.DEPARTMENT,LEAVE_MST_USER.POSITION,LEAVE_MST_LEAVE.LEAVE_TYPE,LEAVE_MST_LEAVE.START_DATE,LEAVE_MST_LEAVE.END_DATE from LEAVE_MST_USER,LEAVE_MST_LEAVE" 
				+"WHERE (LEAVE_MST_USER.ID=LEAVE_MST_LEAVE.EMPLOYEE_ID) AND (LEAVE_MST_LEAVE.STATUS='อนุมัติ')" 
				+" AND (LEAVE_MST_USER.LAST_NAME='"+surname+"') AND (LEAVE_MST_USER.DEPARTMENT='"+department+"') AND (LEAVE_MST_USER.POSITION='"+position+"')"
				+" AND (LEAVE_MST_LEAVE.START_DATE BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"')"
				+" AND (LEAVE_MST_USER.LEAVE_TYPE='"+leavetype+"')";
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
		String sql = "select ROW_NUMBER() OVER(ORDER BY LEAVE_MST_USER.FIRST_NAME ASC) AS NO,LEAVE_MST_USER.FIRST_NAME,"
				+"LEAVE_MST_USER.LAST_NAME,LEAVE_MST_USER.DEPARTMENT,LEAVE_MST_USER.POSITION,LEAVE_MST_LEAVE.LEAVE_TYPE,LEAVE_MST_LEAVE.START_DATE,LEAVE_MST_LEAVE.END_DATE from LEAVE_MST_USER,LEAVE_MST_LEAVE" 
				+"WHERE (LEAVE_MST_USER.ID=LEAVE_MST_LEAVE.EMPLOYEE_ID) AND (LEAVE_MST_LEAVE.STATUS='อนุมัติ')" 
				+" AND (LEAVE_MST_USER.FIRST_NAME='"+name+"') AND (LEAVE_MST_USER.DEPARTMENT='"+department+"') AND (LEAVE_MST_USER.POSITION='"+position+"')"
				+" AND (LEAVE_MST_LEAVE.START_DATE BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"')"
				+" AND (LEAVE_MST_USER.LEAVE_TYPE='"+leavetype+"')";
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
		String sql = "select ROW_NUMBER() OVER(ORDER BY LEAVE_MST_USER.FIRST_NAME ASC) AS NO,LEAVE_MST_USER.FIRST_NAME,"
				+"LEAVE_MST_USER.LAST_NAME,LEAVE_MST_USER.DEPARTMENT,LEAVE_MST_USER.POSITION,LEAVE_MST_LEAVE.LEAVE_TYPE,LEAVE_MST_LEAVE.START_DATE,LEAVE_MST_LEAVE.END_DATE from LEAVE_MST_USER,LEAVE_MST_LEAVE" 
				+"WHERE (LEAVE_MST_USER.ID=LEAVE_MST_LEAVE.EMPLOYEE_ID) AND (LEAVE_MST_LEAVE.STATUS='อนุมัติ')" 
				+" AND (LEAVE_MST_USER.FIRST_NAME='"+name+"') AND (LEAVE_MST_USER.LAST_NAME='"+surname+"') AND (LEAVE_MST_USER.DEPARTMENT='"+department+"') AND (LEAVE_MST_USER.POSITION='"+position+"')"
				+" AND (LEAVE_MST_LEAVE.START_DATE BETWEEN '"+fDBMinday+"' AND '"+fDBMaxday+"')"
				+" AND (LEAVE_MST_USER.LEAVE_TYPE='"+leavetype+"')";
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
