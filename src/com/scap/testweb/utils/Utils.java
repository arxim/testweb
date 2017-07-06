package com.scap.testweb.utils;

import com.mifmif.common.regex.Generex;

public class Utils {
	public static int generateSignUpCode(){
		/*int signUpCode[];
		Random rand = new Random();
		for(int i=0;i<10;i++){
			signUpCode[i] = rand.nextInt(10);
		}
		return signUpCode[];*/
			String pattern = "([0-9]{10})";
			Generex gen = new Generex(pattern);//genpass
			String str =gen.random();
			int loginCode = Integer.parseInt(str);
			return loginCode;
	}
}
