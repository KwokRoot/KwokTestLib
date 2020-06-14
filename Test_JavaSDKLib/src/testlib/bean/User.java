package testlib.bean;

/**
 * 重写了 toString()、equals(Object obj)的方法。
 * @author Kwok
 */
public class User {
	
	private String no;
	private String name;
	private String age;
	
	public User() {}
	
	public User(String no, String name, String age) {
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
	
	/*
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	*/
}
