package testlib.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXAuthenticator;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXPrincipal;
import javax.management.remote.JMXServiceURL;
import javax.security.auth.Subject;

import testlib.jmx.mbean.Hello; 

/**
 * 注册用于调用的 MBean，并启动远程服务器。
 */
public class HelloAgent {

	public static void main(String[] args) throws Exception {

		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

		ObjectName helloName = new ObjectName("testlib.jmx:name=Hello");
		// 创建、注册MBean，注册后可通过 Jconsole、jmc(JavaMissionControl) 本地调用。
		server.registerMBean(new Hello(), helloName);
		// Thread.sleep(60 * 60 * 1000);
		
		
		/* 启动 Web 远程管理服务器 */
		/*
		<dependency>
			<groupId>org.opendaylight.cardinal</groupId>
			<artifactId>jdmk</artifactId>
			<version>0.3.3</version>
		</dependency>
		*/
		/*
		ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
		HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		server.registerMBean(adapter, adapterName);
		adapter.start();
		*/
		/* 启动 Web 远程管理服务器 END */
		
		
		/* 绑定端口启动远程服务器 */
		// 这个步骤很重要，注册一个端口，绑定url后用于客户端通过 rmi 方式连接 JMXConnectorServer
		LocateRegistry.createRegistry(9999);
		
		// URL路径的结尾可以随意指定，但如果需要用 jmc 默认"地址 + 端口"进行连接，则必须使用jmxrmi结尾
		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
		
		Map<String, Object> envMap = new HashMap<String, Object>();
		
		/* 设置连接密码，可无。 */
		envMap.put(JMXConnectorServer.AUTHENTICATOR, new JMXAuthenticator() {
			public Subject authenticate(Object credentials) {
				String[] sCredentials = (String[]) credentials;
				String userName = sCredentials[0];
				String password = sCredentials[1];
				if ("admin".equals(userName) && "admin".equals(password)) {
					Set<JMXPrincipal> principals = new HashSet<JMXPrincipal>();
					principals.add(new JMXPrincipal(userName));
					return new Subject(true, principals, Collections.EMPTY_SET, Collections.EMPTY_SET);
				} else
					throw new SecurityException("Authentication failed! ");
			}
		});
		/* 设置连接密码，可无。END */
		
		JMXConnectorServer jcs = JMXConnectorServerFactory.newJMXConnectorServer(url, envMap, server);
		
		System.out.println("rmi start...");
		jcs.start();
		System.out.println("rmi start!!!");
		
		/* 绑定端口启动远程服务器 END */
		
	}

}
