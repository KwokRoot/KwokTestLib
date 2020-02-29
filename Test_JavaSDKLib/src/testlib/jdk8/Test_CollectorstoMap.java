package testlib.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @Description: Collectors.toMap(...) 方法的使用。
 * @date: 2020年1月23日
 * @author Kwok
 */
public class Test_CollectorstoMap {
	
	
	public static void main(String[] args) {
		
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("hello1", 18, "student"));
		personList.add(new Person("hello2", 19, "student"));
		personList.add(new Person("hello3", 22, "teacher"));
		personList.add(new Person("hello6", 16, "student"));
		personList.add(new Person("world1", 16, "student"));
		personList.add(new Person("world2", 16, "student"));
		
		
		/*
		Collectors.toMap(Function<? super T, ? extends K> keyMapper, 
				Function<? super T, ? extends U> valueMapper)
		 */
		// toMap 两个参数的方法，遇到 Key 冲突抛异常处理。
		// 由于以 age 作为 Key，有 age 相同的，会出现 Key 冲突
		try{
			Map<Integer, String> age_name_map = personList.stream().collect(Collectors.toMap((Person x) -> x.getAge(), y -> y.getName()));
			System.out.println(age_name_map);
		}catch (Exception e) {
			System.err.println("出现异常：" + e.getMessage());
			// e.printStackTrace();
		}
		
		//结果：出现异常：Duplicate key hello6
		
		
		/*
		Collectors.toMap(Function<? super T, ? extends K> keyMapper,
				Function<? super T, ? extends U> valueMapper,
				BinaryOperator<U> mergeFunction,
				Supplier<M> mapSupplier)
		*/
		//第三个参数 BinaryOperator方法 自定义遇到 Key 冲突时，怎么解决 BinaryOperator 方法的两个参数：参数1：已存在 Key 的 Value 值，参数2为：该 Key 的 Value 新值。
		Map<Integer, String> age_name_map2 = personList.stream().collect(Collectors.toMap((Person x) -> x.getAge(), y -> y.getName(), (x1, x2) -> {return x1.concat(",").concat(x2);}, TreeMap::new));
		
		System.out.println(age_name_map2);
		
		//结果：{16=hello6,world1,world2, 18=hello1, 19=hello2, 22=hello3}
	}
	
	
	
	public static class Person {
		
		private String name;
		private Integer age;
		private String work;
		
		public Person(String name, Integer age, String work) {
			super();
			this.name = name;
			this.age = age;
			this.work = work;
		}
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
		public String getWork() {
			return work;
		}
		public void setWork(String work) {
			this.work = work;
		}
		
	}
	
	
}
