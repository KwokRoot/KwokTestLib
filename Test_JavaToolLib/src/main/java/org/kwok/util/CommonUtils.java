package org.kwok.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonUtils{
	
	public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	public static void printOut(String out) {
		System.out.println(out);
	}
	
	public static void printErr(String err) {
		System.err.println(err);
	}
	
	public static String datetime() {
		return LocalDateTime.now().format(dateTimeFormatter);
	}
	
	
}


