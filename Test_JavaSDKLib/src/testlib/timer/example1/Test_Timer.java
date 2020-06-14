package testlib.timer.example1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * 该练习主要是对 Timer 类及 TimerTask 接口方法的实践练习。
 * Timer 类对象的 schedule() 方法 、 cancel() 方法 、 purge() 方法。
 * TimerTask 接口的实现类对象的 cancel() 方法 、 scheduledExecutionTime() 方法。
 * @author Kwok
 */
public class Test_Timer {

	public static void main(String[] args) {
		
		// 创建Timer对象
		Timer timer=new Timer("kwok"); // 创建一个新计时器，其相关的线程具有指定的名称。
		
		// 创建任务
		TimerTask1 task1=new TimerTask1();
		TimerTask2 task2=new TimerTask2();
		
		
		timer.schedule(task1, 0, 500); // 安排指定的任务在指定的时间开始进行重复的固定延迟执行。
		timer.scheduleAtFixedRate(task2, 0, 1000); // 安排指定的任务在指定的延迟后开始进行重复的固定速率执行。
		
		
		System.out.println(task1.cancel()); // 取消计时器的此任务。
		System.out.println(timer.purge()); // 从此计时器的任务队列中移除所有已取消的任务。
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		System.out.println(sdf.format(new Date(task1.scheduledExecutionTime()))); // 返回此任务最近实际执行的已安排执行时刻。
		
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel(); // 终止此计时器，丢弃所有当前已安排的任务。
	}

}
