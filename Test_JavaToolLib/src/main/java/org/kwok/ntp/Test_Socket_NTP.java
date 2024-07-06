package org.kwok.ntp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.Date;

/**
 * 使用 Socket 模拟 NTP 客户端
 * 
 * @author Kwok 2024-07-06
 */
public class Test_Socket_NTP {

	private static final int NTP_PACKET_SIZE = 48;
	private static final int NTP_PORT = 123;
	private static final int NTP_PACKET_HEADER = 0x23;

	public static void main(String[] args) throws Exception {

		DatagramSocket socket = new DatagramSocket();
		InetAddress inetAddress = InetAddress.getByName("ntp.aliyun.com");

		// 构建 NTP 请求数据包
		byte[] buffer = new byte[NTP_PACKET_SIZE];
		ByteBuffer bb = ByteBuffer.wrap(buffer);
		bb.clear();
		bb.position(0);
		bb.limit(NTP_PACKET_SIZE);

		bb.put((byte) NTP_PACKET_HEADER);
		bb.put((byte) 0x00);
		bb.put((byte) 0x00);
		bb.put((byte) 0x00);

		// 发送请求包
		DatagramPacket request = new DatagramPacket(buffer, buffer.length, inetAddress, NTP_PORT);
		socket.send(request);

		// 接收响应包
		byte[] receiveBuffer = new byte[NTP_PACKET_SIZE];
		DatagramPacket response = new DatagramPacket(receiveBuffer, receiveBuffer.length);
		socket.receive(response);

		// 解析响应包
		bb = ByteBuffer.wrap(receiveBuffer);
		bb.rewind();
		long timeStamp = Integer.toUnsignedLong(bb.getInt(40)) - 2208988800L; // 1970-1900 seconds

		System.out.println("NTP From: " + inetAddress.getHostAddress());
		System.out.println("NTP Time: " + new Date(timeStamp * 1000));

		socket.close();

	}

}
