package org.kwok.jedis;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import cn.hutool.core.util.StrUtil;
import redis.clients.jedis.DefaultJedisClientConfig;
import redis.clients.jedis.JedisClientConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Module;

/**
 * Jedis Test
 * @author Kwok
 * 2025-04-12
 */
public class Test_Jedis {

	public static void main(String[] args) {
		
		// 初始化方式一
//		Jedis jedis = new Jedis("192.168.199.91", 6379, 3000);
//		jedis.auth("123456");
		
		
		// 初始化方式二
//		JedisClientConfig jedisClientConfig = DefaultJedisClientConfig.builder()
//				.password("123456")
//				.database(1)
//				.build();
//		Jedis jedis = new Jedis("192.168.199.91", 6379, jedisClientConfig);


		// 初始化方式三
		Jedis jedis = new Jedis(URI.create("jedis://:123456@192.168.199.91:16379/0"), 3000);
		System.out.println(jedis.info());
		List<Module> modules = jedis.moduleList();
		for (Module module : modules){
		    System.out.println(StrUtil.format("{}:{}", module.getName(), module.getVersion()));
		}

		jedis.set("key", "val");
		
		String queueName = "queue";
		jedis.rpush(queueName, "1", "2", "3");
		System.out.println(jedis.blpop(0, queueName));
		System.out.println(jedis.blpop(0, queueName));
		System.out.println(jedis.blpop(0, queueName));
		// timeout = 0，阻塞永不超时。
		System.out.println(jedis.blpop(0, queueName));
		
		jedis.close();
		
	}
	
}
