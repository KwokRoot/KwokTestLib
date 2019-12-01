package org.kwok.json;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

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

public class Test_CompareJSON {

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
		
		System.out.println("-------------------- fastjson --------------------");
		
		System.out.println(JSON.toJSON(person));
		System.out.println(JSON.parseObject(jsonStr, Person.class));
		
		
		
		System.out.println("-------------------- Gson --------------------");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(person));
		// System.out.println(gson.fromJson(jsonStr, Person.class)); 解析时间出问题
		Gson gson2 = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

			public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
					throws JsonParseException {
				return new Date(json.getAsLong());
			}}).create();
		
		System.out.println(gson2.fromJson(jsonStr, Person.class));
		
		
		
		System.out.println("-------------------- orgjson --------------------");
		
		JSONObject jsonObject = new JSONObject(person);
		System.out.println(jsonObject.toString());
		
		System.out.println(JSONObject.wrap(jsonStr));
		
		
		
		System.out.println("-------------------- jackson --------------------");
		
		ObjectMapper objectMapper = new ObjectMapper();	
		
		try {
			System.out.println(objectMapper.writeValueAsString(person));
		} catch (JsonProcessingException e) {
			System.out.println("jackson 序列化错误，异常：");
			e.printStackTrace();
		}
	
		try {
			System.out.println(objectMapper.readValue(jsonStr, Person.class));
		} catch (IOException e) {
			System.out.println("jackson 反序列化错误，异常：");
			e.printStackTrace();
		}
		
	}
}
