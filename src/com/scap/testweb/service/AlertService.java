package com.scap.testweb.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class AlertService {
	public static void main(String[] args) {
		AlertService service = new AlertService();
		
	//	UPDATE Date in database
	//	SELECT curdate(); <= Date
		
		String upDate = "20170615";
		System.out.println("Update : " + upDate);
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		try {
				Date date = df.parse(upDate);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				
			//	System.out.println("Full Date : " + date);
			//	System.out.println("Time : " + date.getTime());
				
				int year = c.get(Calendar.YEAR);
			//	System.out.println("Year : " + year);
				
				int month = c.get(Calendar.MONTH) + 1;
			//	System.out.println("Month : " + month);
				
				int day = c.get(Calendar.DATE);
			//	System.out.println("Day : " + day);
				
				
			//	System.out.println("Hour : " + c.get(Calendar.HOUR_OF_DAY));
			//	System.out.println("Minute : " + c.get(Calendar.MINUTE));
			//	System.out.println("Second : " + c.get(Calendar.SECOND));
				
				boolean calculate = service.calculate(year, month, day);
				
				if(calculate == true){
					System.out.println("Welcome.");
				}
				else{
					System.out.println("You have been using your password for more than 90 days. Please change your password.");
				}
				
			} catch(ParseException e) {
				e.printStackTrace();
				System.out.println(e);
			}
	}
	
	public boolean calculate(int year, int month, int day){
	//	SELECT Date from database	
	//	String pDate = getDate("yui@gmail.com");
		
		String pDate = "20170315";
		System.out.println("  Date : " + pDate);
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		try{
				Date date = df.parse(pDate);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
		
				int pastyear = c.get(Calendar.YEAR);
			//	System.out.println("Year : " + pastyear);
		
				int pastmonth = c.get(Calendar.MONTH) + 1;
			//	System.out.println("Month : " + pastmonth);
		
				int pastday = c.get(Calendar.DATE);
			//	System.out.println("Day : " + pastday);
				
				if(year == pastyear ){
					if(month == pastmonth){
						return true;
					}
					else if(month != pastmonth){
						if((month - pastmonth) < 3){
							return true;
						}
						else if((month - pastmonth) > 3){
							return false;
						}
						else if((month - pastmonth) == 3){
							if(day < pastday){
								return true;
							}
							else if(day >= pastday){
								return false;
							}
						}
					}
					
				}
				else
					return true;
		
		}catch(ParseException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	
	}

/*	private String getDate(String mail) {
		String sql = "SELECT DATE FROM ALERT WHERE EMAIL='" + email + "'"; ;
		DbConnector dbconn = new DbConnector();
		String pDate = null;
		try{
			dbconn.doConnect();
			
			pDate = dbconn.getData(sql);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		return pDate;
	}		*/
		
}
