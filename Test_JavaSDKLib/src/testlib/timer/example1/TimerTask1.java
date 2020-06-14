package testlib.timer.example1;

import java.util.TimerTask;

public class TimerTask1 extends TimerTask {

	@Override
	public void run() {
		
		//System.out.println(Thread.currentThread().getName());  // 可以获取指定的 Timer 相关的线程名称。
		System.out.println("Task1...");

	}

}
