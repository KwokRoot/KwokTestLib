package testlib.string;

/**
 * 该练习是对字符串比较的练习。字符串比较用 String.equals()。
 * 推荐使用 java.util.Objects 类的 Objects.equals() 方法。
 * @author Kwok
 */
public class Test_StringEquals {

	public static void main(String[] args) {

		System.out.println("------------------------------ 操作 1 ------------------------------");

		String str1 = new String("");
		System.out.println(str1 == ""); // false
		System.out.println(str1.equals("")); // true
		
		String str12 = new String("");
		System.out.println(str1 == str12); // false
		System.out.println(str1.equals(str12)); // true
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		String str2 = "";
		System.out.println("" == str2); // true
		System.out.println(str2.equals("")); // true

		String str21 = "123";
		String str22 = "123";
		System.out.println(str21 == str22); // true
		System.out.println(str21.hashCode());  // 48690
		System.out.println(str22.hashCode());  // 48690

		
		System.out.println("------------------------------ 操作 3 ------------------------------");

		String str3 = null;
		System.out.println(null == str3); // true
		//System.out.println(str3.equals(null)); //结果：异常：java.lang.NullPointerException
		
	}
}
