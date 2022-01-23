package org.kwok.htmlcleaner;

import java.util.List;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import cn.hutool.http.HttpUtil;

/**
 * Java 中有 Jsoup、HtmlCleaner 进行 HTML 文档的解析。
 * Jsoup 对 css 选择器支持较好；
 * HtmlCleaner 对 xpath 支持较好；
 * 都支持层层遍历标签获取目标标签。
 * 
 * @author Kwok
 * 2022-01-23
 */
public class Test_HtmlCleaner {

	public static void main(String[] args) throws Exception {
		
		String respStr = HttpUtil.get("http://time.tianqi.com");
		TagNode tagNode = new HtmlCleaner().clean(respStr);
		
		// 1.通过 `XPath` 获取到目标标签。
		// 注：此处 `XPath` 语法以 `/body` 开头，非 `/html` 开头。
		Object[] obj1 = tagNode.evaluateXPath("/body/div[3]/div[3]/div[2]/div[1]/span");
		System.out.println(((TagNode)obj1[0]).getText());
		
		
		//2.通过 `XPath` 直接获取到目标标签内文本信息。
		Object[] obj2 = tagNode.evaluateXPath("/body/div[3]/div[3]/div[2]/div[1]/span/text()");
		System.out.println(obj2[0]);
		
		
		//3.通过层层遍历标签获取到目标标签。
		List<? extends TagNode> tagNodeList3 = tagNode.getElementListByAttValue("class", "time_date", true, true);
		System.out.println(tagNodeList3.get(0).getChildTagList().get(2).getText());
		
	}
	
}
