package com.scap.testweb.dao;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class ForgotPwdDao {
	public ArrayList<HashMap<String,String>> checkEmailDB(String email){ // query select email for check in DB
		String sql = "SELECT EMAIL FROM LEAVE_MST_USER WHERE EMAIL='" + email + "'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> result = null;
		try{
			dbconn.doConnect();  //connect DB
			result = dbconn.getData(sql); //select data in DB
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		return result;
	}
	public void updateGenPassword(String email, String genPwd){ // query update PASSWORD,UPDATE_DATE,UPDATE_TIME for edit data in DB
		String dateStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());// last update y/m/d
		String timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());// last update time (AM:PW,min,sec)
	    String updateData = "UPDATE LEAVE_MST_USER SET PASSWORD='"+genPwd+"',UPDATE_DATE='"+dateStamp+"',UPDATE_TIME='"+timeStamp+"' WHERE EMAIL='"+email+"'";
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.doConnect(); //connect DB
			dbconn.doSave(updateData);//Save data in DB
			dbconn.doCommit();//confilm data for save in DB
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
