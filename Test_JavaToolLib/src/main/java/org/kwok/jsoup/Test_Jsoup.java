package org.kwok.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Test_Jsoup {

	public static void main(String[] args) throws Exception {

		Document doc = Jsoup.connect("http://time.tianqi.com").get();

		// 对 `XPath` 支持
		Elements elements = doc.selectXpath("/html/body/div[3]/div[3]/div[2]/div[1]/span");
		System.out.println(elements.get(0).text());
		
		
	}

}
