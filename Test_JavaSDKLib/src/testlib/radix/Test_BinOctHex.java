package testlib.radix;

/**
 * 该练习主要是十进制 与 二进制、八进制、十六进制相互转换的练习。
 * @author Kwok
 */
public class Test_BinOctHex {

	public static void main(String[] args) {

		System.out.println("------------------------------ 操作 1 ------------------------------");
		/* 十进制转换为其他进制 */

		//十进制转成二进制 
		p(Integer.toBinaryString(2));
		
		//十进制转成八进制 
		p(Integer.toOctalString(8));
		
		//十进制转成十六进制：
		p(Integer.toHexString(16));
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		/* 其他进制转换为十进制 */
		
		//二进制转十进制
		p(Integer.valueOf("10", 2).toString());
		
		//八进制转成十进制
		p(Integer.valueOf("10", 8).toString());
		
		//十六进制转成十进制
		p(Integer.valueOf("10", 16).toString());
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		// 能够转化的最大进制数。 可以使用字符 0-9 、 a-z 共计36 个(10 + 26)。
		System.out.println(Character.MAX_RADIX);
		System.out.println(Character.MIN_RADIX);
		
		p(Integer.valueOf("z", 36).toString());
		p(Integer.valueOf("10", 36).toString());
		
		
		System.out.println("------------------------------ 操作 4 ------------------------------");
		/* Integer.parseInt() 与 Integer.valueOf() 返回值类型不同 */
		
		
		// Integer.valueOf(String s, int radix);   返回一个 Integer 对象，该对象中保存了用第二个参数提供的基数进行解析时从指定的 String 中提取的值。
		p(Integer.valueOf("-10", 9).toString());
		
		
		// Integer.parseInt(String s, int radix);  返回一个 int 类型对象，使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
		p(Integer.valueOf(Integer.parseInt("-10", 9)));
		
	}
	
	
	private static void p(Object obj) {
		System.out.println(obj);
	}

}
