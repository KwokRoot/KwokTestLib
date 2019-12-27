package org.kwok.netty;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.commons.io.IOUtils;

public class Test_SocketServer {

	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(8080);
		
		/*
		InetAddress address = InetAddress.getByName("127.0.0.1");
		//System.out.println(address.getHostName());
		InetSocketAddress socketAddress = new InetSocketAddress(address, 9200);
		serverSocket.bind(socketAddress);
		*/
		
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println(IOUtils.toString(socket.getInputStream(), "UTF-8"));
			
			StringBuilder sb = new StringBuilder();
			sb.append("HTTP/1.1 200 OK\r\n"); //响应头
			sb.append("Content-Type: application/json; charset=utf-8\r\n"); //头信息
			sb.append("\r\n"); //这个空行是来分隔响应头与响应体
			sb.append("{\"took\": 23, \"timed_out\": false, \"_shards\": {\"total\": 1, \"successful\": 1, \"skipped\": 0, \"failed\": 0 }, \"hits\": {\"total\": {\"value\": 108, \"relation\": \"eq\"}, \"max_score\": 1, \"hits\": [] } }"); //响应体
			IOUtils.write(sb.toString(), socket.getOutputStream(), "UTF-8");
			socket.close();
		}
		
		
	}
	
}
