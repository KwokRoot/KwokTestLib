package testlib.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java.util.regex.Matcher.matches() 全串匹配。
 * java.util.regex.Matcher.find() 定位到匹配的子串。
 * @author 
 */
public class Test_Regex_find {

	public static void main(String[] args) {
		
		String patternStr = "\\S*?_(\\d{4})(\\d{2})(\\d{2})";
		String str = "welcome_20200830_shanghai_20200830_ok";
		
		//* 后面的? 表示非贪婪模式
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(str);
		
		//给定字符串是否全匹配正则表达式
		System.out.println(matcher.matches());
		//结果：false
		
		//重置匹配位置
		matcher.reset();
		
		//定位到给定字符串匹配正则表达式的子串
		while (matcher.find()) {
			System.out.println("--------- 配置到子串 ---------");
			System.out.println("本次匹配的子串开始位置：" + matcher.start());
			System.out.println("本次匹配的子串结束位置：" + matcher.end());
			System.out.println("本次匹配到的子串：" + matcher.group());
			System.out.println("本次匹配到的子串：" + str.substring(matcher.start(), matcher.end()));
		}
		
		/*结果：
		--------- 配置到子串 ---------
		本次匹配的子串开始位置：0
		本次匹配的子串结束位置：16
		本次匹配到的子串：welcome_20200830
		本次匹配到的子串：welcome_20200830
		--------- 配置到子串 ---------
		本次匹配的子串开始位置：16
		本次匹配的子串结束位置：34
		本次匹配到的子串：_shanghai_20200830
		本次匹配到的子串：_shanghai_20200830
		*/
	}
	
}
