package com.cola.gentoken;

import org.apache.commons.codec.digest.HmacUtils;

public class MyHmacSha1 {
	
	/**
	 * Returns a HmacSHA1 Message Authentication Code (MAC) as hex string (lowercase) for the given key and value.
	 * 
	 * @param key - key for the keyed digest (must not be null)
	 * @param valueToDigest - The value (data) which should to digest (maybe empty or null)
	 * @return HmacSHA1 MAC for the given key and value as hex string (lowercase)
	 */
	public static byte[] HmacSHA1Encrypt(String key, String valueToDigest){
		byte[] b = HmacUtils.hmacSha1(key, valueToDigest);
		return b;
	}
}
