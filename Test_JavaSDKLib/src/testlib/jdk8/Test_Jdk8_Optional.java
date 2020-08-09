package testlib.jdk8;

import java.util.Optional;

public class Test_Jdk8_Optional {

	public static void main(String[] args) {
		
		//对象存在，取对象的值，不存在设置默认值。
		String str1 = "Hello";
		System.err.println(Optional.ofNullable(str1).orElse("没有值"));
		
		String str2 = null;
		System.err.println(Optional.ofNullable(str2).orElse("没有值"));

	}

}
