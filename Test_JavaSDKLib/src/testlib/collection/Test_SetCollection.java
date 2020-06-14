package testlib.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * 该练习是利用 java.util.Set 类，求数学集合中的 交集、差集、并集的练习。
 * @author Kwok
 */
public class Test_SetCollection {

	public static void main(String[] args) {
		
		Set<Integer> result = new HashSet<Integer>();
        
		// 定义 set1 集合{1, 3, 5}
		Set<Integer> set1 = new HashSet<Integer>(); 
    	set1.add(1);
    	set1.add(3);
    	set1.add(5);
    	
    	// 定义 set2 集合{1, 2, 3} 
        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        
        //交集
        result.clear();
        result.addAll(set1);
        result.retainAll(set2); // 仅保留 set1 中那些包含在 set2 中的元素，即 result 与 set2 的交集。注：此操作会修改此 result 集合。
        System.out.println("交集:"+result); //结果：交集:[1, 3]
        
        //差集
        result.clear();
        result.addAll(set1);
        result.removeAll(set2); // 移除 set1 中包含 set2 中的所有元素。
        System.out.println("差集:"+result); //结果：差集:[5]
        
        //并集
        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集:"+result); //结果：并集:[1, 2, 3, 5]
        
	}

}
