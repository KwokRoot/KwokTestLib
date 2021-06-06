package testlib;

/**
 * 获取系统环境变量，System.getenv()。
 * 获取系统属性值，System.getProperties()，启动时可通过 Java -D 参数设置。
 * @author Kwok
 * 2021-06-06
 */
public class Test_SystemEnv {

	public static void main(String[] args) {
	
		System.getenv().entrySet().stream().forEach((e) -> {
			System.out.println(e.getKey() + "=" + e.getValue());
		});
		
		System.out.println("==================================");
		
		System.getProperties().entrySet().stream().forEach((e) -> {
			System.out.println(e.getKey() + "=" + e.getValue());
		});

	}
}
