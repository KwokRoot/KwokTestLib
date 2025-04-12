package org.kwok.redisson;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

/**
 * 说明：锁续期
 * 超时 30s，10s 续一次
 * 若业务线程因异常退出，但 JVM 进程仍在运行，看门狗线程会继续续期锁，直到锁被显式释放或进程终止。
 * 业务线程异常，需`finally`中手动释放锁。
 * 若 JVM 进程崩溃或主动关闭，看门狗线程随之终止，锁将不再续期，等待 TTL 30s 超时后自动释放。
 * @Author: Kwok
 * @Date: 2025/4/3
 */
public class Test_Redisson_RLock2_1 {

    public static void main(String[] args) {

        RedissonClient redissonClient = Test_Redisson.getRedissonClient();

        new Thread(()->{
            RLock lock1 = redissonClient.getLock("test:lock");
            System.out.println(lock1);
            try {
                lock1.lock(); // 超时 30s，10s 续一次
                System.out.println("t1-加锁:" + DateUtil.now());
                ThreadUtil.sleep(45000); // 45s，续期 4次 10s，+ 默认超时 30s = 70s

                // 异常需`finally`中手动释放锁
                // int i = 1/0;

                // 进程退出，看门狗线程中止，不在进行锁续期。
                System.exit(-1);
            } finally {
                lock1.unlock(); // 确保异常手动释放锁
                System.out.println("t1-释放锁:" + DateUtil.now());
            }
        }, "t1").start();

    }

}
