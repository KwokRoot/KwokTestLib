package org.kwok.htmlcleaner;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

import cn.hutool.http.HttpUtil;

public class Test_HtmlCleaner {

	public static void main(String[] args) throws Exception {
		
		String respStr = HttpUtil.get("http://time.tianqi.com");
		TagNode tagNode = new HtmlCleaner().clean(respStr);
		
		// 对 `XPath` 支持
		// 注：此处 `XPath` 语法以 `/body` 开头，非 `/html` 开头。
		Object[] objArr = tagNode.evaluateXPath("/body/div[3]/div[3]/div[2]/div[1]/span");
		System.out.println(((TagNode)objArr[0]).getText());
		
		
	}
	
}
