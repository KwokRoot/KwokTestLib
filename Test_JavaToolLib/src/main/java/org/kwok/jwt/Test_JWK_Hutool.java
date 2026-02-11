package org.kwok.jwt;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.KeyUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSigner;
import cn.hutool.jwt.signers.JWTSignerUtil;

import java.math.BigInteger;
import java.security.PublicKey;

/**
 * @author: Kwok
 * @date: 2026/2/11
 */
public class Test_JWK_Hutool {

    public static String publicKeyToPem(PublicKey publicKey) {
        // 标准 X.509 编码公钥字节
        byte[] derBytes = publicKey.getEncoded();

        // Base64 编码
        String base64 = Base64.encode(derBytes);

        // 按 PEM 格式分行（每行 64 字符）
        StringBuilder pem = new StringBuilder();
        pem.append("-----BEGIN PUBLIC KEY-----\n");
        int lineLength = 64;
        for (int i = 0; i < base64.length(); i += lineLength) {
            int end = Math.min(i + lineLength, base64.length());
            pem.append(base64, i, end).append("\n");
        }
        pem.append("-----END PUBLIC KEY-----");

        return pem.toString();
    }


    public static void main(String[] args) {

        String jwksStr = "{\"keys\":[{\"kty\":\"RSA\",\"e\":\"AQAB\",\"kid\":\"1cf92d82-3edc-4935-962b-56e217ad75f8\",\"n\":\"ve-j_z1Srmt2rpWgNia2N65KoF_zTmlNGrrcyExcmBnNaneOK7sm2s4iKNuajdqzpYVDFHCxPoZ3GK20Pu-39GWZauKPPE7HiBIxCjhMJYCV03E9f5JI9krQnq9LoqyoV3Qxy_L01sKp-_w0JIz0QFv4n_Sa1-d6-HgBcaqQc7HqbzLzrBFOxKx1W38ThVapUnSEux-B_yTyxHpwyogY1goMgU9jx8n6lTGG4H9WXfAnGv_9SDvxS4kWceQlcWzv-6N-aG9Kg4e9Ey6LDzBQCz1XR-v4rxBRl-9IPlWQSJnlkJEGEtzt-oSNZ-PzPqZJcncdzi1ir-F2EOjSRGY3aQ\"}]}";

        String jwtStr = "eyJraWQiOiIxY2Y5MmQ4Mi0zZWRjLTQ5MzUtOTYyYi01NmUyMTdhZDc1ZjgiLCJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJkZW1vLWNsaWVudCIsImF1ZCI6ImRlbW8tY2xpZW50IiwibmJmIjoxNzcwNjI3MTk4LCJzY29wZSI6WyJyZWFkIl0sImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6OTAwMCIsImV4cCI6MTc3MDYyODk5OCwiaWF0IjoxNzcwNjI3MTk4LCJqdGkiOiJlYjMzNDUxMC03ZTgyLTRjZjEtYWYwNy1iZGM5OTk4OGFkM2EifQ.VXBA3i2pNBqXixOrUbVSQQf7PEC9BylhyNl0nZPVcu2EQhEgHkczEulo-GnxHMS2ybVJ1tGXb4gxuAOag9_nmYVQhRthvX4pWsOTdncov1-zlSIfrm0JG1-aY6DEGzJGkjdQxy0_m_gdskoRATaadC_9GsRDviDC_kkZPI79EXSQqkkW-MH3rdPwhx6ZhWGyGRxicbsy-7Atl9nebce0og7r6txcT-oky5Mj9JPPD-AW2vQdc79OnzzR4n63ktj95BBTTAgxEBLDTwuMBncoglXI4kiTD6dttwgTf6blPlxmbbnu3EaPE-ZYdZArVRkIo4bLM_StewoShYdLd2FnZA";

        JWT jwt = JWTUtil.parseToken(jwtStr);
        System.out.println("JWT header: " + jwt.getHeaders());
        System.out.println("JWT header: " + jwt.getHeader());
        System.out.println("JWT payload: " + jwt.getPayloads());
        System.out.println("JWT payload: " + jwt.getPayload());
        System.out.println("JWT algorithm: " + jwt.getAlgorithm());
        System.out.println("JWT signer: " + jwt.getSigner());


        /*
         * 根据 jwks 中，`n`, `e` 构建 RSA 公钥：
         * 一个 RSA 公钥由两个整数构成：
         *    n（modulus，模数）：大整数，通常是 2048 位或更长。
         *    e（public exponent，公钥指数）：通常为 65537（即 0x10001），Base64Url 编码后是 "AQAB"
         */
        JSONObject jwks = JSONUtil.parseObj(jwksStr);
        JSONObject jwk = jwks.getJSONArray("keys").getJSONObject(0);
        String nStr = jwk.getStr("n");
        String eStr = jwk.getStr("e");

        BigInteger n = new BigInteger(HexUtil.encodeHexStr(Base64.decode(nStr)), 16);
        BigInteger e = new BigInteger(HexUtil.encodeHexStr(Base64.decode(eStr)), 16);

        // 使用 模数 n、公钥指数 e 生成 RSA 公钥
        PublicKey publicKey = KeyUtil.getRSAPublicKey(n, e);

        System.out.println("\n公钥生成成功！");
        System.out.println("Public Key Algorithm: " + publicKey.getAlgorithm());
        System.out.println("Public Key Format: " + publicKey.getFormat());

        String pem = publicKeyToPem(publicKey);
        // String pem = PemUtil.toPem("PUBLIC KEY", publicKey.getEncoded());
        System.out.println("\nPEM 格式公钥：\n" + pem);

        JWTSigner jwtSigner = JWTSignerUtil.rs256(publicKey);
        System.out.println("\nJWT 签名验证：" + JWTUtil.verify(jwtStr, jwtSigner));

    }

}
