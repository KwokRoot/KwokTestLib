package org.kwok.grok;

import java.util.Map;

import io.krakens.grok.api.Grok;
import io.krakens.grok.api.GrokCompiler;
import io.krakens.grok.api.Match;

public class Test_Grok {

	public static void main(String[] args) {
		
		/* Create a new grokCompiler instance */
		GrokCompiler grokCompiler = GrokCompiler.newInstance();
		grokCompiler.registerDefaultPatterns();

		/* Grok pattern to compile, here httpd logs */
		final Grok grok = grokCompiler.compile("%{COMBINEDAPACHELOG}");

		/* Line of log to match */
		String log = "112.169.19.192 - - [06/Mar/2013:01:36:30 +0900] \"GET / HTTP/1.1\" 200 44346 \"-\" \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) AppleWebKit/537.22 (KHTML, like Gecko) Chrome/25.0.1364.152 Safari/537.22\"";

		Match gm = grok.match(log);

		/* Get the map with matches */
		final Map<String, Object> capture = gm.capture();
		
		System.out.println(capture);
		
	}
	
}
