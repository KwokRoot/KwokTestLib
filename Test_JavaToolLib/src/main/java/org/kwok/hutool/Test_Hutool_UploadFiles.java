package org.kwok.hutool;

import java.net.URI;

import cn.hutool.core.net.multipart.UploadFile;
import cn.hutool.core.swing.DesktopUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;

/**
 * 使用 `cn.hutool.http.HttpUtil`、`cn.hutool.http.server.SimpleServer` 创建简单的文件上传服务器。
 * @author Kwok
 * 2022-11-19
 */
public class Test_Hutool_UploadFiles {
	
	public static void main(String[] args) {
		
		int port = 8080;
		String uploadPath = "http://127.0.0.1:" + port;
		
		HttpUtil.createServer(port).addAction("/", (request, response) -> {

			String method = request.getMethod().toUpperCase();
			switch (method) {
			case "GET":
				response.write(Test_Hutool_UploadFiles.class.getResourceAsStream("upload.html"), ContentType.TEXT_HTML.name());
				break;
			
			case "POST":
				final UploadFile[] files = request.getMultipart().getFiles("upfile");
				for (UploadFile file : files) {
					file.write("d:/upload/" + file.getFileName());
				}
				response.write(StrUtil.format("<h3>OK!</h3><a href='{}'>Please send your another Files .</a>", uploadPath), ContentType.TEXT_HTML.toString());
				break;
			
			default:
				response.sendError(600, "Request method no support!");
			}
			
		}).start();
		
		DesktopUtil.browse(URI.create(uploadPath));
		
	}

}
