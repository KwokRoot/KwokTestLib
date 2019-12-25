package testlib.socket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该练习是利用 Socket 响应 Http 请求的练习。
 * @author Kwok
 */
public class Test_SocketResponse {

	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(8080);
		
		/*
		InetAddress address = InetAddress.getByName("127.0.0.1");
		//System.out.println(address.getHostName());
		InetSocketAddress socketAddress = new InetSocketAddress(address, 8080);
		serverSocket.bind(socketAddress);
		*/
		
		while(true){
			Socket socket = serverSocket.accept();
			
			String body = "{\"name\":\"Kwok\",\"age\":18,\"address\":\"中国\"}";
			
			StringBuilder sb = new StringBuilder();
			sb.append("HTTP/1.1 200 OK\r\n"); //响应头
			sb.append("Content-Type: application/json; charset=utf-8\r\n"); //头信息
			sb.append("\r\n"); //这个空行是来分隔响应头与响应体
			sb.append(body); //响应体
			
			OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			
			//该种方式处理 socket.getInputStream() 会阻塞
			/*
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
		    }
			br.close();
			*/
			
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[inputStream.available()];
			inputStream.read(bytes);
			System.out.println(new String(bytes));
			
			osw.close();
			socket.close();
			
		}
		
		//serverSocket.close();
		
	}
	
}
