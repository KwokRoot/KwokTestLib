package testlib;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * java.time.LocalDateTime && java.time.format.DateTimeFormatter
 * @since 1.8
 * This class is immutable and thread-safe.
 * @author Kwok
 */
public class Test_LocalDateTime {

	public static void main(String[] args) {

		/*LocalDateTime 格式化为 字符串*/
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.now();
		String dateStr = dt.format(dtf);
		System.out.println(dateStr);

		/* 格式化字符串 解析为 LocalDateTime*/
		LocalDateTime dt2 = LocalDateTime.parse(dateStr, dtf);
		System.out.println(dt2.atZone(ZoneId.systemDefault()));
		System.out.println();

		// LocalDateTime --> Date
		Date d = Date.from(dt2.toInstant(ZoneOffset.of("+8")));
		System.out.println(d);

		// Date --> LocalDateTime
		Date d2 = new Date();
		LocalDateTime dt3 = LocalDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault());
		System.out.println(dtf.format(dt3));

		// LocalDateTime 获取秒数
		Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
		System.out.println(second);

		// 获取毫秒数
		Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
		System.out.println(milliSecond);
		System.out.println(System.currentTimeMillis());
		
	}
}
