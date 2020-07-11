package org.kwok.json;

import java.lang.reflect.Field;

import org.json.JSONObject;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

/**
 * 测试 JSON 工具类序列化、反序列化是否依赖实体的 getter、setter 方法。
 * 序列化：Fastjson(私有属性)、Jackson(私有属性)、orgjson 依赖于实体的 getter 方法，Gson 依赖于实体的属性。 
 * 反序列化：Fastjson、Jackson 依赖于实体的 setter 方法，Gson 依赖于实体的属性。
 * @author Kwok
 */
public class Test_JSONSerializeProcess {

	public static void main(String[] args) throws Exception {
		
		Model model = new Model();
		model.no = 110L;
		model.setName("kwok");
		model.setAge(18);
		Field field = model.getClass().getDeclaredField("id");
		field.setAccessible(true);
		field.set(model, Long.valueOf(1));
		System.out.println(model);
		//结果：Model [id=1, no=110, name=kwok, age=18]
		
		String jsonStr = "{\"age\":18,\"id\":1,\"no\":110,\"name\":\"kwok\"}";
		
		
		System.out.println("-------------------- Fastjson --------------------");
		System.out.println(JSON.toJSONString(model));
		//结果：{"abc":"abc","age":18,"name":"kwok","no":110}
		System.out.println(JSON.parseObject(jsonStr, Model.class));
		//结果：Model [id=null, no=110, name=kwok, age=18]
		
		
		System.out.println("-------------------- Gson --------------------");
		Gson gson = new Gson();
		System.out.println(gson.toJson(model));
		//结果：{"id":1,"no":110,"name":"kwok","age":18}
		
		System.out.println(gson.fromJson(jsonStr, Model.class));
		//结果：Model [id=1, no=110, name=kwok, age=18]
		
		
		System.out.println("-------------------- orgjson --------------------");
		JSONObject jsonObject = new JSONObject(model);
		System.out.println(jsonObject.toString());
		//结果：{"abc":"abc","name":"kwok","age":18}
		
		JSONObject jsonObject2 = new JSONObject(jsonStr);
		System.out.println(jsonObject2.get("id"));
		//结果：1
		
		System.out.println("-------------------- Jackson --------------------");
		ObjectMapper objectMapper = new ObjectMapper();	
		
		System.out.println(objectMapper.writeValueAsString(model));
		//结果：{"no":110,"name":"kwok","age":18,"abc":"abc"}
		
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println(objectMapper.readValue(jsonStr, Model.class));
		//结果：Model [id=null, no=110, name=kwok, age=18]
		
	}
	
	
	public static class Model {

		//私有属性，没有 Getter、Setter 方法。
		private Long id;
		//公有属性，没有 Getter、Setter 方法
		public Long no;
		private String name;
		private Integer age;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		
		public String getAbc(){
			return "abc";
		}
		
		@Override
		public String toString() {
			return "Model [id=" + id + ", no=" + no + ", name=" + name + ", age=" + age + "]";
		}
		
	}
}
