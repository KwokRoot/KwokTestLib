package testlib;

import java.util.Random;

/**
 * 该练习是对 java.util.Random 类 随机产生字符的简单练习。
 * @author Kwok
 */
public class Test_Random {

	public static void main(String[] args) {
		
		System.out.println("********* 随机生成基本类型值 *********");
		Random random=new Random();
		System.out.println(random.nextBoolean());  // 随机产生一个 Boolean 类型值。
		System.out.println(random.nextInt(10));  // 随机产生一个 10 以内的整形数。
		System.out.println(random.nextInt());
		System.out.println(random.nextLong());
		System.out.println(random.nextFloat());
		
		
		System.out.println("********* 随机生成字节数组 *********");
		byte[] bytes=new byte[100];
		random.nextBytes(bytes);  // 随机产生一个给定大小的字节数组。
		System.out.println(new String(bytes));
		
		
		System.out.println("********* 随机生成字符串 *********");
		/**
		 * 随机生成字符串。
		 * 实际使用中可以去除不容易识别的字符类型（如0与O等），作为生成随机字符串的工具方法。
		 */
		Random r = new Random();
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";  // 去除不好识别的字母。
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 6; i++) {
			sb.append(s.charAt(r.nextInt(s.length())));
		}
		System.out.println(sb.toString()); 
		
	}
}
