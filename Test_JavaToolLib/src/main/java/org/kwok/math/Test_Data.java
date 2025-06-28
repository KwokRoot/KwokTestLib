package org.kwok.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 模拟统计数据
 * @author: Kwok
 * @date: 2025/6/28
 */
public class Test_Data {

    public static List<Integer> generateTestData(){
        List<Integer> testData = new ArrayList<>();
        testData.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        return testData;
    }

}
