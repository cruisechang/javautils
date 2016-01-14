package com.cruise.utils;

import java.util.Arrays;
/**
 * @author cruisechang
 * 二進位整數表示法
 * 1.無號數 unsigned
 * 2.有號數
 * (1) signed bit表示法
 * (2) 1's compliment(1的補數)  少用
 * (3) 2's compliment(2的補數)  大部分使用這個，包括java
 * 
 *
 */
public class BitUtil {

	/**
	 * Decimal to binary string.
	 * 2's compliment
	 * 2的補數表示法
	 * 2進位字串全部當成正數處理。
	 * Integer.parseInt("101",2)=5
	 * Integer.parseInt("-101",2)=-5
	 * @param n
	 * @return
	 */
	
	public static String decimalToBinaryString(int n) {
		return Integer.toBinaryString(n);
	}
	public static String decimalToBinaryString(long n) {
		return Long.toBinaryString(n);
	}

	public static int intBinaryStringToInt(String binaryStr)
	{
		//要用long 然後轉int。直接用int會錯
		return  (int)Long.parseLong(binaryStr, 2);
	}
	/**
	 * 如果是負數會錯。
	 * @param binaryStr
	 * @return
	 */
	public static long longBinaryStringToLong(String binaryStr)
	{
	
		return  Long.parseLong(binaryStr, 2);
	}	
	/**
	 * 左邊空缺位元補0
	 * @param str
	 * @param bitNumber 位元數32 for int, 64 for long
	 * @param filledChar 補入的字元 '0'ß=正數,'1'=負數
	 * @return
	 */
    public static String binaryStringSignExtend(String binaryStr,int bitNumber,char filledChar){
        //TODO add bounds checking
        int n=bitNumber-binaryStr.length();
        char[] sign_ext = new char[n];
        Arrays.fill(sign_ext, filledChar);

        return new String(sign_ext)+binaryStr;
    }
	
}
