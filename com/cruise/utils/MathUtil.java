package com.cruise.utils;

public class MathUtil
{
	/**
	 * random min 2 max
	 * including max
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min,int max)
	{
		return (int)(Math.random() * (max-min+1)) + min;
	}
	/**
	 * 
	 * @param f
	 * @param b
	 * @param decimalPlace
	 * @return
	 */
	public static float divisionToDecimalPlace(float f,float b,int decimalPlace)
	{
		float r=f/b;
		if(decimalPlace==0){
			return (float)(Math.round(r));
		}else if(decimalPlace==1){
			return (float)((Math.round(r*10f))/10f);
		}else if(decimalPlace==2){
			return (float)((Math.round(r*100f))/100f);
		}else if(decimalPlace==3){
			return (float)((Math.round(r*1000f))/1000f);
		}else if(decimalPlace==4){
			return (float)((Math.round(r*10000f))/10000f);
		}else if(decimalPlace==5){
			return (float)((Math.round(r*100000f))/100000f);
		}else if(decimalPlace==6){
			return (float)((Math.round(r*1000000f))/1000000f);
		}else if(decimalPlace==7){
			return (float)((Math.round(r*10000000f))/10000000f);
		}else{
			return (float)((Math.round(r*100000000f))/100000000f);
		}
	}
	/**
	 * @param f
	 * @param b
	 * @param decimalPlace
	 * @return
	 */
	public static float NumberToDecimalPlace(float r,int decimalPlace)
	{
		if(decimalPlace==0){
			return (float)Math.round(r);
		}else if(decimalPlace==1){
			return (float)(Math.round(r*10))/10;
		}else if(decimalPlace==2){
			return (float)(Math.round(r*100))/100;
		}else if(decimalPlace==3){
			return (float)(Math.round(r*1000))/1000;
		}else{
			return (float)(Math.round(r*10000))/10000;
		}
	}
	/**
	 * 
	 * @param r
	 * @param decimalPlace
	 * @return
	 */
	public static float NumberToDecimalPlace(double r,int decimalPlace)
	{
		if(decimalPlace==0){
			return (float)Math.round(r);
		}else if(decimalPlace==1){
			return (float)(Math.round(r*10))/10;
		}else if(decimalPlace==2){
			return (float)(Math.round(r*100))/100;
		}else if(decimalPlace==3){
			return (float)(Math.round(r*1000))/1000;
		}else{
			return (float)(Math.round(r*10000))/10000;
		}
	}

	/**
	 * @param Molecular	
	 * @param Denominator
	 * @return
	 */
	public static boolean probability(int Molecular,int Denominator)
	{
		int ran=random(1,Denominator);
		if(ran<=Molecular)	return true;
		return false;
	}
}