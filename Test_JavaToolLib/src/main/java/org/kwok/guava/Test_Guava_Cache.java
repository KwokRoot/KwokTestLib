package org.kwok.guava;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * 只有 缓存数 > maximumSize, expireAfterWrite/expireAfterAccess 才生效。
 * @author guohao
 */
public class Test_Guava_Cache {

	public static void main(String[] args) throws Exception {

		LoadingCache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(3)
				.refreshAfterWrite(3, TimeUnit.SECONDS)
//				.expireAfterWrite(3, TimeUnit.SECONDS)
				.expireAfterAccess(5, TimeUnit.MINUTES)
				.removalListener(new RemovalListener<String, String>() {
					@Override
					public void onRemoval(RemovalNotification<String, String> removalNotification) {
						System.out.println("过期 key: " + removalNotification.getKey());
					}
				})
				.recordStats()
				.build(new CacheLoader<String, String>(){
					// 当数据不存在时，再次加载。
					@Override
					public String load(String key) throws Exception {
						return "new:" + key;
					}
					
				});
		
		
		cache.put("user1", "1");
		cache.put("user2", "2");
		cache.put("user3", "3");
		cache.put("user4", "4");
		cache.put("user5", "5");
		cache.put("user6", "6");
		
		Thread.sleep(3000);
		
		// 访问缓存，更新访问过期时间
		// cache.get("user4");
		System.out.println(cache.stats());
		
		System.out.println("user3 ===> " + cache.getUnchecked("user3"));
		System.out.println("user3 ===> " + cache.get("user3"));
		System.out.println("user6 ===> " + cache.get("user6"));
		
		System.out.println(cache.stats());
		
	}
	
}
