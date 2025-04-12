package org.kwok.redisson;

import cn.hutool.core.date.DateUtil;
import org.redisson.api.CronSchedule;
import org.redisson.api.RScheduledExecutorService;
import org.redisson.api.RedissonClient;
import org.redisson.api.WorkerOptions;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Test_Redisson_RSchedule {


    public static void main(String[] args) {

    	// 调度
        RedissonClient redissonClient = Test_Redisson.getRedissonClient();
        RScheduledExecutorService executorService = redissonClient.getExecutorService("test:rschedule");
        executorService.registerWorkers(WorkerOptions.defaults());

//        executorService.delete();
//        executorService.shutdown();

//        executorService.execute(new MyTask());
        executorService.schedule(new MyTask(), CronSchedule.of("0/1 * * * * ?"));
//        executorService.scheduleAtFixedRate(new MyTask(), 0, 3, TimeUnit.SECONDS);

//        redissonClient.shutdown();
    }
    

    static class MyTask implements Runnable, Serializable{

        @Override
        public void run() {
            System.out.println("-> " + DateUtil.now());
        }
    }

}
