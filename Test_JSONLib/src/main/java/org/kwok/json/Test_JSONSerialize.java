package org.kwok.json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.kwok.json.model.Person;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

/**
 * 测试 Fastjson、Gson、orgjson、Jackson 序列化及反序列化。
 * 测试  JSON 工具类反序列化的默认行为。
 * @author Kwok
 */
public class Test_JSONSerialize {

	public static void main(String[] args) {
		
		String jsonStr = null;
		try {
			jsonStr = IOUtils.toString(Thread.currentThread().getContextClassLoader().getResource("test.json"), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);
		
		Person person = new Person();
		person.setId(1L);
		person.setName("test1");
		person.setAge(18);
		person.setBirth(new Date());
		person.setPhone("123456");
		person.setNote("备注");
		
		System.out.println("-------------------- Fastjson --------------------");
		
		System.out.println(JSON.toJSON(person));
		System.out.println(JSON.parseObject(jsonStr, Person.class));
		/*
		 * Fastjson 总结：
		 * 反序列化：多字段少字段默认都能正常运行，能直接处理时间戳及时间字符串。
		 */
		
		
		System.out.println("-------------------- Gson --------------------");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(person));
		// System.out.println(gson.fromJson(jsonStr, Person.class)); //解析时间出问题
		Gson gson2 = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(json.getAsLong());
			}}).create();
		
		System.out.println(gson2.fromJson(jsonStr, Person.class));
		/*
		 * Gson 总结：
		 * 反序列化：多字段少字段默认都能正常运行，字段区分大小写，时间类型需要自定义处理。
		 */
		
		
		System.out.println("-------------------- orgjson --------------------");
		
		JSONObject jsonObject = new JSONObject(person);
		
		System.out.println(jsonObject.toString(2));
		
		//获取 JSONObject 字段名数组
		System.out.println(Arrays.toString(JSONObject.getNames(jsonObject)));
		
		//获取属性值
		Map<String, Object> map = new HashMap<String, Object>();
		Stream.of(JSONObject.getNames(jsonObject)).forEach(x -> map.put(x, jsonObject.get(x)));
		System.out.println(map);
		/*
		 * orgjson 总结：
		 * 反序列化：没有提供 JSON 字符串直接解析为 Java 实体类的方法。
		 */
		
		
		System.out.println("-------------------- Jackson --------------------");
		
		ObjectMapper objectMapper = new ObjectMapper();	
		
		try {
			System.out.println(objectMapper.writeValueAsString(person));
		} catch (JsonProcessingException e) {
			System.out.println("Jackson 序列化错误，异常：");
			e.printStackTrace();
		}
	
		try {
			//objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			System.out.println(objectMapper.readValue(jsonStr, Person.class));
		} catch (IOException e) {
			System.out.println("Jackson 反序列化错误，异常：");
			e.printStackTrace();
		}
		/*
		 * Jackson 总结：
		 * 反序列化：区分大小写，默认实体缺少的字段会抛异常。
		 */
		
	}
}
