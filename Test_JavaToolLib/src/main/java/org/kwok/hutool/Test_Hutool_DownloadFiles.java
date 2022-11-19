package org.kwok.hutool;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.swing.DesktopUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;

/**
 * 使用 `cn.hutool.http.HttpUtil`、`cn.hutool.http.server.SimpleServer` 创建简单的文件下载服务器。
 * @author Kwok
 * 2022-11-19
 */
public class Test_Hutool_DownloadFiles {

	public static void main(String[] args) throws Exception {

		String downloadDir = "d:/upload";
		int port = 8090;
		String downloadPath = "http://127.0.0.1:" + port;
		
		// 遍历目录及子目录的所有文件
		List<String> file_index_list = FileUtil.loopFiles(downloadDir).stream().map(f -> {
			String filePath = f.getPath().substring(downloadDir.length());
			String filePath2 = filePath.replaceAll("\\\\", "/");
			return StrUtil.format("<a href='{}{}'>{}</a><br>", downloadPath, filePath2, filePath);
		}).collect(Collectors.toList());
		
		// HTML 页面添加编码集 
		file_index_list.add(0, "<meta charset=\"utf-8\">");
		// 把目录下的文件写到索引文件
		FileUtil.writeLines(file_index_list, downloadDir + "/index.html", Charset.forName("UTF-8"));
		
		// 快速创建文件服务器
		HttpUtil.createServer(port)
			// 设置默认根目录
			.setRoot(downloadDir).start();
		
		// 打开默认浏览器
		DesktopUtil.browse(URI.create(downloadPath)); 
	
	}

}
