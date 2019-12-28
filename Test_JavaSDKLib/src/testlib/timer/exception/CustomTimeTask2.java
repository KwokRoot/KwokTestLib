package testlib.timer.exception;

import java.util.TimerTask;

public class CustomTimeTask2 extends TimerTask{

	
	@Override
	public void run() {
		System.out.println("任务2-执行中...，当前线程名：" + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(1/0);
	}

}
