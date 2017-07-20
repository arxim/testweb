package com.scap.testweb.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.scap.testweb.dao.EditRequestDao;
import com.scap.testweb.dao.RequestDao;

public class RequestService {
	public String findID(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultID = result.get(0).get("ID");
		return resultID;
	}
	
	public String findFirstName(String nameUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(nameUser);
		String resultName = result.get(0).get("FIRST_NAME");
		return resultName;
	}
	
	public String findLastName(String nameUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(nameUser);
		String resultName = result.get(0).get("LAST_NAME");
		return resultName;
	}
	
	public String findDepartment(String nameUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(nameUser);
		String resultDepartment = result.get(0).get("DEPARTMENT");
		return resultDepartment;
	}
	
	public String findPosition(String nameUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(nameUser);
		String resultPosition = result.get(0).get("POSITION");
		return resultPosition;
	}
	
	public String findNameBoss(){
		String bossID = findBossID();
		long id = Long.parseLong(bossID);
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getBossID(id);
		String fNameBoss = result.get(0).get("FIRST_NAME");
		String lNameBoss = result.get(0).get("LAST_NAME");
		String nameBoss = fNameBoss +" "+ lNameBoss;
		return nameBoss;
	}
	
	public String findEmailBoss(){
	    String bossID = findBossID();
	    long id = Long.parseLong(bossID);
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getBossID(id);
		String emailBoss = result.get(0).get("EMAIL");
		return emailBoss;
	}
	
	public String findBossID(){
		String position = "หัวหน้าพนักงาน";
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getBossPosition(position);
		String bossID = result.get(0).get("ID");
		return bossID;
	}
	
	public void setDataRequest(String employee_id,String boss_id,String typeLeave,String startDate,String endDate,String dateDiff,String note){
		String date_s = "";
		String date_e = "";
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
		try{
			Date sd = dt.parse(startDate);
			Date ed = dt.parse(endDate);
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
			date_s = dt1.format(sd);
			date_e = dt1.format(ed);
		}
		catch (Exception exp) {
		    exp.printStackTrace();
		}
		String status = "รออนุมัติ";
		RequestDao requestDao = new RequestDao();
		requestDao.setRequestOnLeave(employee_id, boss_id, typeLeave, date_s, date_e,dateDiff,note,status);
	}
	
	public void setEditDataRequest(String leave_code,String typeLeave,String startDate,String endDate,String dateDiff,String note){
		String date_s = "";
		String date_e = "";
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
		try{
			Date sd = dt.parse(startDate);
			Date ed = dt.parse(endDate);
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyyMMdd");
			date_s = dt1.format(sd);
			date_e = dt1.format(ed);
		}
		catch (Exception exp) {
		    exp.printStackTrace();
		}
		EditRequestDao requestDao = new EditRequestDao();
		requestDao.setEditRequestOnLeave(leave_code, typeLeave, date_s, date_e,dateDiff,note);
	}
}
