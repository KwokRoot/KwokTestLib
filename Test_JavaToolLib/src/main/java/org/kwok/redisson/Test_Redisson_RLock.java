package org.kwok.redisson;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * 说明：分布式锁
 *
 * @Author: Kwok
 * @Date: 2025/4/3
 */
public class Test_Redisson_RLock {

    public static void main(String[] args) {

        RedissonClient redissonClient = Test_Redisson.getRedissonClient();

        new Thread(()->{
            RLock lock1 = redissonClient.getLock("test:lock");
            System.out.println(lock1);
            lock1.lock();
            System.out.println("t1-加锁:" + DateUtil.now());
            ThreadUtil.sleep(3000);
            lock1.unlock();
            System.out.println("t1-释放锁:" + DateUtil.now());
        }, "t1").start();


        new Thread(()->{
            RLock lock2 = redissonClient.getLock("test:lock");
            System.out.println(lock2);
            lock2.lock();
            System.out.println("t2-加锁:" + DateUtil.now());
            ThreadUtil.sleep(3000);
            lock2.unlock();
            System.out.println("t2-释放锁:" + DateUtil.now());
        }, "t2").start();


        // redissonClient.shutdown();
    }

}
