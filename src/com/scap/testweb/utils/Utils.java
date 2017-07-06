package com.scap.testweb.utils;

import com.mifmif.common.regex.Generex;

public class Utils {
	public static long generateSignUpCode(){
			String pattern = "([0-9]{10})";
			Generex gen = new Generex(pattern);
			String str =gen.random();
			long loginCode = Long.parseLong(str);
			return loginCode;
	}
}
