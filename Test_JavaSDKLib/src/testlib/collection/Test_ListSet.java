package testlib.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * List 集合特点：可重复，有序(插入顺序)。
 * Set 集合特点：不重复，无序。
 * @author Kwok
 */
public class Test_ListSet {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(1);
		list.add(null);
		list.add(null);
		list.add(null);
		list.add(2);
		list.add("2");
		System.out.println(list.size());  // 结果： 6
		System.out.println(Arrays.toString(list.toArray()));  // 结果： [1, null, null, null, 2, 2]
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		HashSet<Object> set=new HashSet<Object>();
		set.add(1);
		set.add(null);
		set.add(null);
		set.add(2);
		set.add("2");
		System.out.println(set.size());  // 结果： 4
		System.out.println(Arrays.toString(set.toArray()));  // 结果： [null, 1, 2, 2]
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		TreeSet<Object> set2=new TreeSet<Object>(new Comparator<Object>() {

			@Override
			public int compare(Object o1, Object o2) {
				return o2.hashCode()-o1.hashCode();
			}
			
		});
		set2.add("1");
		set2.add("2");
		set2.add("0");
		System.out.println(set2.size());  // 结果： 3
		System.out.println(Arrays.toString(set2.toArray()));  // 结果： [2, 1, 0]
	}

}
