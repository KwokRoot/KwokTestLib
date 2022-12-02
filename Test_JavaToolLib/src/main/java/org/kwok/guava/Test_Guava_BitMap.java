package org.kwok.guava;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * BiMap(bidirectional map) 键(Key)、值(Value)不可重复，可反转 K、V 值。
 * @author Kwok
 */
public class Test_Guava_BitMap {

	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "111");
		map.put(2, "222");
		map.put(3, "333");
		
		BiMap<Integer, String> biMap = HashBiMap.create(map);
		System.out.println(biMap);
		//结果：{1=111, 2=222, 3=333}
		
		System.out.println(biMap.inverse());
		//结果：{111=1, 222=2, 333=3}
	}
	
}
