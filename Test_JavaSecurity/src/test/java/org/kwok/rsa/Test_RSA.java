package org.kwok.rsa;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * RSA 加解密
 * @author Kwok
 * 2021-06-06
 */
public class Test_RSA {

	public static String rsaPrivateKeyStr = "";
	public static String rsaPublicKeyStr = "";
	
	public static void main(String[] args) throws Exception {
		
		//需要加入 BC 加密提供商，可以直接支持 PKCS#1密钥格式。
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		
		GenerateRSAKey();
		System.out.println("Private Key:" + Base64.encodeBase64String(LoadRSAPrivateKey().getEncoded()));
		System.out.println("Public Key:" + Base64.encodeBase64String(LoadRSAPublicKey().getEncoded()));
		
		//私钥加密，公钥解密
		System.out.println(decode(encrypt("hello", LoadRSAPrivateKey()), LoadRSAPublicKey()));;
		//公钥加密，私钥解密
		System.out.println(decode(encrypt("hello", LoadRSAPublicKey()), LoadRSAPrivateKey()));;
		
	}
	
	/**
	 * 生成一对 RSA 公钥、私钥。
	 */
	public static void GenerateRSAKey() throws Exception{
		
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
		
		rsaPublicKeyStr = Base64.encodeBase64String(rsaPublicKey.getEncoded());
		System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
		
		rsaPrivateKeyStr = Base64.encodeBase64String(rsaPrivateKey.getEncoded());
		System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
		
	}
	
	/**
	 * 从外部加载 RSA 私钥。
	 */
	public static RSAPrivateKey LoadRSAPrivateKey() throws Exception{
	
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		KeySpec ks = new PKCS8EncodedKeySpec(Base64.decodeBase64(rsaPrivateKeyStr));
		RSAPrivateKey privateKey = (RSAPrivateKey)keyFactory.generatePrivate(ks);
		return privateKey;
		
	}
	
	/**
	 * 从外部加载 RSA 公钥。
	 */
	public static RSAPublicKey LoadRSAPublicKey() throws Exception{
		
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		KeySpec ks = new X509EncodedKeySpec(Base64.decodeBase64(rsaPublicKeyStr));
		RSAPublicKey publicKey = (RSAPublicKey)keyFactory.generatePublic(ks);
		return publicKey;
		
	}
	
	/**
	 * 加密
	 */
	public static byte[] encrypt(String testStr, Key key) throws Exception{
		
		Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		rsa.init(Cipher.ENCRYPT_MODE, key); 
		byte[] miwen = rsa.doFinal(testStr.getBytes());
		return miwen;
	}
	
	/**
	 * 解密
	 */
	public static String decode(byte[] miwen, Key key) throws Exception{
		
		Cipher rsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		rsa.init(Cipher.DECRYPT_MODE, key); 
		byte[] utf8 = rsa.doFinal(miwen); 
		return new String(utf8,"UTF-8");
	}
	
}
