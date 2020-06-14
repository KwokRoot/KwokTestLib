package testlib.string;

import java.util.Objects;

/**
 * 循环使用 StringBuilder、StringBuffer 实例时，清空当前实例内容三种方式：
 * 1.生成一个新的空的对象。
 * 2.delete() 方式清空。
 * 3.setLength() 方式清空。
 * @author Kwok
 */
public class Test_StringBuilderClear {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Java" + System.getProperty("line.separator"));
		sb.append("C" + System.getProperty("line.separator"));
		sb.append("Python" + System.getProperty("line.separator"));
		sb.append("VB.NET" + System.getProperty("line.separator"));
		sb.append("JS" + System.getProperty("line.separator"));
		sb.append("Node.js" + System.getProperty("line.separator"));
		
		System.out.println(sb.toString());
		System.out.println(Objects.equals(sb.length(), sb.toString().length()));
		
		System.out.println("****** 1.new StringBuilder() 方式清空 ******");
		
		sb = new StringBuilder();
		sb.append("Kwok");
		System.out.println(sb.toString());
		
		
		System.out.println("****** 2.delete() 方式清空 ******");
		
		sb.delete(0, sb.length());
		sb.append("Hello");
		sb.append(" ");
		sb.append("World");
		System.out.println(sb.toString());
		
		
		System.out.println("****** 3.setLength() 方式清空 ******");
		
		sb.setLength(0);
		sb.append("JAVA");
		System.out.println(sb.toString());
		
	}
	
}
