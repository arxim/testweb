package com.scap.testweb.service;


import java.text.DateFormat; 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;

import com.scap.testweb.utils.DbConnector;

public class AlertService {
	public static void main(String[] args) {
		AlertService service = new AlertService();
		
		String email = "yui@gmail.com";
		
/*	//	UPDATE Date in database
		String sql = "INSERT INTO ALERT (UPDATE) VALUES getdate() WHERE EMAIL='" + email + "'"; ;
		DbConnector dbconn = new DbConnector();
		dbconn.doConnect();
		
	//	database	
		dbconn.doDisconnect();	*/
		
	
	//	String upDate = "20170520";
	//	System.out.println("Update : " + upDate);
		
		try{
			
			Date dNow = new Date();
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			System.out.println("Update : " + df.format(dNow));

			Calendar c = Calendar.getInstance();
					
		
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH) + 1;
			int day = c.get(Calendar.DATE);
		
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
	
	}
	
	public boolean calculate(String email, int year, int month, int day){
	//	SELECT Date from database	
		ArrayList<HashMap<String, String>> dPast = getDate(email);
		
	//	String dPast = "20170326";
		
		
		try{
			System.out.println("  Date : " + dPast);
			DateFormat df = new SimpleDateFormat("yyyyMMdd");
			System.out.println("Update : " + df.format(dPast));
			
			Calendar c = Calendar.getInstance();
			
		
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
			else
				return false;		
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
		return false;
	
	}

	private ArrayList<HashMap<String, String>> getDate(String email) {
		String sql = "SELECT CREATE_DATE FROM LEAVE_MST_SIGNUP_PEAR WHERE EMAIL='" + email + "'"; ;
		DbConnector dbconn = new DbConnector();
		ArrayList<HashMap<String, String>> dPast = null;
		try{
			dbconn.doConnect();
			
			dPast = dbconn.getData(sql);
			return dPast;
		
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			}
		return dPast;
	}		
		
}
