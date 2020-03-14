package testlib;

/**
 * 测试 java.lang.Class.getName() 方法返回值。
 */
public class Test_ClassName {

	public static void main(String[] args) {
		
		String str = "Hello";
		System.out.println(str.getClass().getName());
		//结果：java.lang.String
		
		
		//一位数组
		String[] strArray = new String[]{"H", "E", "F"};
		System.out.println(strArray.getClass().getName());
		//结果：[Ljava.lang.String;
		
		
		//多维数组
		int[][][] ia = new int[3][6][9];
		System.out.println(ia.getClass().getName());
		//结果：[[[I
		
	}
	
}
