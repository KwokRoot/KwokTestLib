package org.kwok.redisson;

import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;
import org.redisson.api.RBoundedBlockingQueue;
import org.redisson.api.RIdGenerator;
import org.redisson.api.RList;
import org.redisson.api.RListMultimap;
import org.redisson.api.RMap;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;

import cn.hutool.core.collection.CollUtil;

/**
 * @description: Redisson 分布式数据结构
 * @author: Kwok
 * @date: 2025/4/1
 */
public class Test_Redisson {

    public static RedissonClient getRedissonClient(){
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.199.91:6379")
                .setPassword("123456")
                .setDatabase(2);
        config.setCodec(new JsonJacksonCodec());
        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    public static void main(String[] args) throws InterruptedException {

        RedissonClient redissonClient = Test_Redisson.getRedissonClient();

        // List
        RList<Object> rList = redissonClient.getList("test:list");
        rList.add("1");
        rList.add("2");
        rList.add("3");
        System.out.println(rList);

        
        // Map
        RMap<String, String> rmap = redissonClient.<String, String>getMap("test:map");
        rmap.put("1", "111");
        rmap.put("2", "222");
        rmap.put("3", "333");
        System.out.println(rmap.getAll(CollUtil.newHashSet("2", "3")));;
        System.out.println(rmap.readAllMap());

        
        // 多值 Map
        RListMultimap<String, String> rMultimap = redissonClient.<String, String>getListMultimap("test:multimap");
        rMultimap.put("6", "1");
        rMultimap.put("6", "11");
        rMultimap.put("6", "111");
        rMultimap.putAll("8", CollUtil.newArrayList("8", "88", "888"));
        System.out.println(rMultimap.getAll("6"));

        
        // 队列
        RQueue<Object> queue = redissonClient.getQueue("test:queue");
        queue.add("1");
        queue.add("2");
        queue.add("3");
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        
        // 阻塞队列
        RBlockingQueue<Object> blockingQueue = redissonClient.getBlockingQueue("test:bqueue");
        blockingQueue.offer("1");
        blockingQueue.put("2");
        blockingQueue.put("3");
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        // System.out.println(blockingQueue.take()); // 阻塞
        System.out.println(blockingQueue.poll());


        // 阻塞有界队列
        RBoundedBlockingQueue<Object> boundedBlockingQueue = redissonClient.getBoundedBlockingQueue("test:bbqueue");
        System.out.println(boundedBlockingQueue.trySetCapacity(3));
        boundedBlockingQueue.put("1");
        System.out.println(boundedBlockingQueue.offer("2"));
        boundedBlockingQueue.put("3"); // 阻塞
        System.out.println(boundedBlockingQueue.poll());
        System.out.println(boundedBlockingQueue.poll());
        System.out.println(boundedBlockingQueue.peek());
        System.out.println(boundedBlockingQueue.poll());
        // System.out.println(boundedBlockingQueue.take()); // 阻塞
        System.out.println(boundedBlockingQueue.poll());

        // Id 生成器，非单调自增
        RIdGenerator rIdGenerator = redissonClient.getIdGenerator("test:id");
        System.out.println(rIdGenerator.nextId());


        redissonClient.shutdown();
    }

}
