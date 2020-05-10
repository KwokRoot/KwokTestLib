package testlib.timer.example;

import java.util.Timer;

public class Test_Example1 {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimerTask_Example1 task = new TimerTask_Example1(timer);
		timer.schedule(task, 0, 1000);
		
	}
	
}
