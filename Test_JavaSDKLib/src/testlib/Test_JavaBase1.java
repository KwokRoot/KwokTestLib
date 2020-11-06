package testlib;

/**
 * 
 * Java 中表示 2进制、8进制、16进制 数值。
 * @author Kwok
 */
public class Test_JavaBase1 {

	public static void main(String[] args) {
		
		//2进制，`0b` 开头。
		int i = 0b111; 
		//8进制，`0` 开头。
		long j = 011L;
		//16进制，`0x` 开头。
		int k = 0xf;
		//10进制
		int m = 10;

		System.out.println(i);
		//结果：7
		System.out.println(j);
		//结果：9
		System.out.println(k);
		//结果：15
		System.out.println(m);
		//结果：10

	}

}
