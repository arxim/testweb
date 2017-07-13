package com.scap.testweb.service;


public class Test {
	public static void main(String[] args){
		ShowListReportService test=new ShowListReportService();
		boolean result=test.getListOnLeave();
		System.out.println(result);
	}
}
