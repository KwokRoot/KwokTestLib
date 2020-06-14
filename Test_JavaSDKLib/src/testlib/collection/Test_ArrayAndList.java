package testlib.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 该练习是对 List 类型 Array 类型相互转化的练习。
 * @author Kwok
 */
public class Test_ArrayAndList {

	public static void main(String[] args) {

		System.out.println("------------------------------ 操作 1 ------------------------------");

		/* List 类型 转化为 Array */

		ArrayList<Object> list = new ArrayList<>();
		list.add("123");
		list.add("Hello");
		list.add("你好！");

		/*
		 * 注：Object[] toArray() 与 T[] toArray(T[] a) 方法详情请查看 JDK API 。
		 * list.toArray() 返回值类型为 Object[] 类型,不能强制转化为原 list 元素类型。见 操作 3 。
		 */

		/* 方法 1： */
		System.out.println(Arrays.toString(list.toArray()));
		
		//不能强制转化为原 List 类型。
		try {
			System.out.println(Arrays.toString((String[]) list.toArray()));
		} catch (ClassCastException e) {
			System.out.println("------ 已抛异常 ------" + e.getMessage());
		}
		
		//转为原类型的正确操作。
		System.out.println(Arrays.toString(list.toArray(new String[] {})));
		System.out.println(Arrays.toString((Object[])list.toArray(new String[] {})));
		
		//注：不必为目标类型设置相同长度。
		System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		/* Array 类型 转化为 List */
		
		String[] array = new String[] {"Hello", "你好！", "123"};
		List<String> list2 = Arrays.asList(array);
		System.out.println(list2);
		
	}
}