package testlib.bytes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


/**
 * 内存存储多字节顺序：小端/大端 验证。
 * 
 * @author Kwok 2024-07-09
 */
public class Test_ByteBuffer {

	public static void main(String[] args) {

		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		byteBuffer.order(ByteOrder.nativeOrder());

		byteBuffer.putInt(0x01020304);

		System.out.println(byteBuffer.get(0));
		System.out.println(byteBuffer.get(1));
		System.out.println(byteBuffer.get(2));
		System.out.println(byteBuffer.get(3));

	}

}
