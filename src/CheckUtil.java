package com.cruise.utils;

import java.util.*;

/**
 * @author cruisechang
 * @description
 * Check utils.
 */
public class CheckUtil
{
	public static final String DATA_TYPE_INT="int";
	public static final String DATA_TYPE_STRING="string";
	public static final String DATA_TYPE_BOOLEAN="bool";
	public static final String DATA_TYPE_DOUBLE="dou";
	public static final String DATA_TYPE_LONG="lon";

	private static boolean dataType(Object data,String type)
	{
		if(type.equals(DATA_TYPE_INT)){
			if(data instanceof Integer){
				return true;
			}
		}else if(type.equals(DATA_TYPE_STRING)){
			if(data instanceof String){
				return true;
			}
		}else if(type.equals(DATA_TYPE_BOOLEAN)){
			if(data instanceof Boolean){
				return true;
			}
		}else if(type.equals(DATA_TYPE_DOUBLE)){
			if(data instanceof Double){
				return true;
			}
		}else if(type.equals(DATA_TYPE_LONG)){
			if(data instanceof Long){
				return true;
			}
		}
		return false;
	}
	public static boolean checkLong(long lon,int min)
	{
		if(dataType(lon,DATA_TYPE_LONG)){
			if(lon>=min) return true;
		}
		return false;
	}
	public static boolean checkString(String str)
	{
		if(dataType(str,DATA_TYPE_STRING)){
			return true;
		}
		return false;
	}
	public static boolean checkString(String str,int lenMin)
	{
		if(dataType(str,DATA_TYPE_STRING)){
			if(str.length()>=lenMin) return true;
		}
		return false;
	}
	public static boolean checkBool(Object data)
	{
		return dataType(data,DATA_TYPE_BOOLEAN);
	}

	public static boolean checkInt(int num)
	{
		if(dataType(num,DATA_TYPE_INT)){
			return true;
		}
		return false;
	}
	/**
	 * check if param is int and if >=min && < =max
	 * @param num
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean checkInt(int num,int min,int max)
	{
		if(dataType(num,DATA_TYPE_INT)){
			if(num>=min && num<=max){
				return true;
			}
		}
		return false;
	}
	/** 
	 * @param num
	 * @param min
	 * @return
	 */
	public static boolean checkInt(int num,int min)
	{
		if(dataType(num,DATA_TYPE_INT)){
			if(num>=min){
				return true;
			}
		}
		return false;
	}
	public static boolean checkId(int id)
	{
		if(dataType(id,DATA_TYPE_INT)){
			if(id>=0){
				return true;
			}
		}
		return false;
	}
	public static boolean checkPlayerNum(int playerNum)
	{
		if(dataType(playerNum,DATA_TYPE_INT)){
			if(playerNum>0 && playerNum<7){
				return true;
			}
		}
		return false;
	}
	public static boolean checkLatLng(double lat,double lng)
	{
		if(dataType(lat,DATA_TYPE_DOUBLE)){
			if(lat>=0 && lat<=90 ){
				return true;
			}
		}
		return false;
	}
	public static String getRandomKey(int length)
	{
		String s="";
		 List <String> aList=getStringArrayList();
		 int size=aList.size();
		 
		 //����摨衣��葡
		 for(int i=0;i<length;i++){
			 String r=aList.get(MathUtil.random(0, size-1));
			 s+=r;
		 }
		 return s;
	}
	private static List<String> getStringArrayList()
	{
		 List<String> list = new ArrayList<String>();
		 list.add("~"); 
		 list.add("!"); 
		 list.add("@"); 
		 list.add("$"); 
		 list.add("^"); 
		 list.add("&"); 
		 list.add("*"); 
		 list.add("("); 
		 list.add(")"); 
		 list.add("_"); 
		 list.add("+"); 
		 list.add("a"); 
		 list.add("b"); 
		 list.add("c"); 
		 list.add("d"); 
		 list.add("e"); 
		 list.add("f"); 
		 list.add("g"); 
		 list.add("h"); 
		 list.add("i"); 
		 list.add("j"); 
		 list.add("k"); 
		 list.add("l"); 
		 list.add("m"); 
		 list.add("n"); 
		 list.add("o"); 
		 list.add("p"); 
		 list.add("q"); 
		 list.add("r");
		 list.add("s"); 
		 list.add("t"); 
		 list.add("u"); 
		 list.add("v"); 
		 list.add("w"); 
		 list.add("x"); 
		 list.add("y"); 
		 list.add("z"); 
	     return list;   
	}
	public static boolean checkTimeEnough(long allTime,long nowTime)
	{
		long ex=nowTime-allTime;
//			30sec 
		if(ex>=-30000){
			return true;
		}
		return false;
	}
}
