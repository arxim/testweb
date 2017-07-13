package com.scap.testweb.service;

import com.scap.testweb.dao.ShowListReportDao;

public class ShowListReportService {
	public boolean getListOnLeave(){
		ShowListReportDao slrDao=new ShowListReportDao();
		if(slrDao.getListDataDB().size()==9){
			return true;
		}
		else{
			return false;
		}
	}
}
