package testlib.radix;

/**
 * 该练习是对 java.lang.Integer 类方法的练习。
 * 拓展：通用进制的转换 以及 二进制字符串转化为十六进制字符串 、 十六进制字符串转化为二进制字符串。
 * @author Kwok
 */
public class Test_IntegerSwitch {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		// 十进制 转 二进制
		System.out.println(Integer.toBinaryString(3));
		//结果：11
		
		// 十进制 转 八进制
		System.out.println(Integer.toOctalString(9));
		//结果：11
		
		// 十进制 转 十六进制
		System.out.println(Integer.toHexString(17));
		//结果：11
		
		// 字符串 按 参数2 给定的进制基数 进行进制转换为 Integer 类型
		System.out.println(Integer.valueOf("FF", 16));  // 15*16+15*1=255
		//结果：255
		
		// 字符串 按 参数2 给定的进制基数 进行进制转换为 int 类型, 参数2 是给定的进制基数缺省为 10
		System.out.println(Integer.parseInt("FF", 16));  
		//结果：255
		
		// 0x 、 0X 、 # 表示十六进制数， 0 表示八进制数。
		System.out.println(Integer.decode("-#11"));
		//结果：-17
		
		System.setProperty("name", "100");
		System.out.println(Integer.getInteger("name"));
		//结果：100
		System.out.println(Integer.getInteger("name1", 123));  // 参数 1：系统属性名，参数 2： 默认值。
		//结果：123
		
	}
	
	
	/* 二进制字符串转化为十六进制字符串 */
	public static String binStr2hexStr(String binStr) {
		if (binStr == null || binStr.equals("") || binStr.length() % 4 != 0)
			return null;
		StringBuffer sb = new StringBuffer();
		int temp = 0;
		for (int i = 0; i < binStr.length(); i += 4) {
			temp = 0;
			for (int j = 0; j < 4; j++) {
				temp += Integer.parseInt(binStr.substring(i + j, i + j + 1)) << (4 - j - 1);
			}
			sb.append(Integer.toHexString(temp));
		}
		return sb.toString();
	}
	
	
	/* 十六进制字符串转化为二进制字符串 */
	public static String hexStr2binStr(String hexStr) {

		if (hexStr == null || hexStr.equals(""))
			return null;
		StringBuffer sb = new StringBuffer();
		int len = hexStr.length();
		String temp;
		for (int i = 0; i < len; i++) {
			temp = "0000" + Integer.toBinaryString(Integer.parseInt(hexStr.substring(i, i + 1), 16));
			sb.append(temp.substring(temp.length() - 4));
		}
		return sb.toString();
		
	}
	
}