package org.kwok.ntp;

import java.net.InetAddress;
import java.util.Date;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/**
 * <dependency>
 *	 <groupId>commons-net</groupId>
 *	 <artifactId>commons-net</artifactId>
 *	 <version>3.11.1</version>
 * </dependency>
 * 
 * 使用 Apache Commons Net 模拟 NTP 客户端。
 * 
 * @author Kwok
 * 2024-07-06
 */
public class Test_CommonsNet_NTP {

	public static void main(String[] args) throws Exception {

		NTPUDPClient timeClient = new NTPUDPClient();
		InetAddress inetAddress = InetAddress.getByName("ntp.aliyun.com");
		TimeInfo timeInfo = timeClient.getTime(inetAddress);
		timeClient.close();

		System.out.println("NTP From: " + timeInfo.getAddress());
		System.out.println("NTP Time: " + new Date(timeInfo.getReturnTime()));

	}

}
