package org.kwok.hutool;

import cn.hutool.core.swing.clipboard.ClipboardUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.system.SystemUtil;

/**
 * `cn.hutool.*Util` 常用工具。
 * @author Kwok
 * 2022-11-19
 */
public class Test_Hutool {

	public static void main(String[] args) {

		// 产生排除某些字符的随机字符串
		System.out.println(RandomUtil.randomStringWithoutStr(8, "0o"));

		// 格式化字符串
		System.out.println(StrUtil.format("{}.{}-{}", "A", 1, 'a'));
		
		// 重复字符串
		System.out.println(StrUtil.repeat("*", 36));

		// md5
		System.out.println(SecureUtil.md5("admin"));
		System.out.println(DigestUtil.md5Hex("admin"));
		
		// 判断字符串是否为数值类型
		System.out.println(NumberUtil.isNumber("0")); // true 
		System.out.println(NumberUtil.isNumber(""));  // false
		System.out.println(NumberUtil.isNumber("123e3")); // true
		
		// 获取JVM运行环境的系统信息
		System.out.println(SystemUtil.getRuntimeInfo());

		// 获取主机IP
		System.out.println(SystemUtil.getHostInfo());
		
		// 转义 / 过滤 HTML 特殊字符，防止XSS攻击
		System.out.println(HtmlUtil.escape("<script type='text/javascript'>alert('hello');</script>"));
		System.out.println(HtmlUtil.filter("<script type='text/javascript'>alert('hello');</script>"));
	
		// 获取剪贴版文本内容
		System.out.println(ClipboardUtil.getStr());
	}
}
