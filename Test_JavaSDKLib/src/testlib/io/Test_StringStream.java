package testlib.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 该练习是 字节流 与 字符流 的相互转化的练习。
 * 主要用的类：
 * java.io.InputStreamReader 、 java.io.OutputStreamWriter 。 
 * java.io.ByteArrayInputStream 、java.io.ByteArrayOutputStream 。
 * java.io.BufferedReader 、 java.io.BufferedWriter 。
 * @author Kwok
 */
public class Test_StringStream {

	public static void main(String[] args) throws IOException {

		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		String str = "Hello World. 你好！";
		
		// 字符串转化为字节流，用 java.io.ByteArrayInputStream 类。
		InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
		
		// 将字节流转化为字符流，用 java.io.InputStreamReader 类。
		InputStreamReader isr = new InputStreamReader(is);
		
		// 将字节流转化为字符串，用 java.io.ByteArrayOutputStream 类。
		OutputStream os=new ByteArrayOutputStream();
		
		// 将字符流转化为字节流，用 java.io.OutputStreamWriter 类。
		OutputStreamWriter osw=new OutputStreamWriter(os);
		
		int i;
		while ((i = isr.read()) != -1) {
			osw.write(i);
		}
		osw.flush();  // 注：该步骤不可少，否则不会输出！！！
		System.out.println(os.toString());
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		InputStream is2 = new ByteArrayInputStream(str.getBytes("UTF-8"));
		InputStreamReader isr2 = new InputStreamReader(is2);
		OutputStream os2 = new ByteArrayOutputStream();
		OutputStreamWriter osw2 = new OutputStreamWriter(os2);
		
		// 将字符流读入字符缓冲区内，用 java.io.BufferedReader 类。
		BufferedReader br2=new BufferedReader(isr2);
		// 将字符流写入字符缓冲区内，用 java.io.BufferedWriter 类。
		BufferedWriter bw2=new BufferedWriter(osw2);
		
		String temp;
		while((temp=br2.readLine())!=null){
			bw2.write(temp);
		}
		bw2.flush();  // 注：该步骤不可少，否则不会输出！！！
		System.out.println(os2.toString());
		
	}
}
