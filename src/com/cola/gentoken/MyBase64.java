package com.cola.gentoken;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;

public class MyBase64 {
	
	/**
	 * ���ַ�������base64����
	 * 
	 * @param strToBase64 - Ҫ����base64���ַ���
	 * @return ���й�base64������ַ���
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
	 * ���ֽ��������base64����
	 * 
	 * @param strToBase64 - Ҫ����base64���ֽ�����
	 * @return ���й�base64������ַ���
	 */
	public static String encodeBase64String(byte[] strToBase64){
		String base64String = Base64.encodeBase64String(strToBase64);
		return base64String;
	}

	/**
	 * ���Ѿ���base64��������ַ�������decode
	 * 
	 * @param base64String Ҫ���ܵ�base64���ַ���
	 * @return δ����base64���ַ���
	 * @throws UnsupportedEncodingException 
	 */
	public static String decodeBase64String(String base64String) throws UnsupportedEncodingException {
		byte[] binaryData = Base64.decodeBase64(base64String);
		String orignalString = new String(binaryData);
		return orignalString;
	}
}
