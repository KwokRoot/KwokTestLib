package testlib.file;

import java.io.File;

/**
 * File.delete() 方法的加强版，无论文件夹是否为空，都可以删除一切文件夹目录结构。
 * @author Kwok
 */
public class Test_DeleteDirPlus {

	public static void execute(String dirPath) {
		File f = new File(dirPath);
		if (!f.delete()) {
			File[] filelist = f.listFiles();
			for (File file : filelist) {
				if (!file.isDirectory()) {
					file.delete();
				} else {
					if (!file.delete()) {
						Test_DeleteDirPlus.execute(file.getAbsolutePath());
					}
				}
			}
			f.delete();
		}
	}

	public static void main(String[] args) {
		Test_DeleteDirPlus.execute("路径地址");
	}
	
}