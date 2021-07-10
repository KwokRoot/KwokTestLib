package testlib.spi;

import java.util.ServiceLoader;

/**
 * SPI(Service Provider Interface)。
 * 注：运行前需要把 `testlib.spi.ServerProvider` 文件放置到 `resources/META-INF/services/` 目录。
 * 加载的顺序为 `testlib.spi.ServerProvider` 配置的实现类顺序。
 * 
 * 优点：
 *     使用 Java SPI 机制的优势是实现解耦，使得接口的定义与具体业务实现分离，而不是耦合在一起。应用进程可以根据实际业务情况启用或替换具体组件。
 *     
 * 缺点：
 *     不能按需加载。虽然 ServiceLoader 做了延迟载入，但是基本只能通过遍历全部加载，也就是接口的实现类得全部载入并实例化一遍。如果你并不想用某些实现类，或者某些类实例化很耗时，也被载入并实例化，这就造成了浪费。
 *     获取某个实现类的方式不够灵活，只能通过 Iterator 形式获取，不能根据某个参数来获取对应的实现类。
 *     多个并发多线程使用 ServiceLoader 类的实例是不安全的。
 *     加载不到实现类时抛出异常并不是真正原因的异常，错误很难定位。
 *     实现如果依赖其他的实现，做不到自动注入和装配，底层采用 Class.forName() 方式加载。
 *     
 */
public class Test_ServerProvider {

	public static void main(String[] args) {
		
		ServiceLoader<ServerProvider> serviceLoader = ServiceLoader.load(ServerProvider.class);
		
		System.out.println(serviceLoader.iterator().hasNext());
		
		for (ServerProvider serverProvider : serviceLoader) {
			
			System.out.println(serverProvider.getServerHost() + ":" + serverProvider.getServerPort());
			
		}
		
	}
	
}
