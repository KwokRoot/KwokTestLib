package testlib.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 该练习是测试 Map 默认值的练习。 
 * 测试结果：只有不包含 key 时，才会返回默认值。
 * @author Kwok
 */
public class Test_MapDefaultValue {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("0", null);
		map.put("1", "111");
		map.put("2", "123");

		// 注：只有不包含这个 key 时，才会返回默认值。
		System.out.println(map.getOrDefault("3", "666"));
		// 结果：666

		// 注：包含这个 key，key 的值为 null 时，不会返回默认值！
		System.out.println(map.getOrDefault("0", "999"));
		// 结果：null

		// 注：key 不存在，无默认值时，返回 null。
		System.out.println(map.get("8"));
		// 结果：null
	}
}
