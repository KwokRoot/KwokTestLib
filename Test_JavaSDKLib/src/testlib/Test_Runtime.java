package testlib;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * java.lang.Runtime
 * @author Kwok
 */
public class Test_Runtime {

	public static void main(String[] args) {
		
		/*获取 JVM 信息*/
		System.out.println("CPU 核心数：" + Runtime.getRuntime().availableProcessors());
		System.out.println("JVM 最大堆内存：" + Runtime.getRuntime().maxMemory()/1024/1024/1024 + "GB");
		System.out.println("JVM 占用堆内存：" + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())/1024 + "KB");
		
		
		/*执行命令*/
		try {
			Process process = Runtime.getRuntime().exec("ping baidu.com");
			process.waitFor(10, TimeUnit.SECONDS);
			InputStream is = process.getInputStream();
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			System.out.println(new String(bytes, "GBK"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*执行带参数的命令*/
		try {
			Process process = Runtime.getRuntime().exec(new String[]{"D:\\Program Files\\Mozilla Firefox\\firefox.exe", "https://www.baidu.com"});
			System.out.println("程序执行返回值：" + process.waitFor());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
