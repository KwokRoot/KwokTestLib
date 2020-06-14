package testlib.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 该练习是对 Map 中 Set<Map.Entry<K,V>> entrySet() 方法获取键-值映射关系集的练习。
 * Map.Entry<K,V> 接口是 Map<K,V> 接口的内部接口。HashMap.Entry<K,V> 类是 HashMap<K,V> 类的内部类。
 * @author Kwok
 */
public class Test_Map_Entry {

	public static void main(String[] args) {

		Map<Integer, Object> map = new HashMap<Integer, Object>();
		map.put(1, 111);
		map.put(2, "222");
		map.put(3, 333L);

		System.out.println("------------------------------ 操作 1 ------------------------------");

		System.out.println(map);

		System.out.println("------------------------------ 操作 2 ------------------------------");

		Set<Map.Entry<Integer, Object>> entrySet = map.entrySet();
		for (Map.Entry<Integer, Object> entry : entrySet) {
			//System.out.println(entry);
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

}
