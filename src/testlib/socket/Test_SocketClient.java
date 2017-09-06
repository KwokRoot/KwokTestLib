package testlib.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 该练习是对 Socket 基本实现的练习。
 * @author Kwok
 */
public class Test_SocketClient {

	public static void main(String[] args) throws Exception {

		//计数器，模拟客户端发送100次请求
		int j = 0;
		
		while (j < 100) {
			
			Socket client = new Socket("127.0.0.1", 8080);
			
			++j;
			System.out.println("------客户端发送第 "+ j +" 次请求------");
			
			//向 SocketServer 发送数据
			OutputStream os = client.getOutputStream();
			os.write("ping".getBytes());
			os.flush();
			
			//为了接收 SocketServer 发送的数据，需要休眠
			Thread.sleep(200);

			//接收 SocketServer 发送数据
			InputStream is = client.getInputStream();
			byte[] bytes = new byte[is.available()];
			is.read(bytes);
			System.out.println(new String(bytes));
			
			client.close();
			
		}
		
	}
	
}
