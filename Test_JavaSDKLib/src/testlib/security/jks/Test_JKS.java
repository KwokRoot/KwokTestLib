package testlib.security.jks;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;


/**
 * Java KeyStore (JKS) 加密、解密、签名、验签。
 * 
 * 1、生成 keystore
 * keytool -genkeypair -alias testkey -keyalg RSA -validity 36500 -keysize 2048 -keystore testkeystore.jks
 * 2、导出自签公钥证书
 * keytool -export -alias testkey -keystore testkeystore.jks -rfc -file testcert.cer
 * 
 * @author Kwok
 * 2024-10-13
 */
public class Test_JKS {

    public static final String KEY_STORE = "JKS";
    private static final String RSA = "RSA";
    public static final String X509 = "X.509";
    private static final String SHA1WithRSA = "SHA1WithRSA";
    
    private static final int MAX_ENCRYPT_BLOCK = 117;
    // 密钥长度修改为2048位时，报以下错误：Exception in thread "main" javax.crypto.BadPaddingException: Decryption error。
    // 这是由于最大解密长度不正确导致报错，MAX_DECRYPT_BLOCK应等于密钥长度/8（1byte=8bit）。
    // 所以当密钥位数为1024时，最大解密长度应为 128; 当密钥位数为2048时，最大解密长度应为 256.
    private static final int MAX_DECRYPT_BLOCK = 256;

    public static final String storePass = "123456";
    public static final String keyPass = "123456";
    public static final String alias = "testkey";
    public static final String jksFile = "F:\\opt\\JKS\\testkeystore.jks";
    public static final String pubFile = "F:\\opt\\JKS\\testcert.cer";

    
    public static KeyStore getKeyStore() throws KeyStoreException {
    	return KeyStore.getInstance(KEY_STORE);
    }
    
    public static KeyFactory getkeyFactory() throws NoSuchAlgorithmException {
    	return KeyFactory.getInstance(RSA);
    }
    
    
    /**
     * 获取私钥
     */
    public static Key getPrivateKey(String jksFilePath, String keyAlias, String keyPass, String storePass) throws Exception {

    	Key key = null;
        FileInputStream is = null;
		try {
			File jksFile = new File(jksFilePath);
			is = new FileInputStream(jksFile);
			
			KeyStore keyStore = getKeyStore();
			keyStore.load(is, storePass.toCharArray());
			
			PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPass.toCharArray());
			PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
			
			KeyFactory keyFactory = KeyFactory.getInstance(RSA);
			key = keyFactory.generatePrivate(pkcs8KeySpec);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
        return key;
    }
    
    
    /**
     * 获取公钥
     */
    public static Key getPublicKey(String cerFilePath) {
        
    	Key key = null;
        FileInputStream is = null;
        try {
       	 	CertificateFactory certificateFactory = CertificateFactory.getInstance(X509);
       	 	is = new FileInputStream(cerFilePath);
       	 	X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(is);
            PublicKey publicKey = x509Certificate.getPublicKey();
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
            
            KeyFactory keyFactory = KeyFactory.getInstance(RSA);
            key = keyFactory.generatePublic(x509KeySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
        	if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		return key;
    }
    

    /**
     * 加密
     */
    public static byte[] encrypt(Key key, byte[] dataBytes) throws Exception {

        try {
        	
            // 对数据加密
            Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            
            int inputLen = dataBytes.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offSet > 0) {
                if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offSet, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] miwen = out.toByteArray();
            out.close();
            
            return miwen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    

    /**
     * 解密
     */
    public static byte[] decrypt(Key key, byte[] miwen) throws Exception {

        Cipher cipher = Cipher.getInstance(RSA);
        cipher.init(Cipher.DECRYPT_MODE, key);
        
        int inputLen = miwen.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(miwen, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(miwen, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }

   
    /**
     * 签名
     */
    public static byte[] sign(PrivateKey key, byte[] originDataBytes) throws Exception {
        
    	Signature signature = Signature.getInstance(SHA1WithRSA);
        
        signature.initSign(key);
        signature.update(originDataBytes);
        byte[] signDataBytes = signature.sign();
        
        return signDataBytes;
    }

    /**
     * 验签
     */
    public static boolean verifySign(PublicKey publicKey, byte[] originDataBytes, byte[] signDataBytes) throws Exception {
        
    	Signature sign = Signature.getInstance(SHA1WithRSA);
        
    	sign.initVerify(publicKey);
        sign.update(originDataBytes);
        boolean isVerifySign = sign.verify(signDataBytes);
        
        return isVerifySign;
    }

    
    public static void main(String[] args) throws Exception {

    	PrivateKey privateKey = (PrivateKey) getPrivateKey(jksFile, alias, keyPass, storePass);

    	PublicKey publicKey = (PublicKey) getPublicKey(pubFile);
    	
    	
        String originData = "密钥长度修改为2048位时，报以下错误：Exception in thread \"main\" javax.crypto.BadPaddingException: Decryption error。\n" +
                "这是由于最大解密长度不正确导致报错，MAX_DECRYPT_BLOCK应等于密钥长度/8（1byte=8bit），" +
                "所以当密钥位数为1024时，最大解密长度应为 128; 当密钥位数为2048时，最大解密长度应为 256.\n";
       
        /* 私钥加密，公钥解密 */
        System.out.println("私钥加密: ");
        byte[] enData = encrypt(privateKey, originData.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(enData));

        String deData = new String(decrypt(publicKey, enData));
        System.out.println("公钥解密: \n" + deData);
        
        /* 公钥加密，私钥解密 */
        System.out.println("公钥加密: ");
        byte[] enData2 = encrypt(publicKey, originData.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(enData2));

        String deData2 = new String(decrypt(privateKey, enData2));
        System.out.println("私钥解密: \n" + deData2);
        
        /* 私钥签名，公钥验签 */
        byte[] signDataBytes = sign(privateKey, originData.getBytes());
        System.out.println("签名: \n" + Base64.getEncoder().encodeToString(signDataBytes));
        boolean verifySign = verifySign(publicKey, originData.getBytes(), signDataBytes);
        System.out.println("验签: \n" + verifySign);
        
    }

}
