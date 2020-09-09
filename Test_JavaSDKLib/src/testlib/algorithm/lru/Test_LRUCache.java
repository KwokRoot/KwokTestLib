package testlib.algorithm.lru;

/**
 * 测试 LRU (最近最少使用) 缓存。
 * @author Kowk
 */
public class Test_LRUCache {

	public static void main(String[] args) {
		
		LRUCache<Integer, String> lruCache = new LRUCache<Integer, String>(3);
		lruCache.put(1, "111");
		lruCache.put(2, "222");
		lruCache.put(3, "333");
		lruCache.put(6, "666");
		lruCache.put(9, "999");
		
		
		System.out.println(lruCache);
		//结果：{3=333, 6=666, 9=999}
		
		//访问第一个元素
		System.out.println(lruCache.get(3));
		//结果：333
		
		lruCache.put(8, "888");
		
		System.out.println(lruCache);
		//结果：{9=999, 3=333, 8=888}
	}

}
