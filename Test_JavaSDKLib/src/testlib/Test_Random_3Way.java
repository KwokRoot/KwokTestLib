package testlib;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 该练习是 Java 生成随机数的 3种 方式的练习。
 * @author Kwok
 */
public class Test_Random_3Way {

	public static void main(String[] args) {

		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		//返回带正号的 double 值，取值范围：[0.0, 1.0)。
		System.out.println((int) (Math.random() * 100));
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		//返回 int 值，取值范围：[0, n)。
		Random random = new Random();
		System.out.println(random.nextInt(100));
		
		System.out.println("------------------------------ 操作 3 ------------------------------");

		//返回 int 值，取值范围：[0, n)。优点：单一实例，静态访问，高并发。
		System.out.println(ThreadLocalRandom.current().nextInt(100));
		
	}
}
