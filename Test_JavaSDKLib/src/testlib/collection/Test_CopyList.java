package testlib.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 该练习是对 java.util.Collections.copy(dest <The destination list>, src <The source list>) 的练习。
 * 使用时必须保证 dest.size() >= src.size() 。
 * @author Kwok
 */
public class Test_CopyList {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("111");
		list.add("222");
		list.add("333");
		System.out.println("源：" + list); //结果：源：[111, 222, 333]
		
		
		List<String> dest = new ArrayList<String>(Arrays.asList(new String[list.size()]));
		Collections.copy(dest, list);
		System.out.println("目标：" + dest); //结果：目标：[111, 222, 333]
		
		List<String> list2 = new ArrayList<>(list);
		List<String> list3 = list;
		
		System.out.println("dest 是否是引用对象：" + (list == dest)); //结果：dest 是否是引用对象：false
		System.out.println("List2 是否是引用对象：" + (list == list2)); //结果：List2 是否是引用对象：false
		System.out.println("List3 是否是引用对象：" + (list == list3)); //结果：List3 是否是引用对象：true
		
		
		// dest.size() < src.size()。抛异常：java.lang.IndexOutOfBoundsException: Source does not fit in dest 。
		/*
		List<String> dest = new ArrayList<String>(Arrays.asList(new String[list.size() - 1]));
		Collections.copy(dest, list);
		System.out.println("目标：" + dest); //结果：异常：java.lang.IndexOutOfBoundsException
		*/
		
		
		// dest.size() > src.size()。多余长度位置会填充 null。
		/*
		List<String> dest = new ArrayList<String>(Arrays.asList(new String[list.size() + 1])); Collections.copy(dest, list);
		Collections.copy(dest, list);
		System.out.println("目标：" + dest); //结果：目标：[111, 222, 333, null]
		*/
	}

}
