package com.tour.commons.utils;

import java.security.MessageDigest;

/**
 * MD5 加密算法
 * @author chenrh
 * @date 2015-5-8
 */
public class MD5Util {
	
	/**
	 * MD5加密
	 * @param inStr
	 * @return
	 */
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = (md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * KL
	 * @author chenrh
	 *
	 * @param inStr
	 * @return
	 */
	public static String KL(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] + 16);
		}
		String s = new String(a);
		return s;
	}

	/**
	 * JM
	 * @author chenrh
	 *
	 * @param inStr
	 * @return
	 */
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] - 16);
		}
		String k = new String(a);
		return k;
	}

	// test
	public static void main(String args[]) {
		String s = new String("12345678");
		System.out.println("原字符串" + s);
		System.out.println("MD5加密" + MD5(s));
		System.out.println("KL" + KL(MD5(s)));
		System.out.println("JM" + JM(KL(MD5(s))));
	}
}
