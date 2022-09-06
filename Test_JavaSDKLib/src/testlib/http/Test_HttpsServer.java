package testlib.http;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.security.KeyStore;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpsServer;

/**
 * Java 创建简单的 Https Server。
 * com.sun.net.httpserver.HttpsServer(Since: JDK 1.6)
 * @date: 2022年9月6日
 * @author Kwok
 */
public class Test_HttpsServer {

	public static void main(String[] args) throws Exception {

		//keytool 生成密钥：keytool -genkey -keystore "keystore" -alias myKey -keyalg RSA -validity 365 。
		char[] passphrase = "123456".toCharArray();
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream("keystore"), passphrase);

		KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
		kmf.init(ks, passphrase);

		TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
		tmf.init(ks);

		SSLContext ssl = SSLContext.getInstance("TLS");
		ssl.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

		HttpsServer server = HttpsServer.create(new InetSocketAddress(8000), 0);
		server.setHttpsConfigurator(new HttpsConfigurator(ssl));

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
