package testlib.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 该练习是利用 Socket 发送 Http 请求的练习。
 * @author Kwok
 */
public class Test_SocketRequest {

	public static void main(String[] args) throws IOException, Exception {
		
		sendGet("www.w3school.com.cn", "/example/jquery/demo_test.asp", null);
		System.out.println("------------------------------------------------------------");
		sendPost("www.w3school.com.cn", "/example/jquery/demo_test_post.asp", "name=Kwok&city=CN");
		
	}
	
	
	public static void sendGet(String host, String path, String paramString) throws Exception	{ 
		
		Socket socket=new Socket(host, 80);
		
		OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
		BufferedWriter bw = new BufferedWriter(osw);
		  
		bw.write("GET " + path + "?" + paramString + " HTTP/1.1\r\n");
		bw.write("Host: " + host + "\r\n");
		bw.write("\r\n");
		bw.flush();
		
		socket.shutdownOutput(); //禁用此套接字的输出流。必须使用！！！否则 SocketServer 一致等待输入流结束，而抛超时异常。
		
		Thread.sleep(50);
		
		/*		
		InputStream is = socket.getInputStream();
		byte[] b=new byte[is.available()];
		is.read(b);
		
		System.out.println(new String(b));
		*/
		
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
	    }
		
		socket.close();
		
    }
	
	
	public static void sendPost(String host, String path, String paramString) throws Exception  {  
        
        Socket socket= new Socket(host, 80);
        socket.setSoTimeout(3000);
        
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), "utf-8");
        BufferedWriter bw = new BufferedWriter(osw);
        
        bw.write("POST " + path + " HTTP/1.1\r\n");
        bw.write("Host: " + host + "\r\n");
        bw.write("Content-Length: " + paramString.length() + "\r\n");
        bw.write("Content-Type: application/x-www-form-urlencoded; charset=UTF-8\r\n");
        bw.write("\r\n");
        bw.write(paramString);
        bw.flush();
        
        socket.shutdownOutput(); //禁用此套接字的输出流。必须使用！！！否则 SocketServer 一致等待输入流结束，而抛超时异常。
        
        Thread.sleep(50);
        
        /*
        InputStream is=socket.getInputStream();
        byte[] bytes=new byte[is.available()];
        is.read(bytes);
        System.out.println(new String(bytes));
        */
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line;
		while ((line = in.readLine()) != null) {
			System.out.println(line);
	    }
        
        socket.close();
		
    }
}
