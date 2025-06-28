package org.kwok.math;

import com.google.common.math.Quantiles;
import com.google.common.math.Stats;

/**
 * @description: 使用 com.google.guava:guava 进行简单的数学统计计算(计数、求和、最大值、最小值、均值、方差、标准差、中位数、百分位、四分位)。
 * @author: Kwok
 * @date: 2025/6/28
 */
public class Test_Math_Guava {

    public static void main(String[] args) {

        Stats stats = Stats.of(Test_Data.generateTestData());
        System.out.println("计数: " + stats.count());
        System.out.println("求和: " + stats.sum());
        System.out.println("最大值: " + stats.max());
        System.out.println("最小值: " + stats.min());
        System.out.println("均值: " + stats.mean());
        System.out.println("方差: " + stats.sampleVariance());
        System.out.println("标准差: " + stats.sampleStandardDeviation());

        System.out.println("中位数: " + Quantiles.median().compute(Test_Data.generateTestData()));
        System.out.println("百分位: " + Quantiles.percentiles().indexes(50, 90, 99).compute(Test_Data.generateTestData()));
        System.out.println("四分位: " + Quantiles.quartiles().indexes(1, 3, 4).compute(Test_Data.generateTestData()));
        System.out.println("自定义分位: " + Quantiles.scale(10).indexes(1, 3, 10).compute(Test_Data.generateTestData()));

    }

}
