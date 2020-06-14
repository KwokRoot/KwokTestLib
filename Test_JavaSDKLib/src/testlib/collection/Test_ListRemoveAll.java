package testlib.collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 该练习是对 list 项移除的练习。
 * 操作一、操作二 可作为面试考题。
 * @author Kwok
 */
public class Test_ListRemoveAll {

	public static void main(String[] args) {
		
		List<String> list =new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		System.out.println("list:" + list);
		
		/* 操作一： */
		/*
		for (String str : list) {
			System.out.println(str);
			list.remove(str);  // 抛异常：java.util.ConcurrentModificationException(并发修改异常)。
		}
		*/
		
		/* 操作二： */
		/*
		for (int i = 0;i < list.size(); i++) {
			System.out.println("第 "+i+" 次遍历，移除： " + list.get(i));
			list.remove(i);
		}
		System.out.println(list);  // 执行结果：[2, 4]  。 理解 For 循环的执行步骤，模拟程序的执行可以发现 list.size() 每次重新计算。
		*/
		
		/* 操作三： */
		/*
		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.println("第 "+i+" 次遍历，移除： " + list.get(i));
			list.remove(i);
		}
		System.out.println(list); // 该方式能遍历移除 list 所有项。
		*/
		
		/* 操作四： */
		
		Iterator<String> iterator = list.iterator();  // 利用 iterator 迭代器方式移除 list 元素。
		while (iterator.hasNext()) {
			System.out.println("移除： " + iterator.next());
			iterator.remove(); //iterator.remove() 方法必须在每次调用 iterator.next() 方法后调用，只能调用一次!
		}
		System.out.println(list); // 该方式能遍历移除 list 所有项。
		
		/* 操作五： */
		/*
		list.removeAll(list); // 利用 removeAll() 方法移除 list 所有项。
		System.out.println(list);
		*/
		
	}

}
