package org.kwok.math;

import cn.hutool.core.util.StrUtil;

import java.util.IntSummaryStatistics;

/**
 * @description: 使用 JDK 进行简单的数学统计计算(计数、求和、最大值、最小值、均值)。
 * @author: Kwok
 * @date: 2025/6/28
 */
public class Test_Math_JDK {

    public static void main(String[] args) {

        // 数值类型统计类：IntSummaryStatistics、LongSummaryStatistics、DoubleSummaryStatistics
        IntSummaryStatistics intSummaryStatistics = new IntSummaryStatistics();

        Test_Data.generateTestData().forEach(x -> {
            intSummaryStatistics.accept(x);
        });

        System.out.println("计数: " + intSummaryStatistics.getCount());
        System.out.println("求和: " + intSummaryStatistics.getSum());
        System.out.println("最大值: " + intSummaryStatistics.getMax());
        System.out.println("最小值: " + intSummaryStatistics.getMin());
        System.out.println("均值: " + intSummaryStatistics.getAverage());

        System.out.println(StrUtil.format("{} 单个统计指标使用 stream 流 {}", StrUtil.repeat("*", 18), StrUtil.repeat("*", 18)));

        System.out.println("计数: " + Test_Data.generateTestData().stream().mapToInt(Integer::valueOf).count());
        System.out.println("求和: " + Test_Data.generateTestData().stream().mapToInt(Integer::valueOf).sum());
        System.out.println("最大值: " + Test_Data.generateTestData().stream().mapToInt(Integer::valueOf).max().orElse(0));
        System.out.println("最小值: " + Test_Data.generateTestData().stream().mapToInt(Integer::valueOf).min().orElse(0));
        System.out.println("均值: " + Test_Data.generateTestData().stream().mapToInt(Integer::valueOf).average().orElse(0));

        // stream流 转换为 IntSummaryStatistics
        // IntSummaryStatistics intSummaryStatistics = Test_Data.generateTestData().stream().collect(Collectors.summarizingInt(Integer::valueOf));

    }

}
