package org.kwok.joinery;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import joinery.DataFrame;

/**
 * 使用 sh.joinery:joinery-dataframe 库进行分组求和
 * 类似 Python pandas 库
 * @author Kwok
 * 2022-11-06
 */
public class Test_Joinery {

	public static void main(String[] args) throws Exception {
		
		System.out.println(Paths.get(Test_Joinery.class.getResource("Test_Joinery.txt").toURI()));
		
		List<String> lines = Files.readAllLines(Paths.get(Test_Joinery.class.getResource("Test_Joinery.txt").toURI()), Charset.defaultCharset());
		DataFrame<Object> df = new DataFrame<Object>("key", "value");
		
		
		Pattern p =Pattern.compile("(?<key>\\S*)\\s*(?<val>\\S*)");
		
		lines.stream().forEach(x -> {
			Matcher m = p.matcher(x);
			if(m.matches()) {
				// System.out.println(m.group("key"));
				// System.out.println(m.group("val"));
				df.append(Arrays.asList(m.group("key"), Double.valueOf(m.group("val"))));
			}
			
		});
		
		// 窗体展示
		df.groupBy("key").sum().sortBy("-value").show();
		
		// 打印 1000 行，默认 10 行
		System.out.println(df.groupBy("key").sum().sortBy("-value").toString(1000));
		
	}
}
