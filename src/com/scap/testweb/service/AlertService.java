package com.scap.testweb.service;


import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.scap.testweb.dao.AlertDao;

public class AlertService {
	/*public static void main(String[] args) {
		AlertService service = new AlertService();
		
		String email = "yui@gmail.com";
		
	//	UPDATEorInsert Date in database
		String sql = "INSERT INTO ALERT (UPDATE) VALUES getdate() WHERE EMAIL='" + email + "'"; ;
		DbConnector dbconn = new DbConnector();
		dbconn.doConnect();
		
	//	database	
		dbconn.doDisconnect();	
		
		try{
			
			
			Date dNow = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			System.out.println("      Current date : " + df.format(dNow));	
			
			Calendar c = Calendar.getInstance();	

			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
			
	//		System.out.printf("%d %d %d\n",year, month, day);

			boolean calculate = service.calculate(email, year, month, day);
				
			if(calculate == true){
				System.out.println("Welcome.");
			}
			else{
				System.out.println("You have been using your password for more than 90 days. Please change your password.");
			}
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		   
		}
	
	}*/
	
	public boolean compareDate(String email){
		AlertService service = new AlertService();
		try{
			Date dNow = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			df.format(dNow);
	//		System.out.println("      Current date : " + df.format(dNow));
			Calendar c = Calendar.getInstance();	
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
	//		System.out.printf("%d %d %d\n",year, month, day);
			boolean calculate = service.calculate(email, year, month, day);
			if(calculate){
				return true;
			}
			else{
				return false;
				//System.out.println("You have been using your password for more than 90 days. Please change your password.");
			}
		}	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}	
	}
	
	public boolean calculate(String email, int year, int month, int day){
	//	SELECT Date from database	
		AlertDao alertdao = new AlertDao();
		ArrayList<HashMap<String, String>> dPast = alertdao.getDate(email);
		try{
			String dPastdate = dPast.get(0).get("");
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			Date date = df.parse(dPastdate);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			//System.out.println("Create/Update date : " + df.format(date));		
			int pastyear = c.get(Calendar.YEAR);		
			int pastmonth = c.get(Calendar.MONTH) + 1;
			int pastday = c.get(Calendar.DATE);
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
			else if(year != pastyear){
				if((year - pastyear) == 1){
					if((month == 1) && (pastmonth == 10)){
						if(day >= pastday){
							return false;
						}
						else{
							return true;
						}
					}
					else if((month == 2) && (pastmonth == 11)){
						if(day >= pastday){
							return false;
						}
						else{
							return true;
						}
					}
					else if((month == 3) && (pastmonth == 12)){
						if(day >= pastday){
							return false;
						}
						else{
							return true;
						}
					}
					else if(pastmonth < 10){
						return false;
					}
					else{
						return true;
					}
				}
				else if((year - pastyear) > 1){
					return false;
				}
					 
			}
			else{
				return false;	
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
			return false;
		}
		return false;
	}		
}