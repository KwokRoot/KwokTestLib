package testlib.jmx.mbean;

/* 
 * 该类名称必须与实现的接口的前缀保持一致（即MBean前面的名称）。
 */
public class Hello implements HelloMBean {

	private String name;

	private Integer age = 18;

	public String getName() {
		System.out.println("getName:" + name);
		return name;
	}

	public void setName(String name) {
		System.out.println("setName:" + name);
		this.name = name;
	}

	public Integer getAge() {
		System.out.println("getAge:" + age);
		return age;
	}

	public void setAge(Integer age) {
		System.out.println("setAge:" + age);
		this.age = age;
	}

	public void helloWorld() {
		System.out.println("helloWorld()");
	}

	public void helloWorld(String str) {
		System.out.println("helloWorld(String str):" + str);
	}

}