package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.scap.testweb.dao.ApproveDao;
import com.scap.testweb.model.User;

public class ApproveService {
	
	public List<User> showData(String status){
		ApproveDao data = new ApproveDao();
		return data.selectData(status);
	}
	//boss click approve
	public String approveData(String status, String rowID){
		ApproveDao approve = new ApproveDao();
		String click = approve.approveData(status,rowID);
		return click;
	}
	
	public String personal(String userLogin){
		ApproveDao dbUser = new ApproveDao();
		ArrayList<HashMap<String,String>> db = dbUser.personalInfor(userLogin);
		String userID = db.get(0).get("ID");
		return userID;
	}
	
	public List<User> leave(String userID){
		ApproveDao data = new ApproveDao();
		return data.selectLeave(userID);
	}
	
	public String findEmployeeID(String code){
		ApproveDao dbUser = new ApproveDao();
		ArrayList<HashMap<String,String>> db1 = dbUser.getEmployeeID(code);
		String id = db1.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String,String>> db2 = dbUser.getEmailUser(id);
		String email = db2.get(0).get("EMAIL");
		return email;
	}
	
}
