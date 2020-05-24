package testlib.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

/**
 * 该方法是对 java.io.StringBufferInputStream 练习。  ！！！ 错误类，不可用 ！！！
 * 注：java.io.StringBufferInputStream 已过时。
 * 此类未能正确地将字符转换为字节。
 * 从 JDK 1.1 开始，从字符串创建流的首选方法是通过 StringReader 类进行创建。 
 * @author Kwok
 */
@SuppressWarnings("deprecation")
public class Test_StringBufferInputStream {

	public static void main(String[] args) throws IOException {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		String str="NiHao!你好！";
		
		InputStream sbis = new StringBufferInputStream(str);
		// java.io.StringBufferInputStream 已过时。 此类未能正确地将字符转换为字节。从 JDK 1.1 开始，从字符串创建流的首选方法是通过 StringReader 类进行创建。 
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int i;
		while ((i = sbis.read()) != -1) {
			baos.write(i);
			System.out.print(i+",");
		}
		
		System.out.println("\n" + baos.toString());
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		System.out.println("正确的字节流：（只有字符串中每个字符的低八位可以由此类使用。）");
		byte[] b = str.getBytes();
		baos.reset();
		ByteArrayInputStream bais = new ByteArrayInputStream(b);
		while ((i = bais.read()) != -1) {
			baos.write(i);
			System.out.print(i + ",");
		}
		System.out.println("\n"+baos.toString());
	}
}
