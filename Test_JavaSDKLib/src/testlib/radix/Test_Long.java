package testlib.radix;

import java.math.BigInteger;

/**
 * 正数 Long 类型(8 Byte 即 64 bit)数值强制转为 Integer 类型(4 Byte 即 32 bit)可能会为负值。
 * @author Kwok
 * 2022-08-07
 */
public class Test_Long {

	public static void main(String[] args) {
		
		//Long#intValue() 方法，注：正数的结果可能是负值！例：
		System.out.println(Long.valueOf(1636163797000L).intValue());
		//结果：-218742776
		
		//解析：1.时间戳 1636163797000 二进制位
		System.out.println(String.format("%64s", new BigInteger("1636163797000").toString(2)));
		//System.out.println(String.format("%64s", Long.toBinaryString(1636163797000L)));
		//结果：1 0111 1100 1111 0010 1111 0110 0100 0000 0000 1000
		
		//解析：2.转化时只保留后32位(即 Integer 长度 4个 Byte)
		System.out.println(new BigInteger("11110010111101100100000000001000", 2).intValue());
		//结果：-218742776
		
		//验证：3.由于保留32位，需要无符号位转化。
		System.out.println(String.format("%64s", Integer.toUnsignedString(-218742776, 2)));
		//结果：11110010111101100100000000001000
		
		//！！！注：该方式产生的随机数可能为负值！
		for (int i = 0; i < 6; i++) {
			int randmon = Long.valueOf(System.currentTimeMillis()).intValue() % 5;
			System.out.println(randmon);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
