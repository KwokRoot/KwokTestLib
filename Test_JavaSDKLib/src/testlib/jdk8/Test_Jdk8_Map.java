package testlib.jdk8;

import java.util.HashMap;
import java.util.Map;

public class Test_Jdk8_Map {

	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("========= String java.util.Map.put(String key, String value) =========");
		//新值替换旧值，返回旧值
		System.out.println(map.put("1", "1"));
		//结果：null
		System.out.println(map.put("2", "2"));
		//结果：null
		System.out.println(map.put("3", "3"));
		//结果：null
		System.out.println(map.put("1", "11"));
		//结果：1
		System.out.println(map.put("11", "111"));
		//结果：null
		System.out.println(map.put("11", null));
		//结果：111
		
		
		System.out.println("========= @since 1.8 String java.util.Map.putIfAbsent(String key, String value) =========");
		
		//旧值不存在时替换旧值，返回旧值，即 null；旧值存在时，不进行替换，返回旧值。
		System.out.println(map.putIfAbsent("222", "22"));
		//结果：null
		System.out.println(map.putIfAbsent("222", "222"));
		//结果：22
		System.out.println(map);
		//结果：{11=null, 1=11, 2=2, 222=22, 3=3}
		
		
		System.out.println("========= @since 1.8 String java.util.Map.compute(String key, BiFunction remappingFunction) =========");
		
		//新值替换旧值，返回新值
		System.out.println(map.compute("111", (k, v) -> {
			System.out.println(k);
			//结果：111
			System.out.println(v); //v 为旧值。
			//结果：null
			return v + "111111";
		}));
		//结果：null111111
		
		System.out.println("---------");
		
		System.out.println(map.compute("111", (k, v) -> {
			System.out.println(k);
			//结果：111
			System.out.println(v); //v 为旧值。
			//结果：null111111
			return v + "111111";
		}));
		//结果：null111111111111
		
		
		System.out.println("========= @since 1.8 String java.util.Map.computeIfAbsent(String key, Function mappingFunction) =========");
		
		//旧值不存在时替换旧值，返回新值；旧值存在时，不进行替换，返回旧值。
		System.out.println(map.computeIfAbsent("33", k -> {
			System.out.println("--- 执行 ---");
			//结果：--- 执行 ---
			System.out.println(k);
			//结果：33
			return k + "333";
		}));
		//结果：33333
		
		System.out.println("---------");
		
		System.out.println(map.computeIfAbsent("222", k -> {
			System.out.println("--- 不执行 ---");
			//结果：
			System.out.println(k);
			//结果：
			return k + "222222";
		}));
		//结果：22
		
		
		System.out.println("========= @since 1.8 String java.util.Map.computeIfPresent(String key, BiFunction remappingFunction) =========");
		
		//旧值存在时替换旧值，返回新值；旧值不存在时，不进行替换，返回 null。
		System.out.println(map.computeIfPresent("222", (k, v) -> {
			System.out.println(k);
			//结果：222
			System.out.println(v);
			//结果：22
			return v + "," + "222222";
		}));
		//结果：22,222222
		
		System.out.println("---------");
		
		System.out.println(map.computeIfPresent("222222", (k, v) -> {
			System.out.println(k);
			//结果：
			System.out.println(v);
			//结果：
			return v + "222222";
		}));
		//结果：null
		
		
		System.out.println("========= @since 1.8 String java.util.Map.merge(String key, String value, BiFunction remappingFunction) =========");
		
		//旧值不存在时，不执行合并逻辑，直接设置为新值，返回新值；旧值存在时，执行合并逻辑，设置为新值，返回合并处理后的新值。
		System.out.println(map.merge("666", "6", (old_value, new_value) -> {
			System.out.println("--- 不执行 ---");
			//结果：
			System.out.println("old_value:" + old_value);
			//结果：
			System.out.println("new_value:" + new_value);
			//结果：
			return old_value + "," + new_value;
		}));
		//结果：6
		
		System.out.println("---------");
		
		System.out.println(map.merge("666", "666", (old_value, new_value) -> {
			System.out.println("--- 执行 ---");
			//结果：--- 执行 ---
			System.out.println("old_value:" + old_value);
			//结果：old_value:6
			System.out.println("new_value:" + new_value);
			//结果：new_value:666
			return old_value + "," + new_value;
		}));
		//结果：6,666
	}
}
