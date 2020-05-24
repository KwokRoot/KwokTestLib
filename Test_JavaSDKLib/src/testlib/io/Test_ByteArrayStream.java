package testlib.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 该练习是对 字节数组流 的练习。
 * 了解更多请参考： java.io.ByteArrayInputStream 与 java.io.ByteArrayOutputStream 类。
 * @author Kwok
 */
public class Test_ByteArrayStream {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		// 定义一个字符串变量，转为字节数组
		// 该步骤可逆：new String(byte[] bytes);
		String str = "Hello World. 你好！";
		byte[] b = str.getBytes();

		// 定义一个字节数组输入流，一个字节数组输出流。
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		// i 为：bais.read() 返回 0 到 255 范围内的 int 字节值，如果到达流的末尾，则返回 -1。
		int i;
		while ((i = bais.read()) != -1) {
			baos.write(i);
			System.out.print(i + ",");
		}
		System.out.println();
		System.out.println(baos.toString());

		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		/*
		 * 该方式每次读取 给定字节 大小的字节流，由于汉字的字节数大于255，也许被切开存放，不推荐使用。 
		 * 读取汉字时用 Reader 与 Writer 相关的 字符流 类读取。
		 */
		String str2 = "Hello World. 你好！";
		byte[] b2 = str2.getBytes();
		ByteArrayInputStream bais2 = new ByteArrayInputStream(b2);
		ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
		byte[] temp = new byte[6];
		try {
			// j 值可得：bais2.read(byte[] b)每次返回值为读取的字节数。
			int j;
			while ((j = bais2.read(temp)) != -1) {
				System.out.print(new String(temp));
				System.out.print("---该次读取的字节数: " + j + "---  ");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (baos2 != null)
					baos2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("\n------------------------------ 操作 3 ------------------------------");
		
		System.out.println("\n****************");
		// 已关闭的流，没有数据。
		System.out.println(baos2.toString());
		System.out.println("****************");
	}

}
