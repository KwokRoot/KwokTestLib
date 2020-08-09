package testlib;

import java.util.BitSet;

/**
 * JDK BitSet
 * 由于 java.util.BitSet 方法中都是 int 类型的参数，所以最大的排重结果是 `Integer.MAX_VALUE`，即：2147483647(21亿)
 * 
 * @author Kwok
 */
public class Test_BitSet {

	public static void main(String[] args) {
		
		System.out.println(Integer.MAX_VALUE);
		BitSet bitSet = new BitSet(Double.valueOf(Math.pow(10, 9)).intValue());
		bitSet.set(123456788);
		bitSet.set(1234567891);
		System.out.println("length:" + bitSet.length());
		System.out.println("size:" + bitSet.size());
		System.out.println("cardinality:" + bitSet.cardinality());
		
		//BitSet 最大占用空间
		System.out.println(bitSet);
		System.out.println(2147483647/8/1024/1024 + "MB");
		
		
		BitSet bitSet1 = new BitSet(8);
		bitSet1.set(3);
		bitSet1.set(1);
		bitSet1.set(6);
		
		BitSet bitSet2 = new BitSet(8);
		bitSet2.set(2);
		bitSet2.set(3);
		bitSet2.set(4);
		
		System.out.println(bitSet1);
		System.out.println(bitSet2);
		
		//bitSet1 和 bitSet2 按位或运算
		bitSet1.or(bitSet2);
		
		//bitSet1 和 bitSet2 按位并运算
		//bitSet1.and(bitSet2);
		
		//bitSet1 和 bitSet2 按位异或运算
		//bitSet1.xor(bitSet2);
		
		System.out.println(bitSet1);
		System.out.println(bitSet1.cardinality());
		
		
		/*
		 * 拓展：
		 * java.util.BitSet.cardinality() 方法中使用到计算二进制数值值为 1 的个数。
		 * Long.bitCount(long i) 及 Integer.bitCount(int i) 方法都提供 二进制数值中值为 1 的个数。
		 */
		System.out.println(Long.bitCount(Long.valueOf("11011110", 2)));
		
	}
}
