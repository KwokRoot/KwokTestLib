package testlib.timer.exception;

import java.util.TimerTask;

public class CustomTimeTask4 extends TimerTask{

	
	@Override
	public void run() {
		System.out.println("任务4-执行中...，当前线程名：" + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		throw new RuntimeException();
	}

}
