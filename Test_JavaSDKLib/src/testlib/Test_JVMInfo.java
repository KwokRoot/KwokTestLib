package testlib;

/**
 * 该练习是获取 Java 虚拟机(JVM)内存使用情况及可用处理器数目的练习。
 * @author Kwok
 */
public class Test_JVMInfo {

	public static void main(String[] args) {
		
		Runtime runtime = Runtime.getRuntime();
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		// 返回 Java 虚拟机(JVM)中的内存总量。
		System.out.println(runtime.totalMemory() + "B" + "--JVM 内存总量");
		
		// 返回 Java 虚拟机(JVM)中的空闲内存量。
		System.out.println(runtime.freeMemory() + "B" + "--JVM 空闲内存量" );
		
		// 计算出 JVM 使用率。
		System.out.println(((float)(runtime.totalMemory()-runtime.freeMemory())/runtime.totalMemory())*100 + "% --JVM 使用率");
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		// 返回 Java 虚拟机(JVM)可用处理器的数目。
		System.out.println(runtime.availableProcessors() + "--JVM 处理器数目");
		
	}

}
