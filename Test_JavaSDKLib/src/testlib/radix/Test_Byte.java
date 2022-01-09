package testlib.radix;

/**
 * 该练习是对字节与数值相互转换的操作。
 * @author Kwok
 */
public class Test_Byte {

    public static void main(String[] args) {

        /* 1.获取字节 有符号数值 与 无符号数值 */
        byte b = (byte)-88;
        //byte b = Byte.valueOf("-88", 10);

        System.out.println(Byte.valueOf(b));
        // System.out.println(b);
        //输出：-88

        System.out.println(Byte.toUnsignedInt(b));
        // System.out.println(b & 0xff);
        //输出：168

        /* 2.查看数值的二进制储存值 */
        System.out.println(Integer.toBinaryString(-88));
        //输出：11111111111111111111111110101000

        System.out.println(Integer.toBinaryString(168));
        //输出：10101000

        /*
         * 3.分析：
         * ① 4字节32位整形数值 转 字节后仅剩1字节8位有效位，即 10101000
         * ② 无符号取值时，即 128*1 + 64*0 + 32*1 + 16*0 + 8*1 + 4*0 + 2*0 + 1*0 = 168
         * ③ 有符号位取值，即左边第一位 1 为符号位，标识为负值，剩余的部分需要 -1 ，再按位取反(求补码的反向步骤)，结果为 -1011000，值为：-88。
         *
         */

    }
}
