package org.kwok.hutool;

import cn.hutool.core.lang.Pair;
import cn.hutool.core.map.BiMap;
import cn.hutool.core.map.MapUtil;

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
		
		// 双向 Map
		System.out.println(new BiMap<String, String>(MapUtil.of(Pair.of("1", "111"), Pair.of("2", "222"), Pair.of("3", "333"))).getInverse());
		
		
	}
	
}
