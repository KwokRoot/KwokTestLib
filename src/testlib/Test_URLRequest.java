package testlib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 * 该练习是使用 java.net.URL 类实现 GET 、 POST 请求的练习。
 * URLConnection.getHeaderField(0) 获取响应的状态信息。
 * URLConnection.getRequestProperties() 获取请求头信息。
 * URLConnection.getHeaderFields() 获取响应头信息。
 * @author Kwok
 */
public class Test_URLRequest {

	public static void main(String[] args) {
		
		System.out.println(Test_URLRequest.getRequest("http://www.w3school.com.cn//example/jquery/demo_test.asp"));
		System.out.println(Test_URLRequest.postRequest("http://www.w3school.com.cn/example/jquery/demo_test_post.asp", "name=Kwok&city=China"));
		
	}
	
	
	// GET 请求
	public static String getRequest(String urlStr) {
		String result = "";
		BufferedReader br = null;
		try {
			URL url = new URL(urlStr);
			// 打开与 URL 之间的新连接。
			URLConnection urlConn = url.openConnection();
			// 设置通用的请求属性。
			urlConn.setRequestProperty("accept", "*/*");
			urlConn.setRequestProperty("connection", "Keep-Alive");
			urlConn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接。
			urlConn.connect();
			// 定义 BufferedReader 来读取 URL 响应的输入流。
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.err.println("发送GET请求出现异常！");
			e.printStackTrace();
		}
		// 使用 finally块 来关闭输入流。
		finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
	// POST 请求
	public static String postRequest(String urlStr, String param) {
		PrintWriter pw = null;
		BufferedReader br = null;
		String result = "";
		try {
			URL urlPath = new URL(urlStr);
			// 打开与 URL 之间的新连接。
			URLConnection urlConn = urlPath.openConnection();
			// 设置通用的请求属性。
			urlConn.setRequestProperty("accept", "*/*");
			urlConn.setRequestProperty("connection", "Keep-Alive");
			urlConn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			
			// 发送 POST 请求，必须设置 doOutput 为 true.
			urlConn.setDoOutput(true); // default is false.
			urlConn.setDoInput(true);  // default is true.
			// 获取 URLConnection 对象对应的输出流。
			pw = new PrintWriter(urlConn.getOutputStream());
			// 发送请求参数。
			pw.print(param);
			// 刷新输出流的缓冲区。
			pw.flush();
						
			// 定义 BufferedReader 来读取 URL 响应的输入流。
			br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.err.println("发送POST请求出现异常！");
			e.printStackTrace();
		}
		// 使用 finally块 来关闭输出流、输入流。
		finally {
			try {
				if (pw != null) {
					pw.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}

}
