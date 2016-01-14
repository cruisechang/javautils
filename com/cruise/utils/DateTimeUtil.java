package com.cruise.utils;

//import java.io.*;
import java.util.*;
//import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.lang.Exception;

import com.cruise.finals.*;

public class DateTimeUtil {
	public static final int HOUR_MILLI_SECOND = 3600000; 
	public static final int DAY_MILLI_SECOND = 86400000; // millisec
	public static final int DAY_SECOND = 864000; 		// 
	public static final int HORU_SECOND = 3600; 		// 
	
	public static final String DateStringByDash = "yyyy-MM-dd HH:mm:ss"; // 憭批�神銝��
																			// http://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	public static final String DateStringBySlash = "yyyy/MM/dd HH:mm:ss";
	public static final String DateStringShort = "yyyyMMdd HH:mm:ss";

	/******************************************************************************
	 * @return The number of milliseconds since January 1, 1970, 00:00:00 GMT
	 *         represented by this Date object.
	 */
	public static long getTime() {
														//三個數字相同
		//return new Date().getTime();					//gmt 
		return System.currentTimeMillis();				//utc
		//Calendar calendar = Calendar.getInstance();
        //return  calendar.getTimeInMillis();			//the current time as UTC milliseconds from the epoch.
	}

	/******************************************************************************
	 * java.util.Date to java.sql.Date.
	 */
	public static java.sql.Date dateToSqlDate(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	/******************************************************************************
	 * java.sql.Date to java.util.Date.
	 */
	public static java.util.Date sqlDateToDate(java.sql.Date sqlDate) {
		java.util.Date d = new java.util.Date();
		d.setTime(sqlDate.getTime());
		return d;
	}

	/******************************************************************************
	 * get java.sql.Date
	 */
	public static java.sql.Date getSqlDate() {
		java.util.Date dd = new java.util.Date();
		return new java.sql.Date(dd.getTime());
	}

	public static java.sql.Date getSqlDate(long time) {
		return new java.sql.Date(time);
	}

	/******************************************************************************
	 * get java.util.Date to java.sql.Date format String
	 */
	public static String dateToSqlFormatDatetimeString(java.util.Date d) {
		// java.util.Date --> java.lang.String
		// java.util.Date now = new java.util.Date();
		// System.out.println(new java.text.SimpleDateFormat().format(now));
		// System.out.println(new
		// java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now));
		java.sql.Date sd = new java.sql.Date(d.getTime());
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sd);
	}

	/******************************************************************************
	 * get java.util.Date to java.sql.Date format String now
	 */
	public static String getSqlFormatDatetimeString() {
		java.util.Date dd = new java.util.Date();
		java.sql.Date sd = new java.sql.Date(dd.getTime());
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sd);
	}

	/******************************************************************************
	 * get java.util.Date to java.sql.Date format long
	 * sql
	 * Date
	 */
	public static long getSqlFormatDatetimeLong() {
		Date d = new java.util.Date();
		java.sql.Date dd = new java.sql.Date(d.getTime());
		return dd.getTime();
	}

	public static int getSqlFormatDatetimeInt() {
		Date d = new java.util.Date();
		java.sql.Date dd = new java.sql.Date(d.getTime());
		return (int) dd.getTime();
	}

	public static int getSqlFormatDatetimeInSec() {
		Date d = new java.util.Date();
		java.sql.Date dd = new java.sql.Date(d.getTime());
		long dl = dd.getTime();
		return (int) (dl / 1000);
	}

	/******************************************************************************
	 * 頛詨Dash Date String to java.util.Date ,DateStringByDash="yyyy-MM-dd"
	 * ,DateStringBySlash="yyyy/MM/dd" ,DateStringShort="yyyyMMdd"
	 */
	public static Date dateStringToDate(String dateString, String DateStringType) {
		SimpleDateFormat formatter = new SimpleDateFormat(DateStringType);
		Date t = null;
		try {
			return formatter.parse(dateString);
		} catch (Exception e) {
			return t;
		}
	}

	/******************************************************************************
	 * 瘥��ate string , str1>str2 return 0 ,str1==str2 return 1, str1<str2
	 * return 1; exception return -1;
	 * 
	 * @param DateStringType
	 * @param dateStr1
	 * @param dateStr2
	 * @return
	 */
	public static int compare2DateString(String DateStringType,
			String dateStr1, String dateStr2) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(DateStringType);
			Date d1 = df.parse(dateStr1);
			Date d2 = df.parse(dateStr2);

			if (d1.after(d2)) {
				return 0;
			} else if (d1.equals(d2)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	/******************************************************************************
	 * <date , date1>date2 return 0 ,date1==date2 return 1, date1<date2
	 * return 1; exception return -1;
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare2Date(Date date1, Date date2) {
		try {
			if (date1.after(date2)) {
				return 0;
			} else if (date1.equals(date2)) {
				return 1;
			} else {
				return 2;
			}
		} catch (Exception e) {
			return -1;
		}
	}

	/******************************************************************************
	 * 
	 * @param compareDate
	 * @param dateBegin
	 * @param dateEnd
	 * @param isIncludeBeginEnd
	 *            begin and end
	 * @return
	 */
	public static boolean isDateBetweenDateBeginDateEnd(Date compareDate,
			Date dateBegin, Date dateEnd, boolean isIncludeBeginEnd) {
		try {
			if (isIncludeBeginEnd) {
				// > == dateBegin && < == dateEnd
				if (compareDate.after(dateBegin)
						|| compareDate.equals(dateBegin)) {
					if (compareDate.before(dateEnd)
							|| compareDate.equals(dateEnd)) {
						return true;
					}
				}
			} else {
				if (compareDate.after(dateBegin) && compareDate.before(dateEnd)) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 */
	public static void showDateTime() {
		System.out.println("showSerial = " + getDateBySerial());

		//
		System.out.println("20070517 ~ 20060731...�撌桀予�..."
				+ calcuPeriod("20070517", "20060901"));

		//
		System.out.println("20070517...20憭拙��..."
				+ calcuBeforebyStr("20070517", 20));

		//
		System.out.println("20070517...20憭拙��..."
				+ calcuAfterbyStr("20070517", 20));

		//
		System.out.println("...");
		System.out.println("1900..." + isBissextile("1900")); // false
		System.out.println("2000..." + isBissextile("2000")); // true
		System.out.println("2007..." + isBissextile("2007")); // false
	}

	/**
	 * time(milliSec)
	 * 
	 * @return
	 */
	public static long getTimeAfterDaysFromNow(int days) {
		java.util.Date d = new java.util.Date();

		return d.getTime() + (DAY_MILLI_SECOND * days); 
	}

	/**
	 * 取第一個達到指定時間的日期
	 * @param hour
	 * @return
	 */
	public static Date getNextDateByHour(int hour, int min, int sec) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, hour);
		today.set(Calendar.MINUTE, min);
		today.set(Calendar.SECOND, sec);
		return today.getTime();
	}

	/******************************************************************************
	 * java date
	 */
	public static Date getDateOnDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date today = new Date();

		String todayString = sdf.format(today);

		try {
			return sdf.parse(todayString);
		} catch (Exception e) {
			return null;
		}

	}

	/******************************************************************************
	 * yyyy/MM/dd
	 */
	public static String getDateStringBySlash() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date today = new Date();
		return String.valueOf(sdf.format(today));
	}

	/****************************************************************************
	 * yyyy-MM-dd
	 */
	public static String getDateStringByDash() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = new Date();
		return String.valueOf(sdf.format(today));
	}

	/****************************************************************************
	 * yyMMdd
	 */
	public static String getDateStringInShort() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		java.util.Date today = new Date();
		return String.valueOf(sdf.format(today));
	}
	/**
	 * yyyy-MMM-dd (java.util.Locale.US)
	 */ 
	private static String getDateBySerial() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd",
				java.util.Locale.US);
		java.util.Date today = new Date();
		return String.valueOf(sdf.format(today));
	}
	/**
	 * yyyyMMddThhmmss*
	 * @return
	 */
	public static String getDateTimeStrWithT() {
		Calendar now = Calendar.getInstance();
		long ndate = now.get(Calendar.YEAR) * 10000
				+ (now.get(Calendar.MONTH) + 1) * 100
				+ now.get(Calendar.DAY_OF_MONTH);
		long ntime = now.get(Calendar.HOUR_OF_DAY) * 10000
				+ now.get(Calendar.MINUTE) * 100 + now.get(Calendar.SECOND);
		return String.valueOf(ndate) + "T" + String.valueOf(ntime);
	}

	/**
	 * 指定的時間(某個小時，例如21:03:32 。21點，3分，32秒) 如果現在還沒到，那差距多久。
	 * 如果已經超過了，那就是明天，那差距多久
	 * @param targetHour
	 * @param targetMin
	 * @param targetSec
	 * @return
	 */
	public static long calcuPeriodToTargetTime(int targetHour,int targetMin,int targetSec)
	{
		long nowTime=DateTimeUtil.getTime();														//目前time millisec
		long ndTime=DateTimeUtil.getNextDateByHour(targetHour,targetMin,targetSec).getTime();		//本日預定時間
		
		//預期時間>現在時間，表示時間還沒到，就直接減
		if(ndTime>=nowTime){
			return (ndTime-nowTime);	//中間差額，就是需要delay時間  ,
			
			//預期時間<現在時間，表示已經超過，那就是明天了。	用DateTimeUtilC.DAY_MILLI_SECOND去減
		}else{
			return DateTimeUtil.DAY_MILLI_SECOND-(nowTime-ndTime);
		}
		
	}
	/**
	 * calculate milli seconds between two date
	 */ 
	private static long calcuPeriod(String dateStr1, String dateStr2) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ParsePosition pos1 = new ParsePosition(0);
		ParsePosition pos2 = new ParsePosition(0);
		java.util.Date date1 = sdf.parse(dateStr1, pos1);
		java.util.Date date2 = sdf.parse(dateStr2, pos2);
		long dateDiff = 0;
		if (date1.getTime() < date2.getTime()) {
			dateDiff = ((date2.getTime() / 1000 - date1.getTime() / 1000) / (24 * 60 * 60));
		} else {
			dateDiff = ((date1.getTime() / 1000 - date2.getTime() / 1000) / (24 * 60 * 60));
		}
		return dateDiff;
	}

	/**
	 * 取得指定天數前的日期
	 */ 
	private static String calcuBeforebyStr(String dateStr1, int bef) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ParsePosition pos1 = new ParsePosition(0);
		java.util.Date date1 = sdf.parse(dateStr1, pos1);
		java.util.Date date2 = new Date(
				(date1.getTime() / 1000 - (bef * 24 * 60 * 60)) * 1000);
		return String.valueOf(sdf.format(date2));
	}

	/**
	 * 取得指定天數後的日期
	 */ 
	private static String calcuAfterbyStr(String dateStr1, int aft) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ParsePosition pos1 = new ParsePosition(0);
		java.util.Date date1 = sdf.parse(dateStr1, pos1);
		java.util.Date date2 = new Date(
				(date1.getTime() / 1000 + (aft * 24 * 60 * 60)) * 1000);
		return String.valueOf(sdf.format(date2));
	}
	/**
	 * 
	 */ 
	public static long calcuMSPeriodHowManyHours(long oldMS,long newMS) {
		
		return (int)((newMS-oldMS)/DateTime.HOUR_MILLI_SECOND.getValue());		//轉成整數
	}
	/**
	 * 
	 * @param base_month mm
	 * @return
	 */
	public static String getFirstDate(String base_month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		ParsePosition pos1 = new ParsePosition(0);
		base_month = base_month + "01";
		java.util.Date FirstDate = sdf.parse(base_month, pos1);
		return String.valueOf(sdf.format(FirstDate));
	}
	/**
	 * 
	 * @param base_year yyyy
	 * @return
	 */
	public static boolean isBissextile(String base_year) {
		boolean checkIsBissextile = false;
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		// ParsePosition pos1 = new ParsePosition(0);
		String base_year_0228 = base_year + "0228";
		String base_year_0301 = base_year + "0301";
		if (calcuPeriod(base_year_0228, base_year_0301) == 2)
			checkIsBissextile = true;
		return checkIsBissextile;
	}
}
