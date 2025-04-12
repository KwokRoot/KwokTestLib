package org.kwok.redisson;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * 说明：锁续期
 * 只有其他进程(Test_Redisson_RLock2_1)崩溃或主动关闭，看门狗线程随之终止，锁将不再续期。
 * 默认 30s 超时后，自动解锁。该进程(Test_Redisson_RLock2_2) 获取到锁。
 * @Author: Kwok
 * @Date: 2025/4/3
 */
public class Test_Redisson_RLock2_2 {

    public static void main(String[] args) {

        RedissonClient redissonClient = Test_Redisson.getRedissonClient();

        new Thread(()->{
            RLock lock2 = redissonClient.getLock("test:lock");
            System.out.println(lock2);
            try {
                lock2.lock();
                System.out.println("t2-加锁:" + DateUtil.now());
                ThreadUtil.sleep(3000);
            } finally {
                lock2.unlock();
                System.out.println("t2-释放锁:" + DateUtil.now());
            }
        }, "t2").start();

    }

}
