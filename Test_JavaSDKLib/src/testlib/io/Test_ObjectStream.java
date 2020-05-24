package testlib.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 该练习是对 java.io.ObjectInputStream 、 java.io.ObjectOutputStream 类的简单运用的练习。
 * 写出的对象类必须实现 java.io.Serializable 接口。
 * @author Kwok
 */
public class Test_ObjectStream {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		String obj = new String("Hello World. 你好！");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(obj);  // obj 对象类必须实现 java.io.Serializable 接口。
		
		// System.out.println(baos.toString()); // 由于写入 ObjectOutputStream 时会有标识位，直接输出会出现乱码。

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println(ois.readObject());
		
	}
}
