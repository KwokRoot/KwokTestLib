package testlib;

import java.math.BigInteger;

/**
 * 该练习是 位逻辑运算 的练习。
 * @author Kwok
 */
public class Test_BigInteger3 {

	public static void main(String[] args) {
		
		//+8 10进制
		BigInteger bi1 = new BigInteger("8", 10);
		
		//-8 10进制
		BigInteger bi2 = new BigInteger("-8", 10);
		
		//+8 2进制
		System.out.println("--------- +8 的 2进制表示 ---------");
		System.out.println(turnTo32BitString(Integer.toBinaryString(bi1.intValue())));
		//输出：00000000000000000000000000001000
		
		
		//-8 2进制
		System.out.println("--------- -8 的 2进制表示 ---------");
		System.out.println(Integer.toBinaryString(bi2.intValue()));
		//输出：11111111111111111111111111111000
		
		
		//按位取反运算
		System.out.println("--------- -8 的 2进制按位取反 ---------");
		System.out.println(turnTo32BitString(Integer.toBinaryString(bi2.not().intValue())));
		//输出：00000000000000000000000000000111
		System.out.println(bi2.not().intValue());
		//输出：7
		
		
		// +8 与 -8 按位或运算，即 -8
		System.out.println("--------- +8 与 -8 2进制按位 或运算 ---------");
		System.out.println(Integer.toBinaryString(bi1.or(bi2).intValue()));
		//输出：11111111111111111111111111111000
		System.out.println(bi1.or(bi2).intValue());
		//输出：-8
		
		
		// +8 与 -8 按位与运算，即 8
		System.out.println("--------- +8 与 -8 2进制按位 与运算 ---------");
		System.out.println(turnTo32BitString(Integer.toBinaryString(bi1.and(bi2).intValue())));
		//输出：00000000000000000000000000001000
		System.out.println(bi1.and(bi2).intValue());
		//输出：8
		
		
		// +8 与 -8 按位异或运算，即 -16
		System.out.println("--------- +8 与 -8 2进制按位 异或运算 ---------");
		System.out.println(Integer.toBinaryString(bi1.xor(bi2).intValue()));
		//输出：11111111111111111111111111110000
		System.out.println(bi1.xor(bi2).intValue());
		//输出：-16
		
	}
	
	
	/*
	 * 前补"0"，转为32位字符串
	 */
	public static String turnTo32BitString(String str){
		StringBuffer sb = new StringBuffer(str);
		while (sb.length() < 32) {
			sb.insert(0, '0');
		}
		return sb.toString();
	}
}
