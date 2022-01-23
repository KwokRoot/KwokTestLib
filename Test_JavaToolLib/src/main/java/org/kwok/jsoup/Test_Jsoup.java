package org.kwok.jsoup;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Java 中有 Jsoup、HtmlCleaner 进行 HTML 文档的解析。
 * Jsoup 对 css 选择器支持较好；
 * HtmlCleaner 对 xpath 支持较好；
 * 都支持层层遍历标签获取目标标签。
 * 
 * @author Kwok
 * 2022-01-23
 */
public class Test_Jsoup {

	public static void main(String[] args) throws Exception {

		Document doc = Jsoup.connect("http://time.tianqi.com").get();
		
		// 1.通过 `XPath` 获取到目标标签。
		Elements elements1 = doc.selectXpath("/html/body/div[3]/div[3]/div[2]/div[1]/span");
		System.out.println(elements1.get(0).text());
		
		
		//2.通过 `XPath` 直接获取到目标标签内文本信息。
		List<Node> nodeList = doc.selectXpath("/html/body/div[3]/div[3]/div[2]/div[1]/span/text()", Node.class);
		System.out.println(nodeList.get(0));
		
		
		//3.通过层层遍历标签获取到目标标签。
		Elements elements3 = doc.getElementsByClass("time_date");
		System.out.println(elements3.get(0).children().get(2).text());
		
		
		//4.通过 CSS 选择器获取到目标标签。
		Elements elements4 = doc.select(".time_date > span:nth-child(3)");
		System.out.println(elements4.get(0).text());
		
	}

}
