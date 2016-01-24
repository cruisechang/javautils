package com.cruise.utils;
//import org.apache.commons.codec.binary.*;
//import java.util.Base64;	//jre 1.8
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

//import android.annotation.SuppressLint;

/** 
 * @auther cruisechang
 * @description
 * AES加密/解密算法/工作模式/填充方式  
 * JAVA6 支持PKCS5PADDING填充方式 
 * Bouncy castle支持PKCS7Padding填充方式
 * iOS需要PKCS7adding填充方是 
 * */ 
public class AESUtil {
    public static final String KEY_ALGORITHM="AES";  
    public static final String CIPHER_ALGORITHM="AES/ECB/PKCS7Padding";
    
 
	public static byte[] getKey() throws Exception{  
        
      KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);  
//    AES長128位、192位、256位  
//    kg.init(256); 		//if use 256bits ,have  to install Java Cryptography Extension (JCE) Unlimited Strength. 
      kg.init(128); 			 	  
      SecretKey secretKey=kg.generateKey();  
      return secretKey.getEncoded();  

    }
    public static byte[] getRandomKey(byte[] seed) throws Exception{  
  
      KeyGenerator kg=KeyGenerator.getInstance(KEY_ALGORITHM);  
      SecureRandom sr=SecureRandom.getInstance("SHA1PRNG");				//random
      sr.setSeed(seed);
      kg.init(128,sr); 			 	  
      SecretKey secretKey=kg.generateKey();  
      return secretKey.getEncoded();  
    }

    /** 
     * byte[] key to java.security.Key
     * @param key byte[] key 
     * @return Key java.security.Key 
     * */ 
    public static Key byteArrayKeyToSecurityKey(byte[] key) throws Exception
    {  
 
        return new SecretKeySpec(key,KEY_ALGORITHM);  
          
    }
    public static Key byteArrayKeyToSecurityKeyUsingLength(byte[] key) throws Exception
    {
    	return new SecretKeySpec(key, 0, key.length, "AES"); 
    }


    /** 
     * Encrypt 
     * @param data source data,to be encrypted
     * @param key byte[] key
     * @return byte[] data after encrypted 
     * */ 
    public static byte[] encrypt(byte[] data,byte[] key) throws Exception{  
  
        Key k=byteArrayKeyToSecurityKey(key);  
        /** 
         * 
         * 使用 PKCS7PADDING 填充方式
         * Cipher.getInstance(CIPHER_ALGORITHM,"BC") 
         */ 
        Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);  
        //init encrypt mode  
        cipher.init(Cipher.ENCRYPT_MODE, k);  
        return cipher.doFinal(data);  
    }
    
    
    /** 
     * decrypt 
     * @param data prepare to be decrypted 
     * @param key byteArray[] key
     * @return byte[] original data 
     * */ 
    public static byte[] decrypt(byte[] data,byte[] key) throws Exception{  

        Key k =byteArrayKeyToSecurityKey(key);  

        Cipher cipher=Cipher.getInstance(CIPHER_ALGORITHM);  
        //init, decrypt mode
        cipher.init(Cipher.DECRYPT_MODE, k);  
        //exec 
        return cipher.doFinal(data);  
    } 
}
