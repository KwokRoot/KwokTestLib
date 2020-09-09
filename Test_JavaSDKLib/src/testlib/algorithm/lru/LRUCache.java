package testlib.algorithm.lru;

import java.util.LinkedHashMap;

/**
 * java.util.LinkedHashMap 实现  LRU (最近最少使用) 缓存机制。
 * LRU(Least Recently Used)，即最近最少使用，是一种常用的页面置换算法，选择最近最久未使用的元素予以淘汰。
 * 
 * @author Kwok
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private static final long serialVersionUID = 1L;
	protected int maxElementSize;

	public LRUCache(int maxSize) {
		super(maxSize, 0.75F, true);
		maxElementSize = maxSize;
	}

	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		return size() > maxElementSize;
	}

}
