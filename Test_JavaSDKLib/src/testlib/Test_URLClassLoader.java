package testlib;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 使用 java.net.URLClassLoader 获取所有类路径，并遍历。
 * @author Kwok
 */
public class Test_URLClassLoader {

	public static void main(String[] args) throws IOException {

		URL[] classPathArray = ((URLClassLoader) Thread.currentThread().getContextClassLoader()).getURLs();
		
		for (URL url : classPathArray) {
			System.out.println("****** " + url + " ******");
			if (url.getPath().endsWith(".jar")) {
				JarFile jf = new JarFile(url.getPath());
				Enumeration<JarEntry> entries = jf.entries();
				while (entries.hasMoreElements()) {
					JarEntry jarEntry = entries.nextElement();
					if (jarEntry.getName().endsWith(".class")) {
						System.out.println(jarEntry.getName().replaceAll("/", "."));
					}
				}
				jf.close();
			}
		}
	}

}
