package testlib.radix;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 该练习是对 BigDecimal 类的简单练习。详情请参考 "java.math.BigDecimal" API相关文档。
 * @author Kwok
 * 2022-06-09
 */
public class Test_BigDecimal {

    public static void main(String[] args) {

    	System.out.println("------------------------------ 操作 1 ------------------------------");
        double d = 3.1415926D;
        BigDecimal bigDecimal1 = new BigDecimal(d);
        // 小数实际储存的是扩大N倍的二进制整数(科学计数法)，转化为十进制数据可能会丢失精度。
        System.out.println(bigDecimal1);
        System.out.println(new BigDecimal(0.1)); //注：1/10 会丢失精度
        // 1/2、1/4、1/8 ... 不会丢失精度
        System.out.println(new BigDecimal(0.5));
        System.out.println(new BigDecimal(0.125));


        System.out.println("------------------------------ 操作 2 ------------------------------");
        // 保留2位小数的方式
        bigDecimal1 = bigDecimal1.setScale(2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal1.toString());
        System.out.println(bigDecimal1.doubleValue());


        System.out.println("------------------------------ 操作 3 ------------------------------");
        // 正确的使用 BigDecimal：new BigDecimal(String val)
        BigDecimal bigDecimal2_1 = new BigDecimal("3.1415926");
        BigDecimal bigDecimal2_2 = new BigDecimal(3.1415926); //该方式会丢失精度
        System.out.println(bigDecimal2_1);
        System.out.println(bigDecimal2_2);

        
        System.out.println("------------------------------ 操作 4 ------------------------------");
        // 精确的浮点数除法运算并保留小数点有效位数
        BigDecimal bigDecimal3_1 = new BigDecimal(1048);
        BigDecimal bigDecimal3_2 = bigDecimal3_1.divide(new BigDecimal(1024), 3, RoundingMode.HALF_UP);
        System.out.println(bigDecimal3_2);


    }


}
