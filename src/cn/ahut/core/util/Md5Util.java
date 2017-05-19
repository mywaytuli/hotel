package cn.ahut.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * MD5加密工具类
 * @author Dell
 *
 */
public class Md5Util {

	public static String md5(String message) {

		try {
			MessageDigest md = MessageDigest.getInstance("md5");

			byte md5[] = md.digest(message.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(md5);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
	}
}
