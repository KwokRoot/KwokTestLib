package org.kwok.filemonitor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.HiddenFileFilter;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

/**
 * 对文件夹或文件进行创建、修改、删除操作进行监控。
 * commons-io 实现。
 * @author Kwok
 */
public class Test_FileMonitor_CommonsIO {

	public static void main(String[] args) throws Exception {

		// 监控目录
		String rootDir = "f://opt/";

		// 轮询间隔 5 秒
		long interval = TimeUnit.SECONDS.toMillis(1);

		// 创建过滤器
		IOFileFilter directories = FileFilterUtils.and(FileFilterUtils.directoryFileFilter(), HiddenFileFilter.VISIBLE);
		IOFileFilter files = FileFilterUtils.and(FileFilterUtils.fileFileFilter(), FileFilterUtils.suffixFileFilter(".txt"));
		IOFileFilter filter = FileFilterUtils.or(directories, files);

		// 使用过滤器
		FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir), filter);
		// 不使用过滤器
		// FileAlterationObserver observer = new FileAlterationObserver(new File(rootDir));

		observer.addListener(new FileAlterationListenerAdaptor() {

			/**
			 * 文件创建执行
			 */
			public void onFileCreate(File file) {
				System.out.println("[新建]:" + file.getAbsolutePath());
			}

			/**
			 * 文件创建修改
			 */
			public void onFileChange(File file) {
				System.out.println("[修改]:" + file.getAbsolutePath());
			}

			/**
			 * 文件删除
			 */
			public void onFileDelete(File file) {
				System.out.println("[删除]:" + file.getAbsolutePath());
			}

			/**
			 * 目录创建
			 */
			public void onDirectoryCreate(File directory) {
				System.out.println("[新建]:" + directory.getAbsolutePath());
			}

			/**
			 * 目录修改
			 */
			public void onDirectoryChange(File directory) {
				System.out.println("[修改]:" + directory.getAbsolutePath());
			}

			/**
			 * 目录删除
			 */
			public void onDirectoryDelete(File directory) {
				System.out.println("[删除]:" + directory.getAbsolutePath());
			}

			public void onStart(FileAlterationObserver observer) {
				// TODO Auto-generated method stub
				super.onStart(observer);
			}

			public void onStop(FileAlterationObserver observer) {
				// TODO Auto-generated method stub
				super.onStop(observer);
			}

		});

		// 创建文件变化监听器
		FileAlterationMonitor monitor = new FileAlterationMonitor(interval, observer);
		// 开始监控
		monitor.start();

	}

}
