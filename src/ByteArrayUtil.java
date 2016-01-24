
package com.cruise.utils;

/**
 * @author cruisechang
 * @description
 * Byte utils.
 */
public class ByteArrayUtil {

	final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	/**
	 * byte array to hex string
	 * 和hexStringToByteArray配合使用
	 */
	public static String bytesArrayToHexString(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	public static String bytesArrayToHexStringUnsign(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}	
	/**
	 * hex string to byte array
	 * hex string 兩個一組，轉成一個byte
	 * 因為當byte array 轉hex時，
	 * 和bytesArrayToHexString配合使用
	 * @param hexStr
	 * @return
	 */
	public static byte[] hexStringToByteArray(String hexStr)
	{
		int i,len=hexStr.length();
		//是否為2的倍數，byte array轉成hex string 一定是2的倍數
		if((len & 1) != 0){
			return null;
		}
		byte[] ba=new byte[len/2];
		for(i=0;i<len;i+=2){
			
			ba[i/2]=(byte) (Integer.parseInt(hexStr.substring(i,i+2),16) & 0xff);
		}
		return ba;
	}
	
	/**
	 * hex string to byte array
	 * @param s
	 * @return
	 */
	public static byte[] hexStringToByteArray2(String s) {
	    int len = s.length();
	  //是否為2的倍數，byte array轉成hex string 一定是2的倍數
		if((len & 1) != 0){
			return null;
		}
		
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	       // data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)+ Character.digit(s.charAt(i+1), 16) & 0xff);
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)+ Character.digit(s.charAt(i+1), 16) );
	    }
	    return data;
	}
	

}
