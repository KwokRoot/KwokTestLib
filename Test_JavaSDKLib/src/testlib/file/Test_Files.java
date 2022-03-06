package testlib.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Date;
import java.util.EnumSet;

/**
 * Java 1.7+ 增加：
 * 
 * java.nio.file.Files
 * java.nio.file.Path 类，增强对文件的操作。
 * 
 * @author Kwok
 * 2022-03-06
 */
public class Test_Files {

	public static void main(String[] args) throws Exception {
		
		System.out.println("********* 操作1:获取文件信息 *********");
		
		File file = new File("D:\\Kwok\\Temp");
		File[] fs1 = file.listFiles();	
		for (File f : fs1) {
			// java.io.File 只能获取文件长度、最后修改时间
			System.out.println(f.getName() + " 文件大小：" + f.length());
			System.out.println(f.getName() + " 最后修改时间：" + new Date(f.lastModified()));
			
			// java.nio.file.Files 能获取到文件更多属性信息
			Path path = f.toPath();
			BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
			System.out.println(f.getName() + " 最后修改时间：" + new Date(attributes.lastModifiedTime().toMillis()));
			System.out.println(f.getName() + " 最后创建时间：" + new Date(attributes.creationTime().toMillis()));
			System.out.println(f.getName() + " 最后访问时间：" + new Date(attributes.lastAccessTime().toMillis()));
			System.out.println(f.getName() + " 文件大小：" + attributes.size());
		}
		
		
		
		System.out.println("********* 操作2:遍历目录 *********");
		
		System.out.println("--- 操作2-1 ---");
		Files.list(file.toPath()).forEach(x -> {
			System.out.println(x);
		});
		
		
		System.out.println("--- 操作2-2 ---");
		Files.walk(file.toPath(), 3).forEach(x -> {
			if(x.toFile().isFile()) {
				System.out.println(x.getFileName());
			}
		});
		
		
		System.out.println("--- 操作2-3 ---");
		Files.walkFileTree(file.toPath(), EnumSet.noneOf(FileVisitOption.class), Integer.MAX_VALUE, new SimpleFileVisitor<Path>(){
			// 遇到文件访问权限等错误继续，默认是异常抛异常停止。
			@Override
			public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println(file.toString());
				return FileVisitResult.CONTINUE;
			}
		});
		
		
		
		System.out.println("********* 操作3:按行读写文件 *********");
		
		Path path = Paths.get(file.getPath(), "test.txt");
		Files.write(path, Arrays.asList("Java", "C", "Python", "333"), Charset.defaultCharset(), StandardOpenOption.CREATE);
		
		Files.readAllLines(path, Charset.defaultCharset()).forEach(x -> {
			System.out.println(x);
		});
		
	}
	
}
