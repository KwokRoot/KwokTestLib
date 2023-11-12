package org.kwok.hutool;

import java.io.ByteArrayInputStream;

import javax.crypto.spec.IvParameterSpec;

import cn.hutool.core.util.HexUtil;
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
		
		
		// SHA1哈希加密(cn.hutool.crypto.SecureUtil)
		// 相应 Linux 命令：echo -n "/h0z+ZzM" | sha1sum  | tr -d '-'
		System.out.println(SecureUtil.sha1("/h0z+ZzM"));
		
		
		// 双SHA1哈希加密(cn.hutool.crypto.SecureUtil)
		// 相应 Linux 命令：echo -n "/h0z+ZzM" | sha1sum  | tr -d '-'|xxd -r -p|sha1sum | tr -d '-'
		System.out.println(SecureUtil.sha1(new ByteArrayInputStream(HexUtil.decodeHex(SecureUtil.sha1("/h0z+ZzM")))));
		
		
	}

}
