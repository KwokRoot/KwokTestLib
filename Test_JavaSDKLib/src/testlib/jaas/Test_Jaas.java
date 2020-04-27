package testlib.jaas;

public class Test_Jaas {

	public static void main(String[] args) {
		
		System.setProperty("java.security.policy", Thread.currentThread().getContextClassLoader().getResource("testlib/jaas/jaas.policy").getPath());
		
		//安装安全管理器
        System.setSecurityManager(new SecurityManager());
        
        System.out.println(System.getProperty("java.home"));

	}

}
