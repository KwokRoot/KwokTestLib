package org.kwok.hutool;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;

/**
 * Hutool 生成图片验证码
 * @author Kwok
 * 2025-03-08
 */
public class Test_Hutool_Captcha {

	public static void main(String[] args) {
		
		GifCaptcha captcha = CaptchaUtil.createGifCaptcha(200, 40, 4);
		System.out.println(captcha.getCode());
		captcha.write("D:\\temp\\1.gif");
		
		
		LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 40, 4, 2);
		System.out.println(lineCaptcha.getCode());
		lineCaptcha.write("D:\\temp\\2.png");
		
		
		ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(200, 40, 4, 2);
		System.out.println(shearCaptcha.getCode());
		shearCaptcha.write("D:\\temp\\3.png");
		
	}
	
}
