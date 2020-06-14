package testlib.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 该练习是对 TreeMap 的练习。
 * TreeMap 能自动根据其键的自然顺序进行排序。
 * @author Kwok
 */
public class Test_TreeMap {

	public static void main(String[] args) {
		
		Map<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("b", "bbb");
		hashMap.put("a", "aaa");
		hashMap.put("c", "ccc");
		hashMap.put("1", "333");
		hashMap.put("2", "222");
		hashMap.put("3", "111");
		hashMap.put("abc", "abc");
		hashMap.put("ab", "ab");
		hashMap.put("acb","acb");
		
		System.out.println("源：" + hashMap);
		// 结果：源：{a=aaa, 1=333, ab=ab, acb=acb, b=bbb, 2=222, c=ccc, 3=111, abc=abc}
		
		
		Map<String, Object> treeMap = new TreeMap<String, Object>();
		treeMap.putAll(hashMap);
		System.out.println("目标：" + treeMap);
		// 结果：目标：{1=333, 2=222, 3=111, a=aaa, ab=ab, abc=abc, acb=acb, b=bbb, c=ccc}
	}

}
