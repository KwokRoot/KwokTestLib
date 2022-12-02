package org.kwok.expiringmap;

import java.util.concurrent.TimeUnit;

import net.jodah.expiringmap.ExpirationListener;
import net.jodah.expiringmap.ExpirationPolicy;
import net.jodah.expiringmap.ExpiringMap;

/**
 * net.jodah:expiringmap
 * 可设置过期时间的 Map，可用于 token、验证码、缓存数据 等场景的临时储存。
 * @author Kwok 2022-12-02
 */
public class Test_ExpiringMap {

	public static void main(String[] args) throws Exception {

		ExpiringMap<String, String> expirMap = ExpiringMap
				.builder()
				.expiration(3, TimeUnit.SECONDS)
				.expirationPolicy(ExpirationPolicy.CREATED)
				.expirationListener(new ExpirationListener<String, String>() {
					@Override
					public void expired(String key, String value) {
						System.out.println(String.format(">>> key: %s, value: %s expire...", key, value));
					}
				}).build();

		expirMap.put("1", "one");
		expirMap.put("2", "one");
		expirMap.put("3", "one");
		
		Thread.sleep(5000);
		
		System.out.println(expirMap.get("1"));
		
	}
}
