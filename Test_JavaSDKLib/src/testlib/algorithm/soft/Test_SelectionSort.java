package testlib.algorithm.soft;

import java.util.Arrays;

import testlib.algorithm.DataProvider;

/**
 * 选择排序
 * @author Kwok
 */
public class Test_SelectionSort {

	public static void main(String[] args) {

		// 1.模拟一批数据
		int[] intArray = DataProvider.getDataArray();
		System.out.println(Arrays.toString(intArray));

		// 2.实现选择排序
		for (int i = 0; i < intArray.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[min] > intArray[j]) {
					int temp = intArray[min];
					intArray[min] = intArray[j];
					intArray[j] = temp;
				}
			}
			System.out.println(String.format("第 %s循环：%s", i, Arrays.toString(intArray)));
		}
		
		System.out.println(Arrays.toString(intArray));
	
	}

}
