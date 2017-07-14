package com.scap.testweb.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	public String findNameBoss(String nameUser){
		// compare Department between employee and boss
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> resultEmployee = requestDao.getDataUser(nameUser);
		String department = resultEmployee.get(0).get("DEPARTMENT");
		ArrayList<HashMap<String, String>> resultBoss = requestDao.gstDataBoss(department);
		String fNameBoss = resultBoss.get(0).get("FIRST_NAME");
		String lNameBoss = resultBoss.get(0).get("LAST_NAME");
		String nameBoss = fNameBoss +" "+ lNameBoss;
		return nameBoss;
	}
	
	public String findBossID(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String department = result.get(0).get("DEPARTMENT");
		ArrayList<HashMap<String, String>> resultBoss = requestDao.gstDataBoss(department);
		String bossID = resultBoss.get(0).get("ID");
		return bossID;
	}
	
	public String findLeaveType(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultLeaveType = result.get(0).get("LEAVE_TYPE");
		return resultLeaveType;
	}
	
	public String findStartDate(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultStartDate = result.get(0).get("START_DATE");
		return resultStartDate;
	}
	
	public String findEndDate(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultEndDate = result.get(0).get("END_DATE");
		return resultEndDate;
	}
	
	public String findDateDiff(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultDateDiff = result.get(0).get("NUM_LEAVE");
		return resultDateDiff;
	}
	
	public String findNote(String emailUser){
		RequestDao requestDao = new RequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataUser(emailUser);
		String resultNote = result.get(0).get("NOTE");
		return resultNote;
	}
	
	public void setDataRequest(String employee_id,String boss_id,String typeLeave,String startDate,String endDate,String dateDiff,String note){
		String date_s = "";
		String date_e = "";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy/MM/dd");
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
	
	public boolean setDataApprove(String status){
		RequestDao requestDao = new RequestDao();
		boolean result = requestDao.setApprove(status);
		return result;
	}
	

}
