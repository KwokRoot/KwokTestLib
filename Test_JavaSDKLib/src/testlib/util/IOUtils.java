package testlib.util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * JDK 实现 字符串 与 IO 流的转化。
 * @author Kwok
 */
public class IOUtils {
	
	/**
	 * 字节数组方式读流(读取多字节字符时会出现乱码，不推荐)
	 */
	public static String read0(InputStream is) throws Exception {
		return read0(is, Charset.defaultCharset().name());
	}
	
	/**
	 * 字节数组方式读流(读取多字节字符时会出现乱码，不推荐)
	 */
	public static String read0(InputStream is, String charsetName) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		byte[] bytes = new byte[1024];
		int len = 0;
		while ((len = is.read(bytes)) != -1) {
			sb.append(new String(bytes, 0, len, charsetName));
		}
		
		return sb.toString();
	}
	
	
	/**
	 * 缓冲区方式读流(推荐)
	 */
	public static String read(InputStream is) throws Exception {
		return read(is, Charset.defaultCharset().name());
	}
	
	/**
	 * 缓冲区方式读流(推荐)
	 */
	public static String read(InputStream is, String charsetName) throws Exception {
		
		InputStreamReader isr = new InputStreamReader(is, charsetName);
		BufferedReader br = new BufferedReader(isr);

		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + System.getProperty("line.separator"));
		}
		
		return sb.toString();
	}
	
	
	public OutputStream write(String str) throws IOException {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(str.getBytes());
		return baos;
		
	}
	
}
