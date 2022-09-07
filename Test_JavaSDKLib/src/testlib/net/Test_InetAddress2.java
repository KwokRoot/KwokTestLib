package testlib.net;

import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Java 获取本地主机 IP 。
 * @author Kwok
 * 2022-09-07
 */
public class Test_InetAddress2 {

	/*
	 * 获取本机所有网卡信息，得到所有 IP 信息
	 * @return List<Inet4Address>
	 */
	public static List<Inet4Address> getLocalIp4AddressFromNetworkInterface() throws SocketException {
		
		List<Inet4Address> addresses = new ArrayList<>();
		// 所有网络接口信息
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		if (Objects.isNull(networkInterfaces)) {
			return addresses;
		}
		while (networkInterfaces.hasMoreElements()) {
			NetworkInterface networkInterface = networkInterfaces.nextElement();
			// 过滤回环网卡、点对点网卡、非活动网卡、虚拟网卡并要求网卡名字是 `eth`、`ens` 或 `wlan` 开头
			if (!isValidInterface(networkInterface)) {
				continue;
			}
			// 所有网络接口的 IP 地址信息
			Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
			while (inetAddresses.hasMoreElements()) {
				InetAddress inetAddress = inetAddresses.nextElement();
				// 判断是否是 IPv4，并且内网地址过滤回环地址.
				if (isValidAddress(inetAddress)) {
					addresses.add((Inet4Address) inetAddress);
				}
			}
		}
		
		return addresses;
	}

	/**
	 * 过滤回环网卡、点对点网卡、非活动网卡、虚拟网卡并要求网卡名字是 `eth`、`ens` 或 `wlan` 开头
	 * @param NetworkInterface
	 * @return 如果满足要求则 true，否则 false
	 */
	private static boolean isValidInterface(NetworkInterface ni) throws SocketException {
		return !ni.isLoopback() && !ni.isPointToPoint() && ni.isUp() && !ni.isVirtual()
				&& (ni.getName().startsWith("eth") || ni.getName().startsWith("ens") || ni.getName().startsWith("wlan"));
	}

	/**
	 * 判断是否是 IPv4，并且内网地址过滤回环地址.
	 */
	private static boolean isValidAddress(InetAddress address) {
		return address instanceof Inet4Address && address.isSiteLocalAddress() && !address.isLoopbackAddress();
	}

	/*
	 * 通过 Socket 唯一确定一个 IP 。当有多个网卡的时候，使用这种方式一般都可以得到想要的 IP。
	 * 不要求外网地址 `8.8.8.8` 是可连通的。
	 * @return Optional<Inet4Address>
	 */
	private static Optional<Inet4Address> getIpBySocket() throws SocketException {
		
		try (final DatagramSocket socket = new DatagramSocket()) {
			socket.connect(InetAddress.getByName("8.8.8.8"), 80);
			if (socket.getLocalAddress() instanceof Inet4Address) {
				return Optional.of((Inet4Address) socket.getLocalAddress());
			}
		} catch (UnknownHostException networkInterfaces) {
			throw new RuntimeException(networkInterfaces);
		}
		
		return Optional.empty();
	}

	/*
	 * 获取本地IPv4地址
	 * @return Optional<Inet4Address>
	 */
	public static Optional<Inet4Address> getLocalIp4Address() throws SocketException {
		
		final List<Inet4Address> inet4Addresses = getLocalIp4AddressFromNetworkInterface();
		
		// inet4Addresses.forEach(System.out::println);
		
		if (inet4Addresses.size() != 1) {
			final Optional<Inet4Address> ipBySocketOpt = getIpBySocket();
			if (ipBySocketOpt.isPresent()) {
				return ipBySocketOpt;
			} else {
				return inet4Addresses.isEmpty() ? Optional.empty() : Optional.of(inet4Addresses.get(0));
			}
		}
		
		return Optional.of(inet4Addresses.get(0));
	}

	
	public static void main(String[] args) throws SocketException {

		System.out.println(getLocalIp4Address());
		
	}

}
