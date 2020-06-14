package testlib.base;

/**
 * 该练习是对字节类型取值范围[-128,127]理解的练习。
 * @author Kwok
 */
public class Test_ByteRange {
	/*
	 * 原码表示法规定：在数值前面增加了一位符号位（即最高位为符号位）：正数最高位为0，负数最高位为1（0有两种表示：+0和-0），其余位表示数值的大小。
	 * 反码表示法规定：正数的反码与其原码相同；负数的反码是对其原码逐位取反，但符号位除外。
	 * 补码表示法规定：正数的补码与其原码相同；负数的补码是在其反码的末位加1。+0与-0补码表示都为0000 0000。
	 * 在计算机系统中，数值一律用补码来表示和存储。原因在于，使用补码，可以将符号位和数值域统一处理；同时，加法和减法也可以统一处理。此外，补码与原码相互转换，其运算过程是相同的，不需要额外的硬件电路。
	 */
	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		System.out.println("------ 操作 1-1 ------");
		//1 byte = 8 bit ,取值范围：[-128,127]，超出范围编译报错！
		byte b1=127;
		System.out.println(b1);

		byte b2=-128;
		System.out.println(b2);
	
		System.out.println("------ 操作 1-2 ------");
		//byte 取值范围为什么是[-128,127]：
		System.out.println(Integer.valueOf("01111111", 2)); //结果：127
		System.out.println(Integer.valueOf("10000000", 2)); //结果：128
		
		//补码 → 原码(32位运算为例)
		//补码：0111 1111 = 127 最大正数
		//补码：0000 0000 = 0
		//补码：11[23] 1111 1111 末尾-1 = 11[23] 1111 1110，首位不变，按位取反 10[23] 0000 0001 = -1 为最大负数。
		//补码：11[23] 1000 0000 末尾-1 = 11[23] 0111 1111，首位不变，按位取反 10[23] 1000 0000 = -128 
		
		//-0 原码 1000 0000，反码：1111 1111，补码：0000 0000。
		//由于±0补码均为0000 0000表示，所以用补码1000 0000 表示 -128。
		
		System.out.println("------ 操作 1-3 ------");
		
		//遵循：128 + (-128) = 0,亦遵循 ：128的补码 + （-128）的补码 = 0
		
		// 128 原码：00[23] 1000 0000 ， 反码：00[23] 1000 0000， 补码：00[23] 1000 0000 
		System.out.println(Integer.toBinaryString(128));

		//-128 原码：10[23] 1000 0000 ， 反码：11[23] 0111 1111， 补码：反码 + 1 = 11[23] 1000 0000 
		System.out.println(Integer.toBinaryString(-128));
		
		/*System.out.println(Long.toBinaryString(-128)); //64位运算  */		
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		byte b3=(byte) 255; //强转
		
		System.out.println(b3); //结果：-1
		
		//原因
		System.out.println(Integer.toBinaryString(255)); 
		//结果：11111111。
		
		//补码：1111 1111二进制数值转为字节类型，首位为1，按负数处理，负数的补码是原码除符号位取反加1，逆向运算后（1111 1111 - 1 后 1111 1110 除符号位取反为1000 0001，原码值即为-1）。
		//验证
		System.out.println(Integer.toBinaryString(-1)); 
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		//字节类型无符号位运算
		System.out.println(b3 & 0xff); //结果：255
		System.out.println(new Byte("-1") & 0xff); //结果：255
	}
	
}