package testlib.base;

/**
 * 该练习是对 异常处理 的简单练习。
 * @author Kwok
 */
public class Test_Exception {

	public static void main(String[] args) {
		
		int a = 100;
		
		try {
			a = 1 / 0;  // 被除数÷除数=商...余数
		} catch (ArithmeticException e) {
			System.err.println("抛出异常：除数不能为 0 !!!");
		}
		
		// 异常被捕获，catch 操作执行后，程序正常执行。
		System.out.println("------- " + a + " ------");
		
		a = 1 / 0;
		// 异常未被捕获，抛出异常，程序不能正常执行。
		System.out.println("------- 200 ------");
		
		// 自己抛出异常。
		throw new NullPointerException();
		
		// 编译报错：Unreachable code (不能执行到的代码。)
		//System.out.println("------- 300 ------");
	}

}
