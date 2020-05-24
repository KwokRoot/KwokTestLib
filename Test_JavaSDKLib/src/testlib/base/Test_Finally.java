package testlib.base;

public class Test_Finally {

	public static Integer method(boolean is){
		try{
			if(is){
				System.out.println(1/0);
			}
			return 1;
		}catch (Exception e) {
			System.out.println("catch");
		}finally {
			System.out.println("finally");
			//return 2;
		}
		
		System.out.println("正常");
		return 0;
		
	}
	
	public static void main(String[] args) {
		
		// 注意：虽然在 try 代码块中 return 结果，但 finally 代码块依然执行！！！
		System.out.println(method(false));
		System.out.println("----------------");
		System.out.println(method(true));
		
	}
	
}
