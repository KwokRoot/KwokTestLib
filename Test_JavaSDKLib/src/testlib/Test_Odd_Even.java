package testlib;

/**
 * 判断奇偶数
 * @author Kwok
 * 2022-01-23
 */
public class Test_Odd_Even {

	public static void main(String[] args) {
		
		int i = 99;
		//1.求余运算 `%2`，1 为奇数；0，则为偶数。
		System.out.println(i % 2 == 1 ? "奇数" : "偶数");
		
		//2.位运算 `&1`，1 为奇数；0，则为偶数。
		System.out.println((i & 1) == 0 ? "偶数" : "奇数");
	}

}
