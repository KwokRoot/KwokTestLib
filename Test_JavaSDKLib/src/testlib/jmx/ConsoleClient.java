package testlib.jmx;

import java.util.HashMap;
import java.util.Map;

import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import testlib.jmx.mbean.HelloMBean;

/**
 * 连接远程服务器，调用注册的 MBean，设置属性值，调用 MBean 方法。
 * @author Kwok
 */
public class ConsoleClient {

	public static void main(String[] args) throws Exception {

		JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi");
		
		Map<String, Object> envMap = new HashMap<String, Object>();
		envMap.put(JMXConnector.CREDENTIALS, new String[]{"admin", "admin"});  
		
		JMXConnector jmxc = JMXConnectorFactory.connect(url, envMap);

		MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
		// ObjectName 名称与前面注册时候的保持一致
		ObjectName mbeanName = new ObjectName("testlib.jmx:name=Hello");

		/* 获取该连接下所有的注册MBean的域 */
		System.out.println("Domains ......");
		String[] domains = mbsc.getDomains();
		for (int i = 0; i < domains.length; i++) {
			System.out.println("doumain[" + i + "]=" + domains[i]);
		}
		System.out.println("MBean count = " + mbsc.getMBeanCount());
		/* 获取该连接下所有的注册MBean的域 END */
		
		
		// 设置指定Mbean的特定属性值
		// 这里的setAttribute、getAttribute操作只能针对bean的属性
		// 例如对getName或者setName进行操作，只能使用Name，需要去除方法的前缀
		mbsc.setAttribute(mbeanName, new Attribute("Name", "中国"));
		mbsc.setAttribute(mbeanName, new Attribute("Age", 35));
		String name = (String) mbsc.getAttribute(mbeanName, "Name");
		Integer age = (Integer) mbsc.getAttribute(mbeanName, "Age");
		System.out.println("age=" + age + ";name=" + name);

		/* 调用MBean方法 方式1 */
		HelloMBean proxy = MBeanServerInvocationHandler.newProxyInstance(mbsc, mbeanName, HelloMBean.class, false);
		proxy.helloWorld();
		proxy.helloWorld("Kwok");
		/* 调用MBean的方法 方式1 END*/
		
		/* 调用MBean方法 方式2 */
		// invoke调用mbean的方法，只针对非设置属性的方法，例如invoke不能对getName方法进行调用
		mbsc.invoke(mbeanName, "helloWorld", null, null);
		mbsc.invoke(mbeanName, "helloWorld", new String[] { "I'll connect to JMX Server." },
				new String[] { "java.lang.String" });
		/* 调用MBean方法 方式2 END */
	}

}
