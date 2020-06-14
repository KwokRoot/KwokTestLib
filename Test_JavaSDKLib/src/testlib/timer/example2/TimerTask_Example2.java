package testlib.timer.example2;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTask_Example2 extends TimerTask{

	Timer timer ;
	Date endTime = new Date(System.currentTimeMillis() + 1000 * 6);
	int count = 0;
	
	public TimerTask_Example2(Timer timer){
		this.timer = timer;
	}
	
	@Override
	public void run() {
	
		try{
			System.out.println("------ 执行开始 ------");
			
			count++;
			System.out.println(Thread.currentThread().getName() + " 执行中...");
			if(count >= 3 || new Date().after(endTime)){
				//取消此任务
				this.cancel();
				//从计时器任务队列中移除所有已取消的任务 
				timer.purge();
				//终止此计时器，丢弃所有当前已安排的任务
				timer.cancel();
			}
			
			//此处抛异常
			System.out.println(1/0);
			
		}catch (Exception e) {
			System.out.println("捕获异常信息：" + e.getMessage());
		}finally {
			System.out.println("------ 执行结束 ------");
		}
	}
	
}
