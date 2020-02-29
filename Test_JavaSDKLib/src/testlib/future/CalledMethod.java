package testlib.future;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 被调用者
 * @author Kwok
 */
public class CalledMethod {
	
	public static String execute(){
		
		System.out.println("CalledMethod#execute 方法执行中...");
		
		try {
			Thread.sleep(800);
			System.out.println("CalledMethod#execute 方法执行完成...");
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
	}

}
