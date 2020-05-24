package testlib.io;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * 该练习是对字符流的练习。
 * 了解更多请参考： java.io.Reader 与  java.io.Writer 、 java.io.StringReader 、 java.io.StringWriter 、 java.io.FileWriter 等类
 * @author Kwok
 */
public class Test_ReaderWriter {

	public static void main(String[] args) throws IOException {
		
		
		String str = "Hello World. 你好！";
		
		Reader reader = new StringReader(str);
		
		Writer writer = new StringWriter();
		
		
		/*
		Writer writer=new FileWriter("D:/java/6.txt");  // 以字符流方式写入到文件。
		*/
		
		int i;
		
		try {
			while ((i = reader.read()) != -1) {
				writer.write(i);
				System.out.println(writer.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("------------------------------------------------------------");
		System.out.println(writer.toString());

	}

}
