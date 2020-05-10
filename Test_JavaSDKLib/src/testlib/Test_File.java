package testlib;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * 该练习是对 java.io.File 的练习。
 * @author Kwok
 */
public class Test_File {

	public static void main(String[] args) {

		/* 
		 * 练习1：
		 * File.createNewFile() 创建文件时，当父路径不存在时会抛异常。 
		 */

		File file = new File("d://java/1/2/3/helloword.txt");
		System.out.println("文件是否存在：" + file.exists());

		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			System.err.println("父路径不存在时不能创建");

			/* 父路径不存在时，先创建父路径，再创建文件 */
			/*
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			try {
				System.out.println(file.createNewFile());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			*/
			
		}
		
		
		/*
		 * 练习2：
		 * 当 new File(String pathname) 中 pathname 为 ""，File 只是路径名。 
		 * 注：If the given string is the empty string, then the result is the empty abstract pathname.
		 * 对比 File 实例 file2_1 与 file2_2 不同。
		 */
		File file2_1 = new File("");
		System.out.println(file2_1.getAbsolutePath());
		System.out.println(Arrays.toString(file2_1.list()));
		System.out.println(file2_1.exists());
		/*
		 * 结果：
		 * F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib
		 * null
		 * false
		 */
		
		
		File file2_2 = new File(new File("").getAbsolutePath());
		System.out.println(file2_2.getAbsolutePath());
		System.out.println(Arrays.toString(file2_2.list()));
		System.out.println(file2_2.exists());
		/*
		 * 结果：
		 * F:\Kwok\GitHub\KwokTestLib\Test_JavaSDKLib
		 * [.classpath, .gitignore, .project, .settings, bin, image, ReadMe.md, src]
		 * true
		 */
		
		
		/*
		 * 练习3：文件路径分隔符(pathSeparator)
		 * On UNIX systems, this character is ':'; on Microsoft Windows systems it is ';'.
		 */
		System.out.println(File.pathSeparator);
		System.out.println(File.pathSeparatorChar);
		System.out.println(System.getProperty("path.separator"));
		
		
		/*
		 * 练习4：文件名分隔符(separator)
		 * On UNIX systems, this character is ':'; on Microsoft Windows systems it is ';'.
		 */
		System.out.println(File.separator);
		System.out.println(File.separatorChar);
		System.out.println(System.getProperty("file.separator"));
		
		
		/*
		 * 练习5： 遍历所有驱动器根目录
		 */
		System.out.println(Arrays.toString(File.listRoots()));
		/*
		 * 结果(Window)：
		 * [C:\, D:\, E:\, F:\, G:\] 
		 */
		
		
		/*
		 * 练习6： 遍历目录
		 */
		File file6 = new File("src/testlib");
		File[] fileArray = file6.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File f) {
				if(f.isFile() && f.getName().endsWith(".java")) {
					return true;
				}else {
					return false;
				}
			}
			
		});
		Arrays.asList(fileArray).forEach(System.out::println);
		
	}
	
}
