package testlib.string;

/**
 * 该练习是 字符 与 Unicode码 相互转化的练习。
 * @author Kwok
 */
public class Test_Unicode {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1:字符 转 Unicode码 ------------------------------");
		
		char a='香';
		System.out.println("\\u" + Integer.toHexString(a));
		
		
		System.out.println("------------------------------ 操作 2:Unicode码 转 字符 ------------------------------");
		
		char b = '\u9999';
		System.out.println(b);
		
		
		System.out.println("------------------------------ 操作 3:模拟字符串转 Unicode 码 ------------------------------");
		
		String str = "你好！HI";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			sb.append("/u" + Integer.toHexString(str.charAt(i)));
		}
		System.out.println(sb.toString());
		
		
		System.out.println("------------------------------ 操作 4:模拟 Unicode 码转字符串 ------------------------------");
		
		String unicodeStr = sb.toString();
		//System.out.println(unicodeStr.split("/u").length);
		for (int i = 1; i < unicodeStr.split("/u").length; i++) {
			System.out.print((char)Integer.parseInt(unicodeStr.split("/u")[i], 16));
		}
		
	}
}
