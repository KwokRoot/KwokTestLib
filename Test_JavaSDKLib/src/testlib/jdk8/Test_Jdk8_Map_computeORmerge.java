package testlib.jdk8;

import java.util.HashMap;

/**
 * Map.compute() 与 Map.merge() 方法使用案例。
 * @author Kwok
 * 2023-04-16
 */
public class Test_Jdk8_Map_computeORmerge {

	public static void main(String[] args) {

		HashMap<String, Long> map = new HashMap<String, Long>();
		map.put("A", 100L);
		map.put("B", 200L);
		
		Long count = 100L;
		
		// Map.compute() 实现 Map 相同 Key 的 Value 值累加。
		map.compute("C", (key, oldValue) -> {
			if (oldValue == null) {
				oldValue = 0L;
			}
			return oldValue + count;
		});
		System.out.println(map);
		
		
		// Map.merge() 实现 Map 相同 Key 的 Value 值累加。
		map.merge("D", count, (oldValue, newValue) -> newValue + oldValue);
		System.out.println(map);

	}

}
