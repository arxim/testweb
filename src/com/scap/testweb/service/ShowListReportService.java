package com.scap.testweb.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.scap.testweb.dao.ShowListReportDao;
import com.scap.testweb.model.User;

public class ShowListReportService {
	public static String changeformatDateToDB(String dmyslash){
		String s="";
		SimpleDateFormat tdmys=new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat tdmy=new SimpleDateFormat("yyyymmdd");
		try{
			Date date = tdmys.parse(dmyslash);
	        s=tdmy.format(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return s;
	}
	public List<User> getListOnLeave(String name,String surname,String department,String position,String minday,String maxday,String leavetype,String statustype){
		String fDBMinday=changeformatDateToDB(minday);
		String fDBMaxday=changeformatDateToDB(maxday);
		ShowListReportDao slrdao = new ShowListReportDao();
		return slrdao.getListDataDB(name,surname,department,position,fDBMinday,fDBMaxday,leavetype,statustype);
	}
}
