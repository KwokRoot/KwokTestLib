package testlib.base;


/**
 * 该练习是对操作符优先级测试的练习。
 * 经验：在不确定操作符优先级时，可以按逻辑加 `()` 来保证优先级的正确性。
 * @author Kwok
 */
public class Test_OperatorPriority {
	
	public static void main(String[] args) {
		/*
		                  运算符							  结合性
		1.[ ] . ( ) (方法调用)					从左向右
		2.! ~ ++ -- +(一元运算) -(一元运算)		从右向左
		3.* / %								从左向右
		4.+ -								从左向右
		5.<< >> >>>							从左向右
		6.< <= > >= instanceof				从左向右
		7.== !=								从左向右
		8.&									从左向右
		9.^									从左向右
		10.|								从左向右
		11.&&								从左向右
		12.||								从左向右
		13.?:								从右向左
		14.=								从右向左
		*/
		
		System.out.println(true && false || true);
		
		//注意以下区别(//优先级 `&&` > `||` > `?:`)：
		System.out.println(false && false || true);
		System.out.println(false && (false || true));
		
		
		System.out.println(true || false ? 1:0 );
		
	}

}
