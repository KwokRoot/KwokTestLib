package org.kwok.jwt;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.Instant;
import java.util.Base64;
import java.util.Calendar;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


/**
 * @author: Kwok
 * @date: 2024/1/15
 */
public class Test_JWT {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {

        // 生成 JWT，指定token过期时间为 30 秒
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);
        
        String token = JWT.create()
                .withHeader("{\"alg\":\"RS256\",\"typ\":\"JWT\"}")
                .withClaim("sub", "1234567890")
                .withClaim("name", "John Doe")
                .withClaim("admin", true)
                .withExpiresAt(calendar.getTime())
                .withIssuedAt(Instant.ofEpochSecond(1516239022L))
                .sign(Algorithm.HMAC256("admin"));
        
        System.out.println(token);


        // 解析 JWT
        String jwtStr = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImV4cCI6MTcwNTY3NDgzNSwiaWF0IjoxNTE2MjM5MDIyfQ.zpA3xesHMzoUv5zMSC3yofCcFb9nRIxFHKnODZcUhUk";

        DecodedJWT jwt = JWT.decode(jwtStr);

        String encodeHeader = jwt.getHeader();
        String decodeHeader = new String(Base64.getDecoder().decode(jwt.getHeader()));
        System.out.println(encodeHeader);
        System.out.println(decodeHeader);

        String encodePayload = jwt.getPayload();
        String decodePayload = new String(Base64.getDecoder().decode(jwt.getPayload()));
        System.out.println(encodePayload);
        System.out.println(decodePayload);

        System.out.println(jwt.getSignature());
        
        
        // 验证 JWT
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("admin")).build();
        
        // TokenExpiredException
        // DecodedJWT decodedJWT = jwtVerifier.verify(jwtStr);
        
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        System.out.println(decodedJWT.getClaims());
        
    }

}
