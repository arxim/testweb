package com.scap.testweb.utils;

import java.util.Random;

public class Utils {
	public static int generateSignUpCode(){
		int signUpCode = 0;
		Random rand = new Random();
		signUpCode = rand.nextInt(1000000000);
		return signUpCode;
		
	}
}
