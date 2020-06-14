package testlib;

import java.io.File;

/**
 * 该练习是对 加载项目下的资源路径 的练习。
 * 注：
 * 1、Class.getResource() 加载的资源 默认是在当前类所在路径下。 是在 Java 项目下的 bin/.. 目录下,或者 Web 项目下的 build/classes/.. 目录下，而不是 src 目录下的资源。
 * 2、Class.getResource() 不支持使用 "../../../" 转到多级父目录。
 * 3、Thread.currentThread().getContextClassLoader().getResource("") 加载资源在 Java 项目下的 bin/ 目录,或者 Web 项目下的 build/classes/ 目录。
 * 4、Thread.currentThread().getContextClassLoader().getResource("") 不支持使用 "../../../" 转到多级父目录。
 * 5、new File() 加载的资源 默认是在 项目根目录下加载。！！！实际使用中要使用绝对路径，由于根目录不确定(如:导出 jar 包后根路径改变，也不存在 src 及 bin 目录等)！！！
 * 6、new File() 加载资源支持使用 "../../../" 转到多级父目录。
 * @author Kwok
 */
public class Test_LoadPath1 {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		System.out.println(Test_LoadPath1.class.getResource(""));  // 默认为当前类所在路径下，即 项目/bin/testlib 目录下。
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/testlib/
		
		System.out.println(Test_LoadPath1.class.getResource("test.properties"));  // 加载不到资源，默认为当前类所在路径,即 bin/testlib 目录下。
		// 结果： null
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		System.out.println(Test_LoadPath1.class.getResource("/"));  // Java 项目下的 bin/ 目录, Web 项目下的 build/classes/ 目录。
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/      // 注：该测试项目为 Java 项目。
		
		System.out.println(Test_LoadPath1.class.getResource("/test.properties"));
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/test.properties      // 注： bin/ 目录下也有 test.properties 文件。
		
		
		/*
		 * ！！！注：
		 * 在 Class.getResource() 中：
		 * "../" 与 "/" 等效。直接进到项目下的 bin/ 目录, Web 项目下的 build/classes/ 目录下！！！ 
		 * "./" 与 "." 与 "" 等效。仍为当前目录 ！！！ 
		 * Class.getResource() 不能使用 "../../../" 转到多级父目录,否则返回为空。
		 */
		
		System.out.println(Test_LoadPath1.class.getResource("../test.properties"));  // 可以加载到资源，从当前项目下的 bin/ 目录, Web 项目下的 build/classes/ 目录下加载资源。
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/test.properties
		
		
		System.out.println(Test_LoadPath1.class.getResource("../../src/"));  // "../../../" 错误写法。
		// 结果： null
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");

		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));  // 默认为 Java 项目下的 bin/ 目录, Web 项目下的 build/classes/ 目录。
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/
		
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("./"));  // 与 "" 效果相同，能访问到 Java 项目下的 bin/ 目录, Web 项目下的 build/classes/ 目录。
		// 结果： file:/F:/Kwok/GitHub/KwokTestLib/Test_JavaSDKLib/bin/
		
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("/"));  // 不能只加 "/" 。
		// 结果： null
		
		System.out.println(Thread.currentThread().getContextClassLoader().getResource("../src"));  // 不能 用相对路径访问到上一级目录下(项目根路径)的 src 目录。
		// 结果： null
		
		System.out.println("------------------------------ 操作 4 ------------------------------");
		
		
		File file = new File("");  // 默认为项目根目录下。
		System.out.println(file.getAbsolutePath());
		// 结果：F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib
		
		File file1 = new File("src");  // 可以从项目根路径下加载 src 目录。
		System.out.println(file1.getAbsolutePath());  // 结果： F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib\src
		System.out.println(file1.exists());  // 结果： true 。
		
		File file2 = new File("bin");  // 可以从项目根路径下加载 bin 目录。
		System.out.println(file2.getAbsolutePath());  // 结果：F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib\bin
		System.out.println(file2.exists());  // 结果： true 。
		
		File file3 = new File("../../../GitHub");  
		System.out.println(file3.getAbsolutePath());  // 结果： F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib\..\..\..\GitHub 。
		System.out.println(file3.exists());  // 结果： true 。说明： new File() 加载资源支持使用 "../../../" 转到多级父目录。
		
		File file4 = new File("../../workspace");  
		System.out.println(file4.getAbsolutePath());  // 结果： D:\Users\Kwok\workspace\Test\..\..\workspace 。
		System.out.println(file4.exists());  // 结果： false 。
		
		
		System.out.println("------------------------------ 操作 5 ------------------------------");
		
		// 该方式与操作 3 相同。推荐使用 操作 3。
		System.out.println(Test_LoadPath1.class.getClassLoader().getResource("test.properties"));
		
		// 与操作 3 相同的原因：
		System.out.println(Test_LoadPath1.class.getClassLoader());
		System.out.println(Thread.currentThread().getContextClassLoader());
		
	}
}