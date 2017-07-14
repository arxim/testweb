package com.scap.testweb.service;

import java.sql.SQLDataException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.scap.testweb.dao.ShowListReportDao;

public class ShowListReportService {
	public String validateNameAndSurname(String name,String surname){
		String s;
		if(name=="" && surname==""){
			s="nns";
		}
		else if(name=="" && surname!=""){
			s="nn";
		}
		else if(name!="" && surname==""){
			s="ns";
		}
		else{
			s="ok";
		}
		return s;
	}
	public static String changeformatDateToDB(String ymdslash){
		String s="";
		SimpleDateFormat tymds=new SimpleDateFormat("yyyy/mm/dd");
		SimpleDateFormat tymd=new SimpleDateFormat("yyyymmdd");
		try{
			Date date = tymds.parse(ymdslash);
	        s=tymd.format(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return s;
	}
	public static String changeformatDateToShow(String ymd){
		String s="";
		SimpleDateFormat symd=new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat symds=new SimpleDateFormat("yyyy/mm/dd");
		try{
			Date date = symd.parse(ymd);
	        s=symds.format(date);
		}
		catch(ParseException e){
			e.printStackTrace();
		}
		return s;
	}
	public void getListOnLeave(String name,String surname,String department,String position,String minday,String maxday,String leavetype){
		ShowListReportDao slrDao=new ShowListReportDao();
		String fDBMinday=changeformatDateToDB(minday);
		String fDBMaxday=changeformatDateToDB(maxday);
		String status=validateNameAndSurname(name,surname);
		ArrayList<HashMap<String,String>> t=null;
		if(status=="nns"){
			t=slrDao.getListDataDBNoNameSurname(department,position,fDBMinday,fDBMaxday,leavetype);
		}
		else if(status=="nn"){
			t=slrDao.getListDataDBNoName(surname,department,position,fDBMinday,fDBMaxday,leavetype);
		}
		else if(status=="ns"){
			t=slrDao.getListDataDBNoSurname(name,department,position,fDBMinday,fDBMaxday,leavetype);
		}
		else{
			t=slrDao.getListDataDB(name,surname,department,position,fDBMinday,fDBMaxday,leavetype);
		}
		System.out.println(t);
	}
}
