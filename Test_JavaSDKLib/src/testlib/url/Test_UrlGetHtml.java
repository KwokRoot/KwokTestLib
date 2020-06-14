package testlib.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 该练习是利用 URL 类发送 HTTP 请求，并把请到的 数据流 转化为 字符串 的练习。
 * @author Kwok
 */
public class Test_UrlGetHtml {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://www.w3school.com.cn/example/jquery/demo_ajax_json.js");

		HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();
		httpconn.setRequestMethod("GET");

		InputStream is = httpconn.getInputStream();

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		StringBuffer html = new StringBuffer();

		String temp;
		while ((temp = br.readLine()) != null) {
			html.append(temp).append("\n");
		}
		
		br.close();
		isr.close();
		is.close();
		System.out.println(html);
		
	}
}