package testlib;

import java.math.BigInteger;

/**
 * 该练习是对 BigInteger 类的简单练习。详情请参考 "java.math.BigInteger" API相关文档。
 * @author Kwok
 */
public class Test_BigInteger1 {

	public static void main(String[] args) {

		BigInteger a1=new BigInteger("123456789987654321001234567899876543210");
		System.out.println(a1);
		//输出：123456789987654321001234567899876543210

		BigInteger a2=new BigInteger("14");
		System.out.println(Integer.toBinaryString(14));
		//输出：1110
		
		System.out.println(a2.testBit(0)); // 第 0 位未被设置(即为 0);
		//输出：false
		
		System.out.println(a2.testBit(3)); // 第 1 , 2 , 3 位被设置(即为 1);
		//输出：true
		
	}
}
