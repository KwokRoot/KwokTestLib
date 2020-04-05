package testlib.algorithm.soft;

import java.util.Arrays;

import testlib.algorithm.DataProvider;

/**
 * 插入排序
 * @author Kwok
 */
public class Test_InsertSort {

	public static void main(String[] args) {
		
		// 1.模拟一批数据
		int[] intArray = DataProvider.getDataArray();
		System.out.println(Arrays.toString(intArray));

		// 2.实现插入排序
		int n = intArray.length;
		for (int i = 1; i < n; i++) {
			int value = intArray[i];
			int j = 0;// 插入的位置
			for (j = i - 1; j >= 0; j--) {
				if (intArray[j] > value) {
					intArray[j + 1] = intArray[j];// 移动数据
				} else {
					break;
				}
			}
			intArray[j + 1] = value; // 插入数据
		}
		
		System.out.println(Arrays.toString(intArray));
	
	}

}
