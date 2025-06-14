package org.kwok.hutool;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.map.BiMap;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.map.TableMap;

/**
 * Hutool 关于 Map 的常用工具类。
 * @author Kwok
 * 2025-03-08
 */
public class Test_Hutool_Map {

	public static void main(String[] args) {
		
		// http 路径参数拼接
		String param = MapUtil.builder()
			.put("k1", "v1")
			.put("k2", 2)
			.put("k3", false)
			.put(false, "k4", "0")
			.join("&", "=");
	
		System.out.println(param);

		// BiMap 不可重复键和值的 双向 Map，通过 2个 Map 实现，注意键、值会覆盖。
		System.out.println(new BiMap<String, String>(MapUtil.of(Pair.of("1", "111"), Pair.of("2", "222"), Pair.of("3", "333"))).getInverse());

		// TableMap可重复键和值的 双向 Map，通过 2个 List 实现，数据越多越慢。
		System.out.println(new TableMap<String, String>(new String[]{"1", "2", "3"}, new String[]{"111", "222", "333"}).getKey("222"));
		
	}
	
}
