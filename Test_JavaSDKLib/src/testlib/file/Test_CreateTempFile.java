package testlib.file;

import java.io.File;

/**
 * 该练习是 创建临时文件 并 删除临时文件目录 的练习。
 * @author Kwok
 */
public class Test_CreateTempFile {

	public static void main(String[] args) {

		File dir = new File("d:/java/temp");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		
		try {
			File tempFile = File.createTempFile("temp-", ".txt", dir);
			System.out.println(tempFile.getName());
			Thread.sleep(2000);
			tempFile.delete(); // 删除此抽象路径名表示的文件或目录。
			// tempFile.deleteOnExit(); // deleteOnExit() 方法，在虚拟机终止时，请求删除此抽象路径名表示的文件或目录。

			boolean isDelete = dir.delete();
			if (isDelete == false) {
				File[] files = dir.listFiles();
				for (File f : files) {
					System.out.println("强制删除临时文件：" + f.getName());
					f.delete();
				}
				dir.delete();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
