package testlib.timer.exception;

import java.util.Timer;

/**
 * 该练习是对 java.util.Timer 出现异常情况的练习。
 * 执行结果：只有 task3 最终一直执行。
 * 结论：一个 Timer 是一个线程，一个 Timer 中可以有多个任务。当一个任务出现没有捕获异常时，整个 Timer 停止运行。
 * 解决方案：可以在任务最外层进行一次异常捕获。
 * @author Kwok
 */
public class Test_TimerException {

	public static void main(String[] args) {
		
		/*---------- 使用一个定时器 ---------*/
		
		Timer timer1 = new Timer();
		CustomTimeTask1 task1 = new CustomTimeTask1();
		CustomTimeTask2 task2 = new CustomTimeTask2(); //task2 有异常抛出。
		timer1.schedule(task1, 0, 1000);
		timer1.schedule(task2, 0, 1000);
		

		/*---------- 不同定时器 ---------*/
		
		Timer timer3 = new Timer();
		Timer timer4 = new Timer();
		CustomTimeTask3 task3 = new CustomTimeTask3();
		CustomTimeTask4 task4 = new CustomTimeTask4(); //task4 有异常抛出。
		timer3.schedule(task3, 0, 1000);
		timer4.schedule(task4, 0, 1000);
		
	}

}
