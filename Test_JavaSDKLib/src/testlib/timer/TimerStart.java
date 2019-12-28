package testlib.timer;

import java.util.Timer;

public class TimerStart {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		TimeTask task = new TimeTask(timer);
		timer.schedule(task, 0, 1000);
		
	}
	
}
