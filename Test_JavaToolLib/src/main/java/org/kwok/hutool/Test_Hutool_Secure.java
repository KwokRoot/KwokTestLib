package org.kwok.hutool;

import javax.crypto.spec.IvParameterSpec;

import cn.hutool.crypto.KeyUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.DES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;

/**
 * 
 * @author Kwok
 * 2022-12-02
 */
public class Test_Hutool_Secure {

	public static void main(String[] args) {
		
		System.out.println(MD5.create().digestHex("admin"));
		System.out.println(SecureUtil.md5("admin"));
		
		System.out.println(KeyUtil.generateKey(SymmetricAlgorithm.AES.name(), 256).getEncoded().length);
		
		AES aes = SecureUtil.aes("abcdabcdabcdabcd".getBytes());
		System.out.println(aes.encryptBase64("admin"));
		
		
		// 默认的 DES 加密方式：DES/ECB/PKCS5Padding
		DES des = SecureUtil.des("abcdabcd".getBytes());
		System.out.println(des.encryptBase64("admin"));
		
		
		DES des2 = new DES(Mode.CBC, Padding.PKCS5Padding, "abcdabcd".getBytes());
		des2.setParams(new IvParameterSpec("abcdabcd".getBytes()));
		System.out.println(des2.encryptBase64("admin"));
		
	}

}
