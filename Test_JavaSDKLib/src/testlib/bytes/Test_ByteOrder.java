package testlib.bytes;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteOrder;


/**
 * 内存存储多字节顺序：小端/大端。
 * 
 * @author Kwok
 * 2024-07-09
 */
public class Test_ByteOrder {

    public static void main(String[] args) {

        Unsafe unsafe = getUnsafe();

        long address = unsafe.allocateMemory(8L);
        
        String byteOrder = "UNKNOWN";
        try {
            unsafe.putLong(address, 0x0102030405060708L);
            byte b_1 = unsafe.getByte(address);

            // System.out.println(b_1);
            // byte b_8 = unsafe.getByte(address + 7);
            // System.out.println(b_8);

            switch (b_1) {
                case 0x01:
                    byteOrder = "BIG_ENDIAN(大端)";
                    break;
                case 0x08:
                    byteOrder = "LITTLE_ENDIAN(小端)";
                    break;
                default:
            }

        } finally {
            unsafe.freeMemory(address);
        }

        System.out.println("内存存储多字节顺序：" + byteOrder);
        
        // JDK API 直接获取，以上是 JAVA SDK(JDK) 底层实现方式。
        System.out.println(ByteOrder.nativeOrder());
    }

    
    
    /**
     * 获取 `Unsafe` 实例
     */
    private static Unsafe getUnsafe() {
        try {
        	Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }

}
