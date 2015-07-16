package com.cola.gentoken;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public class MyBase64 {
	
	/**
	 * 对字符串进行base64处理
	 * 
	 * @param strToBase64 - 要进行base64的字符串
	 * @return 进行过base64处理的字符串
	 */
	public static String encodeBase64String(String strToBase64){
		if(!strToBase64.equals(null) && !(strToBase64 == "")){
			byte[] binaryData;
			binaryData = strToBase64.getBytes();
			String base64String = Base64.encodeBase64String(binaryData);
			return base64String;
		}else{
			System.out.println("string is null");
			return null;
		}
		
	}
	
	/**
	 * 对字节数组进行base64处理
	 * 
	 * @param strToBase64 - 要进行base64的字节数组
	 * @return 进行过base64处理的字符串
	 */
	public static String encodeBase64String(byte[] strToBase64){
		String base64String = Base64.encodeBase64String(strToBase64);
		return base64String;
	}

	/**
	 * 对已经被base64处理过的字符串进行decode
	 * 
	 * @param base64String 要解密的base64的字符串
	 * @return 未进行base64的字符串
	 * @throws UnsupportedEncodingException 
	 */
	public static String decodeBase64String(String base64String) throws UnsupportedEncodingException {
		byte[] binaryData = Base64.decodeBase64(base64String);
		String orignalString = new String(binaryData);
		return orignalString;
	}
}
