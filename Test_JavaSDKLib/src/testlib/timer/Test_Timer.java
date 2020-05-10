package testlib.timer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 该练习是对 Timer 计时器的简单实现的练习。
 * @author Kwok
 */
public class Test_Timer extends TimerTask{

	public static void main(String[] args) {
		
		Test_Timer test_Timer=new Test_Timer();
		Timer timer=new Timer();
		timer.schedule(test_Timer, 0, 1000);
	}

	@Override
	public void run() {
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
	}

}
