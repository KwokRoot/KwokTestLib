package testlib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 该练习是加载 Properties 文件 几种路径写法的练习。
 * test.properties 路径在 项目/src/config/test.properties , 编译时自动复制到 bin/config/test.properties 。
 * test.properties 文件内容 ： name=kwok
 * @author Kwok
 */
public class Test_LoadPath2 {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		Properties prop=new Properties();
		
		/*  加载 properties文件 路径 "src/config/test.properties" ,该路径为项目路径下的相对路径  */
		//System.out.println(new File("").getAbsolutePath());  // 实际使用中要使用绝对路径，由于根目录不确定！！！
		//prop.load(new FileInputStream("src/config/test.properties"));  // 实际使用中要使用绝对路径，由于根目录不确定(如:导出 jar 包后根路径改变，也不存在 src 及 bin 目录等)！！！
		
		
		/*  加载 properties文件 路径 "bin/config/test.properties" ,该路径为  类路径  下的 相对路径  */
		//System.out.println(Test_PropertiesLoad.class.getResource(""));  // 当前类所在路径。
		//System.out.println(Test_PropertiesLoad.class.getResource("/"));  // Java 项目下的 bin/ 目录。
		
		/*  类路径加载的方式：  方式一  */
		//prop.load(Test_PropertiesLoad.class.getResourceAsStream("/config/test.properties"));
		
		/*  类路径加载的方式：  方式二  */
		//prop.load(new Test_PropertiesLoad().getClass().getResourceAsStream("/config/test.properties"));
		
		/*  类路径加载的方式：  方式三 */
		//prop.load(Class.forName("testlib.Test_PropertiesLoad").getResourceAsStream("/config/test.properties"));

		/*  类路径加载的方式：  方式四 */
		//prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config/test.properties"));
		
		/*  用系统类加载器获取 项目的 bin 目录 加载资源文件 */
		//System.out.println(ClassLoader.getSystemResource(""));  // 基本路径： Java 项目下的 bin/ 目录。
		prop.load(ClassLoader.getSystemResourceAsStream("config/test.properties"));
		
		System.out.println(prop.getProperty("name"));
	}
}