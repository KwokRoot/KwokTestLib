package org.kwok.filemonitor;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.WatchEvent;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.watch.SimpleWatcher;
import cn.hutool.core.io.watch.WatchMonitor;
import cn.hutool.core.io.watch.watchers.DelayWatcher;
import cn.hutool.core.lang.Console;

/**
 * 对文件夹或文件进行创建、修改、删除操作进行监控。
 * Hutool 实现。
 * @author Kwok
 */
public class Test_FileMonitor_Hutool {

	public static void main(String[] args) throws Exception {

		File file = FileUtil.file("f://opt/");
		// 这里只监听文件或目录的修改事件
		WatchMonitor watchMonitor = WatchMonitor.createAll(file, new DelayWatcher(new SimpleWatcher() {
			@Override
			public void onCreate(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("创建：{}-> {}", currentPath, obj);
			}

			@Override
			public void onModify(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("修改：{}-> {}", currentPath, obj);
			}

			@Override
			public void onDelete(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("删除：{}-> {}", currentPath, obj);
			}

			@Override
			public void onOverflow(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("Overflow：{}-> {}", currentPath, obj);
			}
		}, 500));

		// 设置监听目录的最大深入，目录层级大于制定层级的变更将不被监听，默认只监听当前层级目录
		watchMonitor.setMaxDepth(3);
		// 启动监听
		watchMonitor.start();
	}

}
