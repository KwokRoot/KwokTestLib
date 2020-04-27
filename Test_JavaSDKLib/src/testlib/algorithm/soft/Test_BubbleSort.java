package testlib.algorithm.soft;

import java.util.Arrays;

import testlib.algorithm.DataProvider;

/**
 * 冒泡排序
 * @author Kwok
 */
public class Test_BubbleSort {

	public static void main(String[] args) {
		
		// 1.模拟一批数据
		int[] intArray =  DataProvider.getDataArray();
		System.out.println(Arrays.toString(intArray));
		
		// 2.实现冒泡排序
		for (int i = 1; i < intArray.length; i++) {
			for (int j = 0; j < intArray.length - i; j++) {
				if(intArray[j] > intArray[j + 1]) {
					int temp;
					temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
			System.out.println(String.format("第 %s循环：%s", i , Arrays.toString(intArray)));
		}
		
		System.out.println(Arrays.toString(intArray));
		
	}

}
