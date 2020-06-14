package testlib.security;

import java.security.MessageDigest;

/**
 * JDK 消息摘要算法-MD5
 * @author Kwok
 */
public class Test_JDK_MD5 {

	public static void main(String[] args) {
		String str = "Hello World.";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(str.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			System.out.println(sb.toString());
		} catch (java.security.NoSuchAlgorithmException e) {
			System.err.println(e.getMessage());
		}
	}

}
