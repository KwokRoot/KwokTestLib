package testlib.radix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Double 保留 3位小数 示例。
 * @author Kwok
 * 2022-06-09
 */
public class Test_Double {

    public static void main(String[] args) {

        double d = 3.1415926D;

        //1.使用 Math.round 转成 long 四舍五入，再转回 double
        double d2 = (double) Math.round(d * 1000) / 1000;
        System.out.println(d2);


        //2.使用 BigDecimal 四舍五入格式化
        BigDecimal bigDecimal = new BigDecimal(d).setScale(3, RoundingMode.HALF_UP);
        System.out.println(bigDecimal.doubleValue());


        //3.使用 String.format() 四舍五入格式化
        System.out.println(String.format("%.3f", d));


        //4.使用 NumberFormat 四舍五入格式化
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(3);
        System.out.println(numberFormat.format(d));


        //5.使用 BigDecimal 进行格式化 (四舍五入)
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(decimalFormat.format(d));

    }

}
