package com.scap.testweb.service;

import com.scap.testweb.dao.LoginDao;

public class LoginService {
	public boolean chkLogin(String email,String pwd){
		SignUpService encodePwd = new SignUpService();
		String data = encodePwd.cryptWithMD5(pwd);
		LoginDao loginDao = new LoginDao();
		boolean result = loginDao.getEmailPassword(email, data);
		return result;
	}
}
