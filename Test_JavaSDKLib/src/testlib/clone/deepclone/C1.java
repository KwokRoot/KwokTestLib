package testlib.clone.deepclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class C1 implements Serializable{

	private static final long serialVersionUID = 1L;
	
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
		
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);  // 从流里读出来
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (ois.readObject());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		return "C1 [name=" + name + ", age=" + age + ", hobby=" + hobby + ", cb=" + cb + "]";
	}
	
}
