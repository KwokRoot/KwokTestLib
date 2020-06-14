package testlib.string;

import java.util.StringTokenizer;

/**
 * 该练习是对 java.util.StringTokenizer 类的练习。
 * 注： StringTokenizer 是出于兼容性的原因而被保留的遗留类（虽然在新代码中并不鼓励使用它）。建议所有寻求此功能的人使用 String 的 split 方法或 java.util.regex 包。
 * @author Kwok
 */
public class Test_StringTokenizer {

	public static void main(String[] args) {

		String str = "Hello World.";

		StringTokenizer st = new StringTokenizer(str, "o", true);  // 第 3 个参数默认为 false 。不将分隔符作为标记返回的标志。
		
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("---------------------------");

		StringTokenizer st1 = new StringTokenizer("Hello World.");  // 默认分隔符为空格。
		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		
	}

}
