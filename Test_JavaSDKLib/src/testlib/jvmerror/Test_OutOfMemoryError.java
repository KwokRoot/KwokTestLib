package testlib.jvmerror;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 模拟 JVM 堆溢出异常:java.lang.OutOfMemoryError: Java heap space。
 */
public class Test_OutOfMemoryError {

	public static void main(String[] args) {

		List<String> cache = new ArrayList<String>();

		byte[] bytes = new byte[8000000];
		long startTime = System.currentTimeMillis();
		for (int j = 0; j < bytes.length; j++) {
			bytes[j] = (byte) new Random().nextInt(127);
		}
		System.out.println("生产数据耗时：" + (System.currentTimeMillis() - startTime));
		
		long count = 0L;
		
		while (true) {
			String temp = new String(bytes);
			cache.add(temp);
			System.out.println(">>>" + ++count);
		}
	}

}
