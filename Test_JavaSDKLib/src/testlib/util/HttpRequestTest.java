package testlib.util;

import java.io.File;
import java.util.UUID;


/**
 * 对 testlib.util.HttpRequest 使用示例。
 * @author Kwok
 * 2022-12-31
 */
public class HttpRequestTest {

	public static void main(String[] args) throws Exception {
		
		// 请求网页
		HttpRequest http = HttpRequest.get("https://repo1.maven.org/maven2/com/rnkrsoft/bopomofo4j/bopomofo4j/maven-metadata.xml")
                .connectTimeout(20000)
                .readTimeout(15000)
                .useCaches(false)//不允许缓存
                .contentType("application/octet-stream", "UTF-8");

		System.out.println(http.body("UTF-8"));
		
		
		// 下载文件
		String GROUP_ID = "com.rnkrsoft.bopomofo4j";
	    String ARTIFACT_ID = "bopomofo4j";
	    String MAVEN_CENTER = "https://repo1.maven.org/maven2";
		String jarUrl = fetchLastReleaseVersionUrl(MAVEN_CENTER, GROUP_ID, ARTIFACT_ID);
		
		HttpRequest http2 = HttpRequest.get(jarUrl)
                .connectTimeout(20000)
                .readTimeout(15000)
                .useCaches(false)//不允许缓存
                .contentType("application/octet-stream", "UTF-8");
        File jarFile = new File("D:\\opt", "bopomofo4j-" + UUID.randomUUID().toString() + ".jar");
        if (!jarFile.getParentFile().exists()) {
            jarFile.getParentFile().mkdirs();
        }
        http2.receive(jarFile);
        if (!http2.ok()) {
            //发生异常
        	System.err.println("下载文件失败");
        }else {
        	System.out.println("下载文件成功");
        }
		
	}
	
	
	/**
	 * 获取 Maven 中央仓库 jar 包最终版本。
     * @param mavenCenter 中央仓库地址 https://repo1.maven.org/maven2
     * @return
     */
    static String fetchLastReleaseVersionUrl(String mavenCenter, final String groupId, final String artifactId) {
        mavenCenter = mavenCenter == null ? "https://repo1.maven.org/maven2" : mavenCenter;
        //https://repo1.maven.org/maven2/com/belerweb/pinyin4j/maven-metadata.xml
        String metadataUrl = mavenCenter + "/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/maven-metadata.xml";
        HttpRequest http = HttpRequest.get(metadataUrl)
                .connectTimeout(10 * 1000)
                .readTimeout(8 * 1000)
                .useCaches(false)//不允许缓存
                .contentType("application/octet-stream", "UTF-8");
        if (http.ok()) {
            String xml = http.body();
            if (xml == null || xml.isEmpty()) {
                return null;
            }
            int beginIndex = xml.indexOf("<versioning>");
            int endIndex = xml.indexOf("</versioning>", beginIndex);
            String temp = xml.substring(beginIndex + "<versioning>".length(), endIndex);
            int tsBeginIdx = temp.indexOf("<latest>");
            int tsEndIdx = temp.indexOf("</latest>");
            String latest = temp.substring(tsBeginIdx + "<latest>".length(), tsEndIdx);
            return mavenCenter + "/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/" + latest + "/" + artifactId + "-" + latest + ".jar";
        }
        throw new RuntimeException("[" + groupId + ":" + artifactId + "] is not found!");
    }
	
}
