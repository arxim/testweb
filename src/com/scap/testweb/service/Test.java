package com.scap.testweb.service;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
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
	public static void main(String[] args){
		String test1="2017/07/14";
		String s1=changeformatDateToDB(test1);
		System.out.println(test1+" = "+s1);
		String test2="20170714";
		String s2=changeformatDateToShow(test2);
		System.out.println(test2+" = "+s2);
	}
}
