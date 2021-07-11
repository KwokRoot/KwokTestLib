package org.kwok.hutool;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.system.SystemUtil;

public class Test_Hutool {

	public static void main(String[] args) {

		//产生排除某些字符的随机字符串
		System.out.println(RandomUtil.randomStringWithoutStr(8, "0o"));

		//获取JVM运行环境的系统信息
		System.out.println(SystemUtil.getRuntimeInfo());

		//获取主机IP
		System.out.println(SystemUtil.getHostInfo());

		//快速创建http服务器
		HttpUtil.createServer(8080).addAction("/", (req, res) -> {
			res.write("Hello Hutool Server");
		}).start();

		//快速创建文件服务器
		HttpUtil.createServer(8888)
			// 设置默认根目录
			.setRoot("D:\\Kwok\\Work\\GitHub")
			.start();
		
	}

}
