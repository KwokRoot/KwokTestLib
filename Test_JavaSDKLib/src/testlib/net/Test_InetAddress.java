package testlib.net;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


/**
 * Java 获取本地网卡及 IP 信息 。
 * @date: 2022年9月6日
 * @author Kwok
 */
public class Test_InetAddress {

	public static void main(String[] args) throws Exception {
		
		//java.net.NetworkInterface 获取本机网卡信息
		Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
		
		List<NetworkInterface> niList = new ArrayList<NetworkInterface>();
		List<String> addressList = new ArrayList<String>();
		while (enumeration.hasMoreElements()) {
			NetworkInterface ni = enumeration.nextElement();
			niList.add(ni);
			Enumeration<InetAddress> addresses = ni.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				if (address != null && (address instanceof Inet4Address || address instanceof Inet6Address)) {
					addressList.add(String.format("%-6s ==> %s", ni.getName(), address.getHostAddress()));
				}
			}
		}
		
		
		System.out.println("------------------------------ 操作 1 ------------------------------");
		
		System.out.println("********* 1-1 *********");
		niList.forEach(System.out::println);
		
		System.out.println("********* 1-2 *********");
		addressList.forEach(System.out::println);
		
		
		System.out.println("------------------------------ 操作 2 ------------------------------");
		
		// java.net.InetAddress 获取本机 IP
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		
		
		System.out.println("------------------------------ 操作 3 ------------------------------");
		
		// 通过建立 socket 连接，获取当前 IP
		DatagramSocket socket = new DatagramSocket();
		socket.connect(InetAddress.getByName("8.8.8.8"), 80);
		System.out.println(socket.getLocalSocketAddress());
		System.out.println(socket.getRemoteSocketAddress());
		socket.close();

	}

}
