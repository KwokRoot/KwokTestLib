package org.kwok.jwt;

import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.signers.JWTSignerUtil;

/**
 * @author: Kwok
 * @date: 2024/1/18
 */
public class Test_JWK_PEM {

    public static void main(String[] args) throws Exception {

        String jwtStr = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.eT6Y4Qa68MKdRpDqGt9ieNZqI1sKcu7QDV5yRLOVjEzH2375sH0y6kOzDPWi3Jx1DJIWkcHX-40SoiqukVJZlk3Gekh6b5mXbOW8W5xqN32ReG_g-fqno-ob5eINxy0BXR03Lw9EvbJ6uqzQZnM4-swGSniTBbaJsQM1U_M9DTswUwvmaV5dJCKb0miUfcE00mUaoIC9JMd0pGWio0UGai-nEo6ku6EvWB8stVvK_L74OpNFSJRmaVJoDZQtgXucHJh4Y__Xy54JkDozh6cNE_r36PsY0wYHkpgjtKnh6uwSHar7Nyhe2PRpKc08Ydu7j23VpN2gD9HB7egXEb___w";
        String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgi5P9+raQqw7SEnmU845 hA0jcvV+c6dHChVYpdESb0Wp7xMIY/+LUhYw1gCbAXhdZGJ7H5fakCINloxxchjE A2IUEXgPiJa38RomHhh8NmO8uPSz/1jHGxxX4kz6elFfhO5g941HC0jy6ymCZutW J8L4w1Yvx2mqwsWlC7ZpDoYu5TtGIY49I3Z+cXq2DK/pdsnNX3RXuPYnKScra2QX Mm7ORGfENB5pQWSP7YQCGLweH8xrPOktFu1qe2nxD0420CAvz74jR8VoKF/6EheT 9IGVy6ttRDrbZ3fBywgl36Jk1kq5PT27UTIsWl4cIEVcoYIKm1fJw8RxzJ9di1BkbwIDAQAB";

        RSA rsa = new RSA(null, PUBLIC_KEY);

        System.out.println(JWTUtil.parseToken(jwtStr).getPayload());

        System.out.println(JWTUtil.verify(jwtStr, JWTSignerUtil.rs256(rsa.getPublicKey())));

    }

}
