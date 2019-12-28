package testlib;

import java.util.ArrayList;
import java.util.List;

/**
 * 可变参数是兼容数组类参数的，但是数组类参数却无法兼容可变参数
 * @author Kwok
 */
public class Test_MultiSameTypeArgs {

	public static void main(String[] args) {

		String[] stringArray = new String[]{"123", "121", "321"};
		System.out.println(execute(stringArray));

		System.out.println(execute("hello", "world"));
		
		List<String> stringList = new ArrayList<String>();
		stringList.add("abc");
		stringList.add("cba");
		//System.out.println(execute(stringList)); //参数不能为 List 类型。
		System.out.println(execute(stringList.toArray(new String[]{})));
		
		
		//System.out.println(execute2("hello", "world")); //参数异常，数组参数只能接受数组
		System.out.println(execute2(stringArray));
		
	}

	public static int execute(String... strings){
		return strings.length;
	}
	
	//编译报错
	/*
	public static int execute(String[] strings){
		return strings.length;
	}
	*/
	
	public static int execute2(String[] strings){
		return strings.length;
	}
	
}
