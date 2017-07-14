package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.scap.testweb.dao.ApproveDao;
import com.scap.testweb.model.User;

public class ApproveService {
	
	public List<User> showData(String status){
		//data table where status = pending or approve
		ApproveDao data = new ApproveDao();
		return data.selectData(status);
	}
}
