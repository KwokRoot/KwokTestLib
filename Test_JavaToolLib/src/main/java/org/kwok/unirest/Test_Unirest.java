package org.kwok.unirest;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

/**
 * @description: Unirest 是一个 Java 简单而轻量的 HTTP 客户端工具类库。
 * @author: Kwok
 * @date: 2026/1/11
 */
public class Test_Unirest {

    public static void main(String[] args) {

        // 默认配置
        Unirest.config().defaultBaseUrl("https://baidu.com")
                .connectTimeout(5000)
                .socketTimeout(60000);

        System.out.println("********* GET *********");
        HttpResponse<String> response1 = Unirest.get("https://qq.com/robots.txt").asString();
        System.out.println(response1.getBody());

        System.out.println("********* POST *********");
        HttpResponse<JsonNode> response2 = Unirest.post("https://ai.gitee.com/v1/app/auth/token")
                .header("accept", "application/json")
                .field("appid", "")
                .field("param", "value")
                .asJson();

        System.out.println(response2.getBody().toPrettyString());

    }

}
