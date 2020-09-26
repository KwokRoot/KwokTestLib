package org.apache.commons.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.stream.Stream;

/**
 * 模拟日志回滚文件生成
 */
public class Test_RollbackFile {

	public static void main(String[] args) throws IOException {
		
		File file = new File("F://opt/1.log");
		
		new Thread(()->{
			for (int i = 0; i < 300; i++) {
				writeRollbackFile(file, "hello1-" + i + "\n");
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 300; i++) {
				writeRollbackFile(file, "hello2-" + i + "\n");
			}
		}).start();
		new Thread(()->{
			for (int i = 0; i < 300; i++) {
				writeRollbackFile(file, "hello3-" + i + "\n");
			}
		}).start();
		
			
	}
	
	public static synchronized void writeRollbackFile(File file, String str) {

		long len = 100L;

		OutputStream os = null;
		try {
			if (file.length() > len) {
				File bakFile = new File(getRollbackFileSuffix(file));
				System.out.println("rename:" + file.renameTo(bakFile));
				System.out.println(file.createNewFile());
				os = new FileOutputStream(file, true);
				IOUtils.write(str, os, "UTF-8");
			} else {
				os = new FileOutputStream(file, true);
				IOUtils.write(str, os, "UTF-8");
				System.out.println(file.length());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	private static String getRollbackFileSuffix(File file){
		
		String suffixStr = ".bak";
		
		File parentFile = file.getParentFile();
		
		String[] fileNameArr = parentFile.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.startsWith(file.getName() + ".")) {
					return true;
				} else {
					return false;
				}
			}
		});
		
		int srcfileLen = file.getName().length() + suffixStr.length();
		int curMaxCount = Stream.of(fileNameArr).mapToInt(x -> Integer.parseInt(x.substring(srcfileLen))).max().orElse(0);
		
		return file.getAbsolutePath() + suffixStr + (curMaxCount + 1);
	}
	
}
