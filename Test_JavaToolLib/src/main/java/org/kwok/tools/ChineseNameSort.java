package org.kwok.tools;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * JAVA 实现 名单按姓氏笔画为序排列。
 * @author Kwok
 * 2022-10-24
 */
public class ChineseNameSort {

	public static void main(String[] args) throws Exception {
		
		// 读取汉字笔画排序字典
		HashMap<Character, Integer> char_order = new HashMap<Character, Integer>();
		Path chinese_order_dict = Paths.get(ChineseNameSort.class.getResource("chinese_order_dict.txt").toURI());
		
		Files.readAllLines(chinese_order_dict).forEach(line -> {
			String[] char_order_arr = line.split("\\s");
			char_order.put(char_order_arr[0].charAt(0), Integer.valueOf(char_order_arr[1]));
		});
		// System.out.println(char_order);
		
		
		// 以昨日公布委员会委员名单为例
		Path test_path = Paths.get("D:\\opt\\20th-first.txt");
		List<String> lines = Files.readAllLines(test_path);
		
		lines.stream().sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				/* 注释内容不参与排序 */
				if(o1.contains("（")) {
					o1 = o1.substring(0, o1.indexOf("（"));
				}
				if(o2.contains("（")) {
					o2 = o2.substring(0, o2.indexOf("（"));
				}
				/* 注释内容不参与排序 END */
				
				
				int len = o1.length() < o2.length() ? o1.length() : o2.length();
				for (int i = 0; i < len; i++) {
					int num1 = char_order.getOrDefault(o1.charAt(i), 0);
					int num2 = char_order.getOrDefault(o2.charAt(i), 0);
					if (num1 != num2) {
						return num1 - num2;
					}else{
						// 姓氏相同，名字长度短的在前
						if(o1.length()!= o2.length()) {
							return o1.length() - o2.length();
						}
					}
				}
				return 0;
			}
		}).forEach(System.out::println);

	}
	
}
