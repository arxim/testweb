package com.scap.testweb.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlertService {
	public static void main(String[] args) {
		String sDate = "2017-02-22";   
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
				Date date = df.parse(sDate);
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				
			//	System.out.println("Full Date : " + date);
			//	System.out.println("Time : " + date.getTime());
				
				int year = c.get(Calendar.YEAR);
				System.out.println("Year : " + year);
				
				int month = c.get(Calendar.MONTH) + 1;
				System.out.println("Month : " + month);
				
				int day = c.get(Calendar.DATE);
				System.out.println("Day : " + day);
				
			//	System.out.println("Hour : " + c.get(Calendar.HOUR_OF_DAY));
			//	System.out.println("Minute : " + c.get(Calendar.MINUTE));
			//	System.out.println("Second : " + c.get(Calendar.SECOND));
				
				calculate(year, month, day);
				
			} catch(ParseException e) {
				e.printStackTrace();
			}
		
		
				
		//AlertService starttime = new AlertService ();

		
		//boolean past = starttime.pastTime(100);
		
		//System.out.println(past);
	}
	
	public static boolean calculate(int yyyy, int MM, int dd){
		boolean newyear = true;
		
		
		
		return newyear;
		
	
	
	}

}
