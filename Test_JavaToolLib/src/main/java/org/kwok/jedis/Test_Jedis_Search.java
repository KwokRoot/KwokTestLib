package org.kwok.jedis;

import org.json.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.UnifiedJedis;
import redis.clients.jedis.json.Path2;
import redis.clients.jedis.search.Document;
import redis.clients.jedis.search.FTCreateParams;
import redis.clients.jedis.search.FTSearchParams;
import redis.clients.jedis.search.IndexDataType;
import redis.clients.jedis.search.SearchResult;
import redis.clients.jedis.search.aggr.AggregationBuilder;
import redis.clients.jedis.search.aggr.AggregationResult;
import redis.clients.jedis.search.aggr.Reducers;
import redis.clients.jedis.search.aggr.Row;
import redis.clients.jedis.search.schemafields.NumericField;
import redis.clients.jedis.search.schemafields.SchemaField;
import redis.clients.jedis.search.schemafields.TextField;

import java.net.URI;
import java.util.List;

/**
 * @description:
 * @author: Kwok
 * @date: 2025/4/18
 */
public class Test_Jedis_Search {

    public static void main(String[] args) {

        UnifiedJedis jedis = new UnifiedJedis("redis://:123456@192.168.199.91:16379/0");

        JSONObject user1 = new JSONObject()
                .put("name", "Paul John")
                .put("email", "paul.john@example.com")
                .put("age", 42)
                .put("city", "London");

        JSONObject user2 = new JSONObject()
                .put("name", "Eden Zamir")
                .put("email", "eden.zamir@example.com")
                .put("age", 29)
                .put("city", "Tel Aviv");

        JSONObject user3 = new JSONObject()
                .put("name", "Paul Zamir")
                .put("email", "paul.zamir@example.com")
                .put("age", 35)
                .put("city", "Tel Aviv");

        SchemaField[] schema = {
                TextField.of("$.name").as("name"),
                TextField.of("$.city").as("city"),
                NumericField.of("$.age").as("age")
        };

        // 删除索引
        jedis.ftDropIndex("idx:users");

        // 删除索引及文档
        // jedis.ftDropIndexDD("idx:users");

        String createResult = jedis.ftCreate("idx:users",
                FTCreateParams.createParams()
                        .on(IndexDataType.JSON)
                        .addPrefix("user:"),
                schema
        );

        System.out.println(createResult); // >>> OK

        String user1Set = jedis.jsonSet("user:1", new Path2("$"), user1);
        System.out.println(user1Set);
        String user2Set = jedis.jsonSet("user:2", new Path2("$"), user2);
        String user3Set = jedis.jsonSet("user:3", new Path2("$"), user3);


        SearchResult findPaulResult = jedis.ftSearch("idx:users",
                "Paul @age:[30 40]"
        );

        System.out.println(findPaulResult.getTotalResults()); // >>> 1

        List<Document> paulDocs = findPaulResult.getDocuments();

        for (Document doc : paulDocs) {
            System.out.println(doc.getId());
        }
        // >>> user:3

        SearchResult citiesResult = jedis.ftSearch("idx:users",
                "Paul",
                FTSearchParams.searchParams()
                        .returnFields("city")
        );

        System.out.println(citiesResult.getTotalResults()); // >>> 2

        for (Document doc : citiesResult.getDocuments()) {
            System.out.println(doc.getId());
        }
        // >>> user:1
        // >>> user:3

        AggregationResult aggResult = jedis.ftAggregate("idx:users",
                new AggregationBuilder("*")
                        .groupBy("@city", Reducers.count().as("count"))
        );

        System.out.println(aggResult.getTotalResults()); // >>> 2

        for (Row cityRow : aggResult.getRows()) {
            System.out.println(String.format(
                    "%s - %d",
                    cityRow.getString("city"), cityRow.getLong("count"))
            );
        }
        // >>> London - 1
        // >>> Tel Aviv - 2

        jedis.close();
    }

}
