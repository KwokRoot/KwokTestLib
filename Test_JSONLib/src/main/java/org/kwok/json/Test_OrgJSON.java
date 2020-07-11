package org.kwok.json;

import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.XML;
import org.kwok.json.model.Person;

/**
 * 测试 orgjson 的 XML.class 工具类。
 * @author Kwok
 */
public class Test_OrgJSON {

	public static void main(String[] args) {
		
		String jsonStr = null;
		try {
			jsonStr = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("test.json"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Person person = new Person();
		person.setId(1L);
		person.setName("test1");
		person.setAge(18);
		person.setBirth(new Date());
		person.setPhone("123456");
		person.setNote("备注");
		
		JSONObject jsonObject = new JSONObject(person);
		
		//生成转义 json 字符串
		System.out.println(JSONObject.quote(jsonStr));
		
		//XML 与 JSONObject 互转
		String xml = XML.toString(jsonObject, "root");
		System.out.println(xml);
		System.out.println(XML.toJSONObject(xml));
		
		//生成转义 xml 字符串
		String escapeXML = XML.escape(xml);
		System.out.println(escapeXML);
		System.out.println(XML.unescape(escapeXML));
		
	}
	
}
