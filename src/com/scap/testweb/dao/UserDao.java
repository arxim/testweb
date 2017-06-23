package com.scap.testweb.dao;
public class UserDao {
	public String getEmail(String mail){
		String sql = "select email form userAccount where email = mail";
		
		return sql;
	}
}
