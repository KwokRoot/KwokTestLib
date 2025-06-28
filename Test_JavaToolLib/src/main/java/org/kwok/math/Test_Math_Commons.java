package org.kwok.math;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

/**
 * @description: 使用 org.apache.commons:commons-math3 进行简单的数学统计计算(计数、求和、最大值、最小值、均值、方差、标准差、中位数、百分位)。
 * @author: Kwok
 * @date: 2025/6/28
 */
public class Test_Math_Commons {

    public static void main(String[] args) {

        DescriptiveStatistics stats = new DescriptiveStatistics();
        Test_Data.generateTestData().forEach(x -> {
            stats.addValue(x);
        });

        System.out.println("计数: " + stats.getN());
        System.out.println("求和: " + stats.getSum());
        System.out.println("最大值: " + stats.getMax());
        System.out.println("最小值: " + stats.getMin());
        System.out.println("均值: " + stats.getMean());
        System.out.println("方差: " + stats.getVariance());
        System.out.println("标准差: " + stats.getStandardDeviation());

        System.out.println("中位数: " + stats.getPercentile(50));
        System.out.println("百分位: " + stats.getPercentile(99));

    }

}
