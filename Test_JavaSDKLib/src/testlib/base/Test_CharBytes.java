package testlib.base;

import java.io.UnsupportedEncodingException;

/**
 * 该练习是比较 英文 、 数字 、 汉字类型的字符 所占字节数的练习。
 * UTF-8 编码下，英文 、 数字类型的字符占 1个 字节，汉字类型的字符占 3个 字节。
 * GBK 编码下，英文 、 数字类型的字符占 1个 字节，汉字类型的字符占 2个 字节。
 * @author Kwok
 */
public class Test_CharBytes {

	public static void main(String[] args) {
		
		String str1="你好￥";
		String str2="Aa0_.+~$%";
		String str3="你好￥Aa0_.+~$%";
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		System.out.println(str1.length()); // 3
		System.out.println(str2.length()); // 9
		System.out.println(str3.length()); // 12
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		System.out.println("------ 操作 2-1 ------");
		System.out.println(str1.getBytes().length); // 9
		System.out.println(str2.getBytes().length); // 9
		System.out.println(str3.getBytes().length); // 18
		
		
		System.out.println("------ 操作 2-2 ------");
		try {
			String str="你";
			System.out.println("UTF-8："+str.getBytes("UTF-8").length); // 3
			System.out.println("GBK："+str.getBytes("GBK").length); // 2
			//System.out.println("GB2312："+str.getBytes("GB2312").length); // 2
			//System.out.println("ISO-8859-1："+str.getBytes("ISO-8859-1").length); // 1
			//System.out.println("Unicode："+str.getBytes("Unicode").length); // 4
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		System.out.println("------ 操作 3-1 ------");
		for(int i=0;i<str1.length();i++){
			String s1=String.valueOf(str1.charAt(i));
			System.out.println(s1+":"+s1.getBytes().length);
		}
		
		
		System.out.println("------ 操作 3-2 ------");
		for(int i=0;i<str2.length();i++){
			String s2=String.valueOf(str2.charAt(i));
			System.out.println(s2+":"+s2.getBytes().length);
		}
		
		
		System.out.println("------ 操作 3-3 ------");
		for(int i=0;i<str3.length();i++){
			String s3=String.valueOf(str3.charAt(i));
			System.out.println(s3+":"+s3.getBytes().length);
		}
		
		/* 结果：
		 * ------ 操作 3-3 ------
			你:3
			好:3
			￥:3
			A:1
			a:1
			0:1
			_:1
			.:1
			+:1
			~:1
			$:1
			%:1
		 */
	}

}
