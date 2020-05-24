package testlib.base;

import java.util.Date;
import java.util.Locale;

/**
 * System.out.printf(Locale l, String format, Object... args) 、 System.out.printf(String format, Object... args) 方法
 * System.out.format(Locale l, String format, Object... args)  、 System.out.format(String format, Object... args) 方法
 * 使用指定格式字符串和参数将格式化的字符串写入此输出流的便捷方法。
 * @author Kwok
 */
public class Test_Printf {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		/*
		 * 目前printf支持以下格式： 
	     * %c  单个字符 
	     * %d  十进制整数 
	     * %f  十进制浮点数 
	     * %o  八进制数 
	     * %s  字符串 
	     * %x  十六进制数 
	     * %%  输出百分号% 
		 */
		// 0$ 表示第一个参数...
		System.out.printf("%1$c, %2$d, %3$.3f, %4$o, %5$s, %6$x, %7$d%%\n", 'a', 6, 6.66, 8, "abc", 15, 2 );
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		System.out.format("%-30d\n%-30.3f\n%4$30s\n%30s\n", 6, 8.88, "abc", "cbd");
		
		System.out.println(String.format("%-30d\n%-30.3f\n%4$30s\n%30s\n", 6, 8.88, "abc", "cbd"));
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		/*
		 * 	%t 日期时间转化
		 * 
		 *  对应列表
		 *	转换符------类型------举例
		 *	c------完整的日期和时间------Thu Jun 08 16:08:12 CST 2017
		 *	F------ISO 8061日期------2017-06-08
		 *	D------美国格式的日期------06/08/17
		 *	T------24小时时间------16:08:12
		 *	r------12小时时间------04:08:12 PM
		 *	R------24小时时间没有秒------16:08
		 *	Y------4位数字的年（前面补0）------2017
		 *	y------年的后两位数字（前面补0）------17
		 *	C------年的前两位数字（前面补0）------20
		 *	B------月的完整拼写------June
		 *	b或h	---月的缩写------Jun
		 *	m------两位数字的月（前面补0）------06
		 *	d------两位数字的日（前面补0）------08
		 *	e------两位数字的月（前面不补0）------8
		 *	A------星期几的完整拼写------Thursday
		 *	a------星期几的缩写------Thu
		 *	j------三位数的年中的日子（前面补0），在001到366之间------159
		 *	H------两位数字的小时（前面补0），在0到23之间------16
		 *	k------两位数字的小时（前面不补0）在0到23之间------16
		 *	I------（大写的i）	两位数字的小时（前面补0），在0到12之间------04
		 *	l------（小写的L）	两位数字的小时（前面不补0），在0到12之间------4
		 *	M------两位数字的分钟（前面补0）------08
		 *	S------两位数字的秒（前面补0）------12
		 *	L------三位数字的毫秒（前面补0）------868
		 *	N------九位数字的毫微秒（前面补0）------868000000
		 *	P------上午或者下午的大写标志------PM
		 *	p------上午或者下午的小写标志------pm
		 *	z------从GMT起，RFC822数字移位------+0800
		 *	Z------时区------CST
		 *	s------从格林威治时间1970-01-01 00:00:00起的秒数------1496909292
		 *	Q------从格林威治时间1970-01-01 00:00:01起的毫秒数------1496909292868
		 * 
		 */
		Date date=new Date();
		System.out.printf(Locale.US, "%tc\n" ,date);  
        System.out.printf(Locale.US, "%tF\n", date);  
        System.out.printf(Locale.US, "%tD\n", date);  
        System.out.printf(Locale.US, "%tT\n", date);  
        System.out.printf(Locale.US, "%tr\n", date);  
        System.out.printf(Locale.US, "%tR\n", date);  
        System.out.printf(Locale.US, "%tY\n", date);  
        System.out.printf(Locale.US, "%ty\n", date);  
        System.out.printf(Locale.US, "%tC\n", date);  
        System.out.printf(Locale.US, "%tB\n", date);  
        System.out.printf(Locale.US, "%tb\n", date);  
        System.out.printf(Locale.US, "%tm\n", date);  
        System.out.printf(Locale.US, "%td\n", date);  
        System.out.printf(Locale.US, "%te\n", date);  
        System.out.printf(Locale.US, "%tA\n", date);  
        System.out.printf(Locale.US, "%ta\n", date);  
        System.out.printf(Locale.US, "%tj\n", date);  
        System.out.printf(Locale.US, "%tH\n", date);  
        System.out.printf(Locale.US, "%tk\n", date);  
        System.out.printf(Locale.US, "%tI\n", date);  
        System.out.printf(Locale.US, "%tl\n", date);  
        System.out.printf(Locale.US, "%tM\n", date);  
        System.out.printf(Locale.US, "%tS\n", date);  
        System.out.printf(Locale.US, "%tL\n", date);  
        System.out.printf(Locale.US, "%tN\n", date);  
        System.out.printf(Locale.US, "%tp\n", date);  
        // System.out.printf(Locale.US, "%tP\n", date);//此方法报错
        System.out.printf(Locale.US, "%tz\n", date);  
        System.out.printf(Locale.US, "%tZ\n", date);  
        System.out.printf(Locale.US, "%ts\n", date);  
        System.out.printf(Locale.US, "%tQ\n", date);  
		
	}

}
