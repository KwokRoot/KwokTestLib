package org.kwok.filemonitor;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * 对文件夹或文件进行创建、修改、删除操作进行监控。
 * JDK 实现。
 * 注：
 * 1.当文件修改时，会被调用两次，即输出两个相同的修改。
 * 2.不能对其子文件夹文件进行监控，只能提示目录被修改。
 * @author Kwok
 */
public class Test_FileMonitor_JDK {

	public static void main(String[] args) throws Exception {
		
		final Path path = Paths.get("f://opt/");
		
		try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
			
			// 给path路径加上文件监控服务
			path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
					StandardWatchEventKinds.ENTRY_DELETE);
			
			while (true) {
				
				final WatchKey key = watchService.take();
				
				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					
					final WatchEvent.Kind<?> kind = watchEvent.kind();
					
					if (kind == StandardWatchEventKinds.OVERFLOW) {
						continue;
					}
					// 创建事件
					if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
						System.out.println("[新建]");
					}
					// 修改事件
					if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
						System.out.println("[修改]");
					}
					// 删除事件
					if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
						System.out.println("[删除]");
					}
					// get the filename for the event
					final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
					final Path filename = watchEventPath.context();
					// print it out
					System.out.println(kind + " -> " + filename);
				}
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}
			
		} catch (IOException | InterruptedException ex) {
			System.err.println(ex);
		}
	}

}
