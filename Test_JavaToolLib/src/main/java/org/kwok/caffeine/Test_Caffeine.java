package org.kwok.caffeine;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Kwok
 * @date: 2024/9/2
 */
public class Test_Caffeine {

    public static void main(String[] args) throws InterruptedException {

        HashMap<String, Object> dbData = new HashMap<String, Object>() {{
            put("1", "111");
            put("2", "222");
            put("3", "333");
        }};

        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                // .refreshAfterWrite(3, TimeUnit.SECONDS)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {

                    @Override
                    public Object load(String s) throws Exception {
                        System.out.println("> load: " + s);
                        return dbData.get(s);
                    }

                    @Override
                    public @NonNull Map<@NonNull String, @NonNull Object> loadAll(@NonNull Iterable<? extends @NonNull String> keys) throws Exception {
                        System.out.println("> loadAll: " + keys);
                        return dbData;
                    }
                });


        System.out.println(cache.get("1"));
        Thread.sleep(1000);
        System.out.println(cache.get("1"));
        Thread.sleep(2000);
        System.out.println(cache.get("1"));

        System.out.println(cache.getAll(Arrays.asList("1", "2")));

    }

}
