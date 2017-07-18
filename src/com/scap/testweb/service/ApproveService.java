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
	
	public String approveData(String status, String code){
		ApproveDao approve = new ApproveDao();
		return approve.approveData(status,code);
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
}
