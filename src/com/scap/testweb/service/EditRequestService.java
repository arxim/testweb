package com.scap.testweb.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.scap.testweb.dao.EditRequestDao;
import com.scap.testweb.dao.RequestDao;

public class EditRequestService {
	
	public String findFristNameUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultName = resultUser.get(0).get("FIRST_NAME");
		return resultName;
	}
	
	public String findLastNameUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultName = resultUser.get(0).get("LAST_NAME");
		return resultName;
	}

	public String findDepartmentUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultDepartment = resultUser.get(0).get("DEPARTMENT");
		return resultDepartment;
	}

	public String findPositionUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultPosition = resultUser.get(0).get("POSITION");
		return resultPosition;
	}

	public String findEmailUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("EMPLOYEE_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultEmail = resultUser.get(0).get("EMAIL");
		return resultEmail;
	}

	public String findNameBossUser(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultID = result.get(0).get("BOSS_ID");
		ArrayList<HashMap<String, String>> resultUser = requestDao.getDataUserId(resultID);
		String resultBossFirstName = resultUser.get(0).get("FIRST_NAME");
		String resultBossLastName = resultUser.get(0).get("LAST_NAME");
		String nameBoss = resultBossFirstName + " " + resultBossLastName;
		return nameBoss;
	}
	
	public String findLeaveType(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultLeaveType = result.get(0).get("LEAVE_TYPE");
		return resultLeaveType;
	}
	
	public String findStartDate(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultStartDate = result.get(0).get("START_DATE");
		
		String date_s = "";
		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
		try{
			Date sd = dt.parse(resultStartDate);
			SimpleDateFormat dt1 = new SimpleDateFormat("dd MMM yyyy");
			date_s = dt1.format(sd);
		}
		catch (Exception exp) {
		    exp.printStackTrace();
		}
		return date_s;
	}
	
	public String findEndDate(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultEndDate = result.get(0).get("END_DATE");
		
		String date_e = "";
		SimpleDateFormat dt = new SimpleDateFormat("yyyyMMdd");
		try{
			Date sd = dt.parse(resultEndDate);
			SimpleDateFormat dt1 = new SimpleDateFormat("dd MMM yyyy");
			date_e = dt1.format(sd);
		}
		catch (Exception exp) {
		    exp.printStackTrace();
		}
		return date_e;
	}
	
	public String findDateDiff(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultDateDiff = result.get(0).get("NUM_LEAVE");
		return resultDateDiff;
	}
	
	public String findNote(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultNote = result.get(0).get("NOTE");
		return resultNote;
	}
	
	public String findStatus(String codeLeave){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		ArrayList<HashMap<String, String>> result = requestDao.getDataLeave(code);
		String resultPosition = result.get(0).get("STATUS");
		return resultPosition;
	}
	
	public boolean setDataApprove(String codeLeave, String status){
		long code = Long.parseLong(codeLeave);
		EditRequestDao requestDao = new EditRequestDao();
		boolean result = requestDao.setApprove(code, status);
		return result;
	}
	
}
