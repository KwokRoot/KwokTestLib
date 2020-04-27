package testlib.jaas;

import java.security.Principal;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;

public class Test_Jaas2 {

	public static void main(String[] args) {

		System.setProperty("java.security.policy",
				Thread.currentThread().getContextClassLoader().getResource("testlib/jaas/jaas2.policy").getPath());
		System.setProperty("java.security.auth.login.config",
				Thread.currentThread().getContextClassLoader().getResource("testlib/jaas/jaas2.config").getPath());

		System.setSecurityManager(new SecurityManager());
		
		LoginContext context = null;
		try {
			// 创建登录上下文
			context = new LoginContext("jaas2", new CustomCallbackHander());
			// 进行登录，登录不成功则系统退出
			context.login();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Cannot create LoginContext. " + e.getMessage());
			System.exit(-1);
		}

		// 访问资源
		Subject subject = context.getSubject();

		System.out.println(subject);

		for (Principal principal : subject.getPrincipals()) {
			System.out.println(principal.toString());
		}

		// 该方法调用需要"doAsPrivileged"权限
		Subject.doAsPrivileged(subject, new PrivilegedAction<Object>() {
			@Override
			public Object run() {
				System.out.println(System.getProperty("java.home"));
				return null;
			}
		}, null);

	}

}
