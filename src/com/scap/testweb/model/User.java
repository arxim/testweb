package com.scap.testweb.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	private String userNo;
	private String userId;
	private String code;
	private String firstname;
	private String lastname;
	private String firstandlastname;
	private String department;
	private String position;
	private String email;
	private String leaveType;
	private String status;
	
	private String requestDate;
	private String approveDate;
	
	private String startDate;
	private String endDate;
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstAndLastname() {
		return firstandlastname;
	}
	public void setFirstAndLastname(String firstname,String lastname) {
		this.firstandlastname = firstname+"  "+lastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		String dbDate = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dfDate =new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date date = df.parse(requestDate);
			dbDate = dfDate.format(date);
			this.requestDate = dbDate;
		}
		catch(ParseException e){
			e.printStackTrace();
			this.requestDate = requestDate;
		}
	}
	public String getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(String approveDate) {
		if(approveDate != null){
			String dbDate = "";
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat dfDate =new SimpleDateFormat("dd/MM/yyyy");
			try{
				Date date = df.parse(approveDate);
				dbDate = dfDate.format(date);
				this.approveDate = dbDate;
			}
			catch(ParseException e){
				e.printStackTrace();
				this.approveDate = approveDate;
			}
		}
		else{
			this.approveDate = approveDate;
		}
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndtDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
