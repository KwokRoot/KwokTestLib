package testlib.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  java.util.List.toArray(T[] a) 使用。
 */
public class Test_Arrays {

    public static void main(String[] args) {
        
    	String[] strArr = new String[]{"59", "60", "100"};
        List<Double> doubleList = Arrays.stream(strArr).map(Double::valueOf).sorted().collect(Collectors.toList());
        System.out.println(doubleList);
        
        System.out.println("------------------------------ 操作 1 ------------------------------");    
        // 如果提供的数组长度小于列表长度，会创建新的数组储存列表。
        Double[] d1 = new Double[0];
        Double[] d2 = doubleList.toArray(d1);
        System.out.println(d1.hashCode() == d2.hashCode());  // false
        System.out.println(Arrays.toString(d2));

        System.out.println("------------------------------ 操作 2 ------------------------------");
        // 如果提供的数组长度等于、大于列表长度，则使用给定的数组，数组中大于列表的位置的值不覆盖。
        Double[] d3 = new Double[10];
        d3[1] = 3.6;
        d3[9] = 6.9;
        Double[] d4 = doubleList.toArray(d3);
        System.out.println(d3.hashCode() == d4.hashCode());  // true
        System.out.println(Arrays.toString(d4));

        System.out.println("------------------------------ 操作 3 ------------------------------");
        // 推荐：提供的数组长度 等于 列表长度
        Double[] d5 = doubleList.toArray(new Double[doubleList.size()]);
        System.out.println(Arrays.toString(d5));

    }

}
