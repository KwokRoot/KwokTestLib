package testlib.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * Java 创建简单的 Http Server。
 * com.sun.net.httpserver.HttpServer(Since: JDK 1.6)
 * @date: 2022年9月6日
 * @author Kwok
 */
public class Test_HttpServer {

	public static void main(String[] args) throws Exception {
		
		HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
		
		server.createContext("/", new HttpHandler() {
			@Override
			public void handle(HttpExchange httpExchange) throws IOException {
				
				System.out.println(httpExchange.getRemoteAddress());
				
				String resp = "hello world.";
				httpExchange.sendResponseHeaders(200, resp.length());
				OutputStream os = httpExchange.getResponseBody();
				os.write(resp.getBytes());
				os.close();
			}
		});
		
		
		server.createContext("/date", new HttpHandler() {
			@Override
			public void handle(HttpExchange httpExchange) throws IOException {
				
				System.out.println(httpExchange.getRequestURI());
				
				String resp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
				httpExchange.sendResponseHeaders(200, resp.length());
				OutputStream os = httpExchange.getResponseBody();
				os.write(resp.getBytes());
				os.close();
			}
		});
		
		server.setExecutor(Executors.newCachedThreadPool());
		server.start();
		
		System.out.println("Server Start: " + server.getAddress().getHostString() + ":" + server.getAddress().getPort());
		
		// 停止，停止延迟时间(秒)，停止过程不接受新的请求。
		// server.stop(5);
		// System.out.println("Server Stop...");
		
	}

}
