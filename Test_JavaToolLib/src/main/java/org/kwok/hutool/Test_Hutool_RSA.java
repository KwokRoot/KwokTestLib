package org.kwok.hutool;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

/**
 * @description:
 * @author: Kwok
 * @date: 2024/1/15
 */
public class Test_Hutool_RSA {

    public static void main(String[] args) {

        String PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCLk/36tpCrDtISeZTzjmEDSNy9X5zp0cKFVil0RJvRanvEwhj/4tSFjDWAJsBeF1kYnsfl9qQIg2WjHFyGMQDYhQReA+IlrfxGiYeGHw2Y7y49LP/WMcbHFfiTPp6UV+E7mD3jUcLSPLrKYJm61YnwvjDVi/HaarCxaULtmkOhi7lO0Yhjj0jdn5xerYMr+l2yc1fdFe49icpJytrZBcybs5EZ8Q0HmlBZI/thAIYvB4fzGs86S0W7Wp7afEPTjbQIC/PviNHxWgoX/oSF5P0gZXLq21EOttnd8HLCCXfomTWSrk9PbtRMixaXhwgRVyhggqbV8nDxHHMn12LUGRvAgMBAAECggEAfLBHQDreW0YEcjT2PAcm5+h9r7qcJ8JtNKdFhW0/rvyWy7r7Kmy10SYYGKHz1fCn42LAc35LhgpX4X8bmiFGfccPWbwZhMZ34KMfJ2xkbOQS+0TGsykhbEI1mzgIIeiXCQgaMIJNLe3tXnkfwdxfZS5GfzKqCOKZAH22nAVXkuRj1vkU5M9JU4Kc7p2khY1Wu+iEkQpUrdNwWwHfWT67WYtzz8tuUNCXg7bGqZhkraMOIzmm8MmxgUzA7BuvRbCOGhfO8aX0UmQmFG7o9xsGii3Mws7rNR9liaWXFljZFTI8vExX+VcnWDtahjNjuT9RSi4qsBPql9NFh7Hl/M6IoQKBgQDm5M75d3HyAjU6TCEmv8pPN7Gdye6EEQLLpdlnmpyj+NCaWQ6hjbxX8ZdHp3RSdv5KzrNmo9xd7rqyx2i0eOlZ7bnH392/3i5Sspm7pfSttOd5KgjUqMER1eRrZb2rn30yvgIk9hhdlbxpQ9rGdOo6Zeqqt9i/SCpWZ7sqAtVD5QKBgQCQVgvXWZa67YbSs0MyujPnXoheVK7dALWODpM7fclOrsyXalkYGCu2Gr4eKxVajRtMxi1Rni+gzLBy/T9so9Ysf1LG+HxyYuqOOQ2oDqWCzKi/ufFdCDUl0H+UVh6+pIWhWwP/i51+CNaA1aDeoXlmevQHZdOYv+WdSFA4GyYpwwKBgG0Zmq8IAKBg6LPGOzfrEfZCk7vCKeDfhNmjYUnyJafZLwBvqlkt9tv7PQdPmchJj7jbWKvcK4l6/17wmIoGRAUJLmrCXi6GFo9e8wNW1Hmr7GA1O3z4zFnYHpmctnW849SxMaQzYKn/0cpPlLWHkxHLDIpkWpdvywmO9EJSmmD9AoGAajIVFkZBQ5md2AqzB3C+3Z3NIfKWkd6Ctll89ImRAsZTm5hQowytpJe6iAHU/UHS80Lgdyu3CU1xCbnQ34MQAr9PTTvofFTRFQFfTeYw2rLv+di6gGOYjxD/vUk757Ku61BG+c9keiXQhQwpB4SxCLiwMX03GS0fqQBanV1ET/cCgYBBv7FtQuAhwzECCCb49RrX96oz5uPyLg4OWDcw4hOGUONgYOOqwJ5I/9NUZc3uPA5f9N10WMLDwSqOe/0fUVKz20FiQkvkmkOdqMtW1bgmvf3SgqeS7OkDgoLw8AzYjPuTFMeL8CsljxE1ADd+o9IYJiaHpTN0ERVinwfigl7eTg==";
        String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgi5P9+raQqw7SEnmU845 hA0jcvV+c6dHChVYpdESb0Wp7xMIY/+LUhYw1gCbAXhdZGJ7H5fakCINloxxchjE A2IUEXgPiJa38RomHhh8NmO8uPSz/1jHGxxX4kz6elFfhO5g941HC0jy6ymCZutW J8L4w1Yvx2mqwsWlC7ZpDoYu5TtGIY49I3Z+cXq2DK/pdsnNX3RXuPYnKScra2QX Mm7ORGfENB5pQWSP7YQCGLweH8xrPOktFu1qe2nxD0420CAvz74jR8VoKF/6EheT 9IGVy6ttRDrbZ3fBywgl36Jk1kq5PT27UTIsWl4cIEVcoYIKm1fJw8RxzJ9di1BkbwIDAQAB";

        RSA rsa = new RSA(PRIVATE_KEY, PUBLIC_KEY);

        // 私钥加密、公钥解密
        String encryptStr = rsa.encryptBase64("Kwok@ShangHai", KeyType.PrivateKey);
        System.out.println(encryptStr);
        System.out.println(rsa.decryptStr(encryptStr, KeyType.PublicKey));

        // 公钥加密、私钥解密
        String encryptStr2 = rsa.encryptBase64("Kwok@ShangHai", KeyType.PublicKey);
        System.out.println(encryptStr2);
        System.out.println(rsa.decryptStr(encryptStr2, KeyType.PrivateKey));


        // 私钥签名、公钥验证。！！！注：无 公钥签名、私钥验证。
        Sign sign = SecureUtil.sign(SignAlgorithm.SHA256withRSA, PRIVATE_KEY, null);
        String signStr = Base64.encode(sign.sign("Kwok@ShangHai"));
        System.out.println(signStr);

        Sign sign_verify = SecureUtil.sign(SignAlgorithm.SHA256withRSA, null, PUBLIC_KEY);
        System.out.println(sign_verify.verify("Kwok@ShangHai".getBytes(), Base64.decode(signStr)));

    }

}
