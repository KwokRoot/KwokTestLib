package testlib.url;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * JDK 对 URL字符串 编码、解码。
 * @author Kwok
 */
public class Test_URLCodec {

	public static void main(String[] args) throws IOException {
		
		String urlStr = "http://127.0.0.1:8080/subsystems/?subsystem_id=2&user_id=6&city=上海";
		System.err.println(urlStr);
		
		String urlEncodeStr = URLEncoder.encode(urlStr, "utf-8");
		System.out.println(urlEncodeStr);
		String urlDecodeStr = URLDecoder.decode(urlEncodeStr, "utf-8");
		System.out.println(urlDecodeStr);
		
	};
	
}
