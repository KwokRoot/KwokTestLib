package testlib.jmx.mbean;

/*
 * 首先定义一个MBean接口，接口的命名规范为以具体的实现类为前缀（这个规范很重要）。
 */
public interface HelloMBean {

	public String getName();

	public void setName(String name);

	public Integer getAge();

	public void setAge(Integer age);

	public void helloWorld();

	public void helloWorld(String str);

}
