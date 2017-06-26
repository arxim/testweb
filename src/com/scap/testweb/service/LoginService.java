package com.scap.testweb.service;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.scap.testweb.utils.DbConnector;

public class LoginService {
	private static Scanner i;
	public String chkLogin(String email,String pwd){
		LoginService service = new LoginService();
		String s="";
		String md5=service.getMD5(pwd);
		String data = "select EMAIL,PASSWORD from LEAVE_MST_SIGNUP_TOPMYZA where EMAIL = '"+email+"' and PASSWORD = '"+md5+"'";
		DbConnector dbconn = new DbConnector();
		try{
			dbconn.getConnection();
			if(dbconn.getData(data).size()==1){
				s="Login Success!!!";
			}
			else{
				s="E-mail or Password wrong!!";
			}
		}
		catch (Exception e) {
			System.out.println(e); 
		}
		return s;
	}
	 public String getMD5(String input) {
        byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = temp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	public static void main(String [] args){
		LoginService service = new LoginService();
		i = new Scanner(System.in);
        System.out.print("Email : ");
        String email = i.nextLine();
        System.out.print("Password : ");
        String password = i.nextLine();
		String result=service.chkLogin(email,password);
		if(result=="Login Success!!!"){
			System.out.println(result);
		}
		else{
			System.out.println(result);
		}
	}

}
