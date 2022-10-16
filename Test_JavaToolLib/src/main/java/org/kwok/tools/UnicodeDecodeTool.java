package org.kwok.tools;

import org.apache.commons.text.StringEscapeUtils;
import org.nutz.lang.Strings;

import cn.hutool.core.text.UnicodeUtil;

/**
 * 第三方类库对 Unicode 编码、解码的处理。
 * @author Kwok
 * 2022-10-16
 */
public class UnicodeDecodeTool {

	public static void main(String[] args) {
		
		String str = "中国";
		// org.apache.commons:commons-text 库对字符串 Unicode 编码
		System.out.println(StringEscapeUtils.escapeJava(str));
		// cn.hutool:hutool-all 库对字符串 Unicode 编码
		System.out.println(UnicodeUtil.toUnicode("中国"));
		
		
		// Unicode 编码字符串自动解码，注 `\ u`。
		System.out.println("\u4e2d\u56fd");
		
		
		String unicodeStr = "\\u4e2d\\u56fd";
		// org.apache.commons:commons-text 库对 Unicode 编码字符串解码
		System.out.println(StringEscapeUtils.unescapeJava(unicodeStr));
		// cn.hutool:hutool-all 库对 Unicode 编码字符串解码
		System.out.println(UnicodeUtil.toString(unicodeStr));
		// org.nutz:nutz 库对 Unicode 编码字符串解码
		System.out.println(Strings.unicodeDecode(unicodeStr));
		
	}

}
