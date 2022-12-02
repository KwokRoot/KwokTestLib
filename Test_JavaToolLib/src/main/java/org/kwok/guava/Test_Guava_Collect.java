package org.kwok.guava;


import com.beust.jcommander.internal.Lists;
import com.google.common.base.Strings;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class Test_Guava_Collect {

	public static void main(String[] args) throws Exception {

		// 快速创建集合
		System.out.println(Lists.newArrayList("a", false, 1));
		System.out.println(Maps.newLinkedHashMap().size());
		
		System.out.println(Strings.repeat("*", 36));
		
		// 不可变集合
		System.out.println(ImmutableList.of("a", false, 1).size());
		System.out.println(ImmutableMap.of("key1", "value1", "key2", "value2"));
		
		System.out.println(Strings.repeat("*", 36));
		
		// 多值 Map
		Multimap<String, Integer> mMap = ArrayListMultimap.create();
		mMap.put("test", 1);
		mMap.put("test", 2);
		System.out.println(mMap);

		System.out.println(Strings.repeat("*", 36));
		
		// 双向 Map
		HashBiMap<Integer, String> biMap = HashBiMap.create();
		biMap.put(1, "first");
        biMap.put(2, "second");
        biMap.put(3, "third");
		BiMap<String, Integer> revers = biMap.inverse();
		System.out.println(revers);
		
	}

}
