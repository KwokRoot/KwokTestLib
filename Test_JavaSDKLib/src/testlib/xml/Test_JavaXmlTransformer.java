package testlib.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * 格式化 XML 字符串，按自定义缩进字符间距进行缩进。
 * 注：元素名(标签)、属性名不能有特殊字符(~!@#$%^&*()+=:[] 等，可以为-_ )，处理时可以先把特定字符替换，处理后再替换回来。
 * @author Kwok
 */
public class Test_JavaXmlTransformer {

	public static String formatXmlStr(String srcXmlStr, Integer indentSize) {

		if(indentSize == null){
			indentSize = 4;
		}
		
		Source xmlInput = new StreamSource(new StringReader(srcXmlStr));
		StringWriter stringWriter = new StringWriter();
		StreamResult xmlOutput = new StreamResult(stringWriter);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		}

		/*
		 * "xml" 方式输出时，是否省略 <?xml version="1.0" encoding="utf-8" standalone="no"?> 头信息。
		 * @author Kwok
		 */
		// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
		
		
		/*
		 * 以 "HTML" 方式进行输出，也可以省略 <?xml version="1.0" encoding="utf-8" standalone="no"?> 头信息。
		 * @author Kwok
		 */
		transformer.setOutputProperty(OutputKeys.METHOD, "html");
		
		/*
		 * 设置换行和缩进
		 * 设置缩进时必须设置 OutputKeys.INDENT 属性值为 "yes"。
		 * @author Kwok
		 */
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 设置换行
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "" + indentSize); // 设置缩进

		transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		transformer.setOutputProperty(OutputKeys.STANDALONE, "no");
		
		try {
			transformer.transform(xmlInput, xmlOutput);
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		return xmlOutput.getWriter().toString();

	}
	
	public static void main(String[] args) {
		
		String xmlStr = "<?xml version=\"1.0\" encoding=\"utf-8\"?><bookstore><book Type=\"必修课\" ISBN=\"7-111-19149-2\"><title>数据结构</title><author>严蔚敏</author><price>30.00</price></book><book Type=\"选修课\" ISBN=\"7-111-19149-1\"><title>计算机操作系统</title><author>殷士勇</author><price>28</price></book></bookstore>";
		System.out.println(formatXmlStr(xmlStr, null));
		
	}
	
}
