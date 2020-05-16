package testlib.jvmerror;

/*
 * 模拟 JVM 栈溢出异常:java.lang.StackOverflowError。
 */
public class Test_StackOverflowError {

	static long count = 0L;
	
	public static void main(String[] args) {
		stackOverFlowMethod();
	}
	
	
	public static void stackOverFlowMethod(){
		System.out.println(++count);
		try{
			stackOverFlowMethod();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//打印栈深度。
			//System.exit(-1);
		}
	}
	
}
