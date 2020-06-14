package testlib.timer.example2;

import java.util.Timer;

public class Test_Example2 {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask_Example2 task = new TimerTask_Example2(timer);
		timer.schedule(task, 0, 1000);
		
	}
	
}
