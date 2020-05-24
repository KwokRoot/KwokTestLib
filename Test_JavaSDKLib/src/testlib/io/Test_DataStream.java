package testlib.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * 该练习是对 java.io.DataInputStream 、 java.io.DataOutputStream 类的简单运用的练习。
 * 必须按写出的顺序读取数据，否则读入的数据不对！！！
 * @author Kwok
 */
public class Test_DataStream {

	public static void main(String[] args) throws IOException {

		String str = new String("Hello World. 你好！");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeUTF(str);
		dos.writeInt(123);
		dos.writeDouble(6.66);

		System.out.println(baos.toString());  // 由于写入 DataOutputStream 时会有标识位，直接输出会出现乱码。

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		DataInputStream dis = new DataInputStream(bais);
		System.out.println(dis.readUTF());  // 必须按写出的顺序读取数据，否则读入的数据不对！！！
		System.out.println(dis.readInt());  // 必须按写出的顺序读取数据，否则读入的数据不对！！！
		System.out.println(dis.readDouble());  // 必须按写出的顺序读取数据，否则读入的数据不对！！！

	}

}
