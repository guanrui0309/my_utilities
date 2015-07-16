package com.cola.gentoken;

public class GenerateToken {

	//user set fileID
	private static String FILE_ID = "";
	//default fileID
	private static String DEFAULT_FILE_ID = "304F33B6C8293A5CC5795686A91DA6CF";
	private static long DEADLINE = 1234567;
	private static String Secert_Key = "hmerNomk1Zn21iqb=texefBectZneX9J2NvvkDBb";
	private static String Access_Key = "cE7rNomk1qH111Y9=texeHJcsy76S=QaJar6hZXJ";

	public static String genURL(String fileID, long deadLine) {
		if (!fileID.equals(null) && !(fileID == "")) {
			String url = "id=" + fileID + "&deadline="
					+ (System.currentTimeMillis() + deadLine);
			System.out.println(System.currentTimeMillis());
			System.out.println(url);
			return url;
		} else {
			System.out.println("fileID is null, return default fileID");
			return DEFAULT_FILE_ID;
		}
	}

	public static void main(String[] args) {

		String url = genURL(FILE_ID, DEADLINE);
		String encodedUrl = MyBase64.encodeBase64String(url);
		System.out.println(encodedUrl);
		String encodedSign = MyBase64.encodeBase64String(MyHmacSha1
				.HmacSHA1Encrypt(Secert_Key, encodedUrl));
		System.out.println(encodedSign);
		// generate token
		String token = Access_Key + ":" + encodedSign + ":" + encodedUrl;
		System.out.println(token);

	}
}
