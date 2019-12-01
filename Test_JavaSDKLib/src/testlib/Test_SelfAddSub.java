package testlib;

/**
 * 自增(i++、++i)
 * 自减(i--、--i)
 * @author Kwok
 */
public class Test_SelfAddSub {

	public static void main(String[] args) {
		
		System.out.println("--------- 自增 ++i, i++ ---------");
		/*
		 * 自增
		 * ++ 在后，先用再加
		 * ++ 在前，先加再用
		 */
		int i = 8;
		System.out.println(i++); //输出：8
		System.out.println(i); //输出：9
		
		System.out.println(++i); //输出：10
		System.out.println(i); //输出：10
		
		
		System.out.println("--------- 自减 --i, i-- ---------");
		/*
		 * 自减
		 * -- 在后，先用再减
		 * -- 在前，先减在用
		 */
		int j = 8;
		System.out.println(j--); //输出：8
		System.out.println(j); //输出：7
		
		System.out.println(--j); //输出：6
		System.out.println(j); //输出：6
		
	}

}
