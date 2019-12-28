package testlib.timer.exception;

import java.util.TimerTask;

public class CustomTimeTask1 extends TimerTask{

	@Override
	public void run() {
		System.out.println("任务1-执行中...，当前线程名：" + Thread.currentThread().getName());
	}

}
