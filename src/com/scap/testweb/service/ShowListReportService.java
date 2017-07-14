package com.scap.testweb.service;

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
	public static String changeformatDateToShow(String dmy){
		String s="";
		SimpleDateFormat sdmy=new SimpleDateFormat("yyyymmdd");
		SimpleDateFormat sdmys=new SimpleDateFormat("dd/mm/yyyy");
		try{
			Date date = sdmy.parse(dmy);
	        s=sdmys.format(date);
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
