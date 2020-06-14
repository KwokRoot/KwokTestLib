package testlib;

import testlib.util.IOUtils;

/**
 * 该练习是通过代码获取 DOS 中 cmd 命令返回的数据的练习。 
 * @author Kwok
 */
public class Test_RunCmd {

	public static void main(String[] args) throws Exception {
		
		System.out.println("------------------------------ 操作 1:输入流 ------------------------------");
		
		Process process = Runtime.getRuntime().exec("cmd /c " + "ipconfig/all");
		System.out.println(IOUtils.read(process.getInputStream(), "GBK"));
		
		
		System.out.println("------------------------------ 操作 2:错误流 ------------------------------");
		
		Process process2 = Runtime.getRuntime().exec("cmd /c " + "java -help");
		System.out.println(IOUtils.read(process2.getErrorStream(), "GBK"));
		
	}

}
