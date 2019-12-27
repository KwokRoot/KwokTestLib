package org.kwok.netty.web.controller;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class CommonController {

	
	public static String dispatch(String url){
		
		String result = null;
		
		if("/index".equalsIgnoreCase(url)){
			try {
				result = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResourceAsStream(URLMapping.index), "UTF-8");
			} catch (Exception e) {
				result = "ERROR:500<br>" + ExceptionUtils.getStackTrace(e);
			}
		}else{
			result = "404";
		}
		
		return result;
	}
	
}
