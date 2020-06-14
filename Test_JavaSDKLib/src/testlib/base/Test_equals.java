package testlib.base;

import java.util.Objects;


/**
 * 关于 equals() 方法 与 "==" 理解的练习。
 * @author Kwok
 */
public class Test_equals {

	public static void main(String[] args) {
		
		EqualsInnerUser user3 = new EqualsInnerUser("003", "333", "333");
		EqualsInnerUser user6 = new EqualsInnerUser("003", "333", "333");
		
		//@see testlib.bean.User#equals
		System.out.println(Objects.equals(user3, user6)); //重写了 User.equals(Object obj)方法。
		//结果：true
		
		System.out.println(user3.hashCode() == user6.hashCode()); //重写了 User.hashCode()方法。
		//结果：true
		
		System.out.println(user3 == user6); //对于复合数据类型，"==" 比较的是对象的内存地址。
		//结果：false
	}
}


class EqualsInnerUser extends Object {
	
	private String no;
	private String name;
	private String age;
	
	public EqualsInnerUser() {}
	
	public EqualsInnerUser(String no, String name, String age) {
		this.no = no;
		this.name = name;
		this.age = age;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", age=" + age + "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
	
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
}
