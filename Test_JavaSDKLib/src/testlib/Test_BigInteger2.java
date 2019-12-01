package testlib;

import java.math.BigInteger;

/**
 * 该练习是对 java.math.BigInteger 补充练习。详情请参考 "java.math.BigInteger" API相关文档。
 * 拓展：
 * 原码、反码、补码：
 * 原码：正数首位为0；负数首位为1。
 * 反码：正数反码与原码相同；负数反码是原码符号位不变其他位取反。
 * 补码：正数补码与原码相同；负数补码是原码符号位不变其他位取反加1(即：反码+1)。
 * @author Kwok
 */
public class Test_BigInteger2 {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		BigInteger bigInteger=new BigInteger("0");
		bigInteger=bigInteger.setBit(2);  // 设置此 BigInteger 指定位为1，并返回设置后的 BigInteger 值。
		bigInteger=bigInteger.setBit(1);
		bigInteger=bigInteger.setBit(0);
		System.out.println(bigInteger); // 111   1 * 2*2 + 1 * 2*1 + 1*1 = 7
		//输出：7
		
		bigInteger=bigInteger.flipBit(1);  // 101   返回对此 BigInteger 指定位进行取反后的 BigInteger 的值。
		System.out.println(bigInteger);
		//输出：5
		
		System.out.println(bigInteger.negate());  // 返回该值的相反数。
		//输出：-5
		System.out.println(bigInteger.not());  // 0101 → 1010   返回该值按位取反的数。
		//输出：-6
		System.out.println(Integer.toBinaryString(Integer.valueOf("-6")));
		//输出：11111111111111111111111111111010
		
		System.out.println("------------------------------ 操作 2 ------------------------------");

		BigInteger bigInteger2=new BigInteger("0");
		bigInteger2=bigInteger2.setBit(1);  // 10
		
		// 两种效果一样
		System.out.println(bigInteger2.shiftLeft(2));  // 1000
		//输出：8
		System.out.println(bigInteger2.intValue() << 2);
		//输出：8
		
		System.out.println(bigInteger2.shiftRight(1)); // 1
		//输出：1
		System.out.println(bigInteger2.intValue() >> 1);
		//输出：1
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		BigInteger bigInteger3=new BigInteger(Integer.valueOf("1100", 2).toString());
		bigInteger3=bigInteger3.setBit(1);  // 该值变为 1110
		bigInteger3=bigInteger3.clearBit(2);// 该值变为 1010
		System.out.println(Integer.toBinaryString(bigInteger3.intValue()));
		//输出：1010
		System.out.println(bigInteger3.testBit(3));  // 当且仅当设置了指定的位时(即该位的值为 1 时)，返回 true。
		//输出：true
		System.out.println(bigInteger3.testBit(0));
		//输出：false
		
	}
}
