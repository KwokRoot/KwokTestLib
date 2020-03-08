package testlib;

import java.util.HashSet;
import java.util.Set;

/**
 * Set 集合的并集、交集、差集。
 * @author Kwok
 */
public class Test_SetCollection {

	public static void main(String[] args) {
	
		Set<String> set1 = new HashSet<>();
		set1.add("111");
		set1.add("222");
		set1.add("333");
		set1.add("666");
		set1.add("999");
		
		Set<String> set2 = new HashSet<>();
		set2.add("111");
		set2.add("666");
		set2.add("777");
		set2.add("888");
		
		Set<String> set3 = new HashSet<>();
		
		//并集
		set3.addAll(set1);
		set3.addAll(set2);
		System.out.println(set3);
		//结果：[111, 222, 333, 666, 777, 888, 999]
		
		
		//交集
		set3.clear();
		set3.addAll(set1);
		set3.retainAll(set2);
		System.out.println(set3);
		//结果：[111, 666]
		
		
		//差集-1
		set3.clear();
		set3.addAll(set1);
		set3.removeAll(set2);
		System.out.println(set3);
		//结果：[222, 333, 999]
		
		
		//差集-2
		set3.clear();
		set3.addAll(set2);
		set3.removeAll(set1);
		System.out.println(set3);
		//结果：[777, 888]
		
	}
	
}
