package testlib.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 该练习是对 ServerSocket 基本实现的练习。
 * @author Kwok
 */
public class Test_SocketServer {

	public static void main(String[] args) throws Exception {

		@SuppressWarnings("resource")
		ServerSocket server =new ServerSocket(8080);
		
		//计数器
		int i = 0;
		
		while(true){
			
			//侦听并接受到此套接字的连接
			Socket socket =server.accept();
			
			//为了接收 SocketClient 发送的数据，需要休眠
			Thread.sleep(100);
			
			//接收 SocketClient 发送的数据
			InputStream is = socket.getInputStream();
			byte[] bytes=new byte[is.available()];
			is.read(bytes);
			
			//向 SocketClient 发送的数据
			OutputStream os = socket.getOutputStream();
			os.write("pong".getBytes());
			os.flush();
			
			System.out.println("------服务器接收到第 "+ ++i +" 次请求------");
			System.out.println(new String(bytes));
			
		}
	}
	
}
