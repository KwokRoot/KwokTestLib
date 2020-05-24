package testlib.base;

/**
 * 该练习是对 For 循环执行步骤的分解测试练习。注意第一次 j 的结果。
 * @author Kwok
 */
public class Test_For {

	public static void main(String[] args) {
		
		/*
		 * for( 表达式1：初始化表达式 ; 表达式2： 循环变量判定表达式 ; 表达式3：循环变量修正表达式 ){ 循环体 ; }
		 * 注：执行第一次时 表达式3：循环变量修正表达式 不执行；
		 */
		for (int i = 0, j = 0; i < 3; j = 3, i++) {
			
			System.out.println("i:" + i);
			System.out.println("j:" + j);
			System.out.println("-----------------------");
			
		}
		
		/*
		结果：
			i:0
			j:0
			-----------------------
			i:1
			j:3
			-----------------------
			i:2
			j:3
			-----------------------
		*/
	}

}
