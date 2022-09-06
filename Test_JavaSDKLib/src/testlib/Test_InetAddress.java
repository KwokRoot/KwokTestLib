package testlib;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * Java 获取本地主机 IP 。
 * @date: 2022年9月6日
 * @author Kwok
 */
public class Test_InetAddress {

	public static void main(String[] args) throws Exception {
		
		//java.net.NetworkInterface 获取本机 IP
		Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
		
		List<String> list = new ArrayList<String>();
		while (enumeration.hasMoreElements()) {
			NetworkInterface network = enumeration.nextElement();
			if (network.isVirtual() || !network.isUp()) {
				continue;
			} else {
				Enumeration<InetAddress> addresses = network.getInetAddresses();
				while (addresses.hasMoreElements()) {
					InetAddress address = addresses.nextElement();
					if (address != null && (address instanceof Inet4Address || address instanceof Inet6Address)) {
						list.add(address.getHostAddress());
					}
				}
			}
		}

		System.out.println(list);
		System.out.println(list.get(2));
		
		// java.net.InetAddress 获取本机 IP
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		
		// 通过建立 socket 连接，获取当前 IP
		Socket socket = new Socket("www.baidu.com", 80);
		System.out.println(socket.getLocalSocketAddress());
		System.out.println(socket.getRemoteSocketAddress());
		socket.close();

	}

}
