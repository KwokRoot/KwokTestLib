package testlib.timer.exception;

import java.util.TimerTask;

public class CustomTimeTask3 extends TimerTask{

	@Override
	public void run() {
		System.out.println("任务3-执行中...，当前线程名：" + Thread.currentThread().getName());
	}

}
