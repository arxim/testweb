package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.dao.ApproveDao;

public class ApproveService {
	
	public String showData(String status){
		ApproveDao data = new ApproveDao();
		ArrayList<HashMap<String,String>> dtDao = data.selectData(status);
		
		String dataDao = dtDao.get(0).get(0);
		return dataDao;
	}
}
