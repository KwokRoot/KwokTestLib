package org.kwok.hutool;

import java.net.URI;

import cn.hutool.core.swing.DesktopUtil;
import cn.hutool.http.HttpUtil;

/**
 * 使用 `cn.hutool.http.HttpUtil`、`cn.hutool.http.server.SimpleServer` 创建简单 Http 服务器。
 * @author Kwok
 * 2022-11-19
 */
public class Test_Hutool_HttpServer {

	public static void main(String[] args) {
		
		int port = 8070;
		String requestPath = "http://127.0.0.1:" + port;
		
		// 快速创建 Http Server .
		HttpUtil.createServer(port).addAction("/", (req, res) -> {
			res.write("Hello Hutool Server .");
		}).start();

		DesktopUtil.browse(URI.create(requestPath));
		
	}

}
