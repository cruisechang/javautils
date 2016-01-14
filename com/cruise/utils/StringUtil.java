package com.cruise.utils;

import java.lang.StringBuilder;

public class StringUtil
{

	/**
	 * base string  compare string
	 */
	public static int compareStrNum(String baseStr,String  compareStr)
	{
		int res=0;
		int len=baseStr.length();
		for(int i=0;i<len;i++){
			char c=baseStr.charAt(i);
			if(String.valueOf(c).equals(compareStr)){
				res+=1;
			}
		}
		return res;
	}
	public static String removeLastString(String baseStr,String patternStr)
	{
		int index=baseStr.lastIndexOf(patternStr);
		if(index==-1) return baseStr;
		
		return baseStr.substring(0, index);
	}
	/**
	 * 
	 */
	public static boolean isDigitalString(String targetStr)
	{
		 char[] str2 = targetStr.toCharArray();
		 int len=targetStr.length();
		 for(int i=0; i < len; i++) {
		 	if(!Character.isDigit(str2[i])) {
		 		return false;
		 	}
		 }
		 return true;   
	}
	/**
	 * 
	 * @param targetStr
	 * @return
	 */
	public static boolean isEmpty(String targetStr)
	{
		if("".equals(targetStr)){
			return true;
		}
		/*
		if(targetStr!=null && targetStr.equals("")){
			return true;
		}
		*/
		return false;
  
	}
	public static String getRandomNumStringBeginWithOne(int length)
	{
		int i=0;
		String s="1";
		length=length-1;
		for(i=0;i<length;i++){
			s=s+String.valueOf(MathUtil.random(0,9));
		}
		return s;
	}
	public static String getRandomNumString(int length)
	{
		int i=0;
		String s="";
		for(i=0;i<length;i++){
			s=s+String.valueOf(MathUtil.random(0,9));
		}
		return s;
	}
	
	public static String getRandomCharString(int length,boolean upperCase)
	{
		char[] ary={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		int i=0,aryLen=ary.length-1;
		String s="";
		for(i=0;i<length;i++){
			s=s+String.valueOf(ary[MathUtil.random(0,aryLen)]);
		}
		return (upperCase) ? s.toUpperCase() : s;
	}
	public static String replaceCharAt(String oriStr,int replaceIndex,char c)
	{
		StringBuilder newStr = new StringBuilder(oriStr);
		newStr.setCharAt(replaceIndex, c);
		return newStr.toString();

	}
}
