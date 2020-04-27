package testlib;

import java.util.Map;

/**
 * 该练习是程序中获取系统属性的练习。
 * @author Kwok
 */
public class Test_SystemProperty {

	public static void main(String[] args) {
		
		//系统属性：JAVA 安装目录
		System.out.println(System.getProperty("java.home", "N/A"));
		
		//获取不到系统属性值时，可以设置默认值
		System.out.println(System.getProperty("java.home1", "N/A"));
		
		//系统属性：用户目录
		System.out.println(System.getProperty("user.home", "N/A"));
		
		//系统属性：当前工作目录
		System.out.println(System.getProperty("user.dir", "N/A"));
		
		//系统属性：文件分隔符
		System.out.println(System.getProperty("file.separator", "\\"));
		
		//系统属性：路径分隔符
		System.out.println(System.getProperty("path.separator", ";"));
		
		//系统属性：换行符
		System.out.println(System.getProperty("line.separator", "\n"));
		
		System.out.println("\n------ SystemEnv ------\n");
		
		//系统变量
		Map<String, String> sysEnv = System.getenv();
		sysEnv.forEach((k, v) -> System.out.println(k + ":" + v));
		
	}
	
}
