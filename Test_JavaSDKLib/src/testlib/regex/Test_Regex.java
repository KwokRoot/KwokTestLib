package testlib.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 该练习是对 Java 正则表达式 Pattern.quote() 方法以及正则表达式 分组捕获 的理解练习。
 * 对 Matcher.appendReplacement() 及 Matcher.appendTail() 的使用简单说明。
 * @author Kwok
 */
public class Test_Regex {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		/*
		 *当使用 Pattern.quote() 方法后,将".*"转换为只能匹配".*"的字符串。
		 *\Q 代表字面值的开始。
		 *\E 代表字面值的结束。
		 */
		
		String regex11 = ".*";
		String regex12 = Pattern.quote(".*");
		
		System.out.println(regex11);
		System.out.println(regex12);
		
		Pattern pattern11 = Pattern.compile(regex11);
		
		Matcher matcher11 = pattern11.matcher("123");
		System.out.println(matcher11.matches());  // true
		
		matcher11 = pattern11.matcher(".*");
		System.out.println(matcher11.matches());  // true
		
		
		
		Pattern pattern12 = Pattern.compile(regex12);
				
		Matcher matcher12 = pattern12.matcher("123");
		System.out.println(matcher12.matches());  // false
		
		matcher12 = pattern12.matcher(".*");
		System.out.println(matcher12.matches());  // true
        
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		// group 分组,用 () 分组
		
		Pattern p2 = Pattern.compile("(\\d{3,5})(?<kwok>[a-z]{2})");
		String s = "123aa-34345bb-234cc-00";
		Matcher m2 = p2.matcher(s);
		
		System.out.println("--- 操作 2-1 ---");
		p(m2.groupCount());// 2组
		
		while (m2.find()) {
			System.out.println("--- 操作 2-2 ---");
			p(m2.group());// 数字字母都有。  等效于 p(m2.group(0));
			p(m2.group(1));//只有数字
			p(m2.group(2));//只有字母
			p(m2.group("kwok")); // (?<name>pattern) 捕获组设置别名。
		}

		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		String regex3 = "a*b";
		String str3 = "aabfooaabfooabfoob@163.com";
		String replace3 = "-";
		Pattern p = Pattern.compile(regex3);
		// 获取 matcher 对象
		Matcher m = p.matcher(str3);
		
		StringBuffer sb = new StringBuffer();
		
		while (m.find()) {
			m.appendReplacement(sb, replace3);
			System.out.println(sb);
		}
		
		System.out.println("---观察两次结果的不同---");
		System.out.println(sb.toString());
		
		m.appendTail(sb);
		System.out.println(sb.toString());  
	}
	

	public static void p(Object b){
		System.out.println(b);
	}

}
