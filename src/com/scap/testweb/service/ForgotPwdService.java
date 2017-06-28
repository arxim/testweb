package com.scap.testweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;

import com.mifmif.common.regex.Generex;
import com.scap.testweb.dao.ForgotPwdDao;

public class ForgotPwdService {// Find Email in DB for genpassword
	public boolean chkEmailForgot(String email){
		ForgotPwdDao chkEmailDBservice = new ForgotPwdDao();
		ArrayList<HashMap<String,String>> chk = chkEmailDBservice.checkEmailDB(email);
		int sizeOfData = chk.size();
		if(sizeOfData == 1){
			return true;
		}
		else{
			return false;
		}
	}
	public String genPassword(int minRange,int maxRange){ // gen new password
		SignUpService suService = new SignUpService();
		String pattern = "([a-zA-Z0-9@S#$%^&+=]{"+minRange+","+maxRange+"})"; //pattern for genpass
		Generex gen=new Generex(pattern);//genpass
		String str=gen.random();
		try{
			if(!suService.chackPassword(str)){//is genpassword incorrect pattern
				genPassword(6,8);	// gen password repeat 
			}	
		}catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
}
