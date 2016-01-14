package com.cruise.utils;

import java.security.MessageDigest;

public class SecurityUtil {

	public static String getMD5Hash(String str,boolean upperCase)
	{
		String md5Hash="";
		try{
		
		MessageDigest md5=MessageDigest.getInstance("MD5");
		
		//string to bytearray
		byte[] strbyteAry=md5.digest(str.getBytes());				
		
		//將 byte 陣列轉成 16 進制
		int len=strbyteAry.length;
		StringBuffer sb=new StringBuffer();  
		for (int i=0; i < len; i++) {
	    	  sb.append(byte2Hex(strbyteAry[i]));
	      }
	      	String hex=sb.toString();
	      	md5Hash=(upperCase) ? hex.toUpperCase() : hex.toLowerCase(); 	//upper or lower
	      
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return md5Hash;
	}
	
	  public static String byte2Hex(byte b) 
	  {
		  String[] h={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
		  int i=b;
		  if (i < 0) {
			  i += 256;
		  }
		  return h[i/16] + h[i%16];
	  }
}
