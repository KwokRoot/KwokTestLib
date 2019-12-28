package testlib;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * 该练习是 java.awt.Desktop 类使用的练习。
 * Desktop 类支持的操作包括： 
 * 1.启动用户默认浏览器来显示指定的 URI； 
 * 2.启动带有可选 mailto URI 的用户默认邮件客户端； 
 * 3.启动已注册的应用程序，以打开、编辑或打印指定的文件。
 * 注：此类提供与这些操作对应的方法。这些方法查找在当前平台上注册的关联应用程序，并启动该应用程序来处理 URI 或文件。如果没有关联应用程序或关联应用程序无法启动，则抛出异常。 
 * @author Kwok
 */
public class Test_Desktop {

	public static void main(String[] args) throws IOException, URISyntaxException {

		Desktop desktop = Desktop.getDesktop();
		
		desktop.browse(new URI("https://www.baidu.com"));
		
		//desktop.mail(new URI("mailto:123456789@qq.com"));
		
		//desktop.edit(new File("d:\\123.jpg"));
		
		//desktop.open(new File("d:\\123.txt"));
		//desktop.edit(new File("d:\\123.txt"));
		//desktop.print(new File("d:\\123.txt"));
		
	}

}
