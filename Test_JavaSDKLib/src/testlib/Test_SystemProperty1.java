package testlib;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

/**
 * 该练习对系统的默认配置项的读取练习。
 * @author Kwok
 */
public class Test_SystemProperty1 {

	public static void main(String[] args) {

		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("user.home"));
		System.out.println(System.getProperty("user.dir"));
		System.out.println("----------------------------------------------");
		
		/* 获取系统的默认配置 */
		Properties props = System.getProperties();
		
		/* 遍历默认配置项 */
		
		// 方式一：
		/*
		Enumeration<?> enums = props.propertyNames();
		while (enums.hasMoreElements()) {
			System.out.println(enums.nextElement() + " : " + props.getProperty((String) enums.nextElement()));
		}
		*/
		
		// 方式二：
		/*
		Set<Object> enums2=props.keySet();
		for (Object object : enums2) {
			System.out.println(object);
		}
		*/
		
		// 方式三：
		/*
		Enumeration<Object> enums3 = props.keys();
		while (enums3.hasMoreElements()) {
			System.out.println(enums3.nextElement());
		}
		*/
		
		// 方式四：
		
		Set<Entry<Object, Object>> enums4=props.entrySet();
		for (Entry<Object, Object> entry : enums4) {
			System.out.println(entry.getKey() +" : "+ entry.getValue());
		}
		
	}

}
