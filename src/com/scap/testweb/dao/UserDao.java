package com.scap.testweb.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;
import com.scap.testweb.utils.Utils;

public class UserDao {
	
	public ArrayList<HashMap<String,String>> getEmail(String mail){
		String sql = "SELECT EMAIL FROM LEAVE_MST_USER WHERE EMAIL='" + mail + "'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> resultDataEmail = null;
		try{
			dbconn.doConnect();
			resultDataEmail = dbconn.getData(sql);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		return resultDataEmail;
	}

	public ArrayList<HashMap<String,String>> setUserAccount(String userEmail, String userPassword){
		String dateStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		String timeStamp = new SimpleDateFormat("HHmmss").format(Calendar.getInstance().getTime());
		long signUpCode = Utils.generateSignUpCode();
	    String account = "INSERT INTO LEAVE_MST_USER(SIGNUP_CODE,EMAIL, PASSWORD, CREATE_DATE, CREATE_TIME) VALUES('"+signUpCode+"','"+userEmail+"','"+userPassword+"','"+dateStamp+"','"+timeStamp+"')";
		String chkAccount = "SELECT * FROM LEAVE_MST_USER WHERE EMAIL='" + userEmail + "'";
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String,String>> resultDataAccount = null;
		try{
			dbconn.doConnect();
			dbconn.doSave(account);
			dbconn.doCommit();
			resultDataAccount = dbconn.getData(chkAccount);
		}
		catch (Exception e) { 
			e.printStackTrace();
			System.out.println(e);
			}
		return resultDataAccount;
	}
}
