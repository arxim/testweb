package com.scap.testweb.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class UserDao {
	
	public ArrayList<HashMap<String,String>> getEmail(String mail){
		String sql = "SELECT EMAIL FROM LEAVE_MST_SIGNUP_PEAR WHERE EMAIL='" + mail + "'";
		
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
		String account = "INSERT INTO LEAVE_MST_SIGNUP_PEAR(EMAIL, PASSWORD) VALUES('"+userEmail+"','"+userPassword+"')";
		String chkAccount = "SELECT * FROM LEAVE_MST_SIGNUP_PEAR WHERE EMAIL='" + userEmail + "'";
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
