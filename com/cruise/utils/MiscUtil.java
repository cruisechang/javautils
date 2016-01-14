package com.cruise.utils;


public class MiscUtil {

	public static void logByDebugFlag(boolean flag,Object obj)
	{
		 if(flag) System.out.println(String.valueOf(obj));
		
	}
	
	public static void log(Object obj)
	{
		  System.out.println(String.valueOf(obj));
	}

}
