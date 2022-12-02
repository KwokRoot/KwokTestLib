package org.kwok.guava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

public class Test_Guava_Strings {

	public static void main(String[] args) {
		
		// 字符串是否为 null 或 空字串
		System.out.println(Strings.isNullOrEmpty(""));
		System.out.println(Strings.isNullOrEmpty(null));
		
		System.out.println(Strings.repeat("*", 36));
		
		// 从 null 转为空字串
		System.out.println(Strings.nullToEmpty(null));
		System.out.println(Strings.nullToEmpty("abc"));
		
		// 字符串开始填充到指定长度
		System.out.println(Strings.padStart("hello", 8, '*'));
		// 字符串尾部填充到指定长度
		System.out.println(Strings.padEnd("hello", 8, '*'));
		// 字符串重复输出
		System.out.println(Strings.repeat("*", 36));
		
		ImmutableMap<String, String> param = ImmutableMap.of("key1", "value1", "key2", "value2");
		String returnStr = Joiner.on("&").withKeyValueSeparator("=").join(param);
		System.out.println(returnStr);

		Splitter.MapSplitter ms = Splitter.on("&").withKeyValueSeparator('=');
		System.out.println(ms.split(returnStr));

		System.out.println(Strings.repeat("*", 36));
		
		String str = "空格    换行\r 换行\r\n  制表符\t";
		str = CharMatcher.breakingWhitespace().replaceFrom(str, '#');
		System.out.println(str);

	}

}
