package testlib.url;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

/**
 * Java HttpsURLConnection 中使用不被信任的自签名证书。
 * 
 * @author Kwok
 */
public class Test_HttpsURLConnection {

	public static void main(String[] args) throws Exception {
		
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		
		//初始化 keystore
		keyStore.load(null);
		
		String certAlias = "sac-net-cn";
		//先从浏览器中导出证书：Firefix 浏览器 导出 `.pem`格式，Google 浏览器导出 `.cer`格式。 导入格式为：X.509标准的 二进制 或 Base64 编码 证书。
		keyStore.setCertificateEntry(certAlias, certificateFactory.generateCertificate(new FileInputStream("F:\\opt\\sac-net-cn.pem")));
		//keyStore.setCertificateEntry(certAlias, certificateFactory.generateCertificate(new FileInputStream("F:\\opt\\sac-net-cn.cer")));
		
		TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustManagerFactory.init(keyStore);
		
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
			
		//URL 创建 Https 连接
		URL url = new URL("https://www.sac.net.cn/cyry/kspt/kstz/index.html");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		//从 SSLContext 中获取 SSLSocketFactory
		connection.setSSLSocketFactory(sslContext.getSocketFactory());
		// 设置连接方式：GET
		connection.setRequestMethod("GET");
		// 设置连接主机服务器的超时时间：5000 毫秒
		connection.setConnectTimeout(5000);
		// 设置读取远程返回的数据时间：60000 毫秒
		connection.setReadTimeout(60000);
		// 发送请求
		connection.connect();
		// 通过connection连接，获取输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		
		StringBuffer sb = new StringBuffer();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}

}
