package org.kwok.hll;

import net.agkn.hll.HLL;
import net.agkn.hll.util.NumberUtil;

/**
 * HyperLogLog算法：不精确的去重统计。
 * @author Kwok
 */
public class Test_HyperLogLog {

	public static void main(String[] args) {

		final HLL hll = new HLL(13, 5);
		
		hll.addRaw("1231".hashCode());
		hll.addRaw("1231".hashCode());
		hll.addRaw("1232".hashCode());
		hll.addRaw("1232".hashCode());
		hll.addRaw("1232".hashCode());
		hll.addRaw("1233".hashCode());
		hll.addRaw("1233".hashCode());
		hll.addRaw("1235".hashCode());
		hll.addRaw("1236".hashCode());

		//获取去重数
		System.out.println(hll.cardinality());
		
		//序列化 HLL 对象
		byte[] bytes = hll.toBytes();
		String output = NumberUtil.toHex(bytes, 0, bytes.length);
		System.out.println(output);
		
		//反序列化 HLL 对象
		final HLL hll2 = HLL.fromBytes(NumberUtil.fromHex(output, 0, output.length()));
		hll2.addRaw("123".hashCode());
		System.out.println(hll2.cardinality());
		
		//合并 HLL 对象
		hll.union(hll2);
		System.out.println(hll.cardinality());
		
	}

}
