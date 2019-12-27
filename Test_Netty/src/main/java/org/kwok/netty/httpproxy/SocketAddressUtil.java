package org.kwok.netty.httpproxy;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SocketAddressUtil {

	private static final String ip_pattern = "(\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}):(\\d*)";
	private static final Pattern pattern = Pattern.compile(ip_pattern);
	
	public static String getIp(SocketAddress socketAddress){
		
		//System.out.println(socketAddress.toString());
		
		
        Matcher matcher = pattern.matcher(socketAddress.toString());
        if(matcher.find()){
        	return matcher.group(1);
        }
        
		return null;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getIp(InetSocketAddress.createUnresolved("127.9.0.1", 90)));
	}
	
}
