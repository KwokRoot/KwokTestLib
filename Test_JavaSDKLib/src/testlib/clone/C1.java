package testlib.clone;

import java.util.List;

public class C1 implements Cloneable{

	private String name;
	private int age;
	private List<String> hobby;
	private C2 cb;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getHobby() {
		return hobby;
	}
	public void setHobby(List<String> hobby) {
		this.hobby = hobby;
	}
	
	public C2 getCb() {
		return cb;
	}
	public void setCb(C2 cb) {
		this.cb = cb;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	@Override
	public String toString() {
		return "C1 [name=" + name + ", age=" + age + ", hobby=" + hobby + ", cb=" + cb + "]";
	}
	
}
