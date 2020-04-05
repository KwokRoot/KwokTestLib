package testlib.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * 提供用于排序的整型数组
 * @author Kwok
 */
public class DataProvider {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(getDataArray(10)));
		
	}

	/**
	 * 生产长度为10的随机数组
	 */
	public static int[] getDataArray() {
		return getDataArray(10);
	}
	
	
	public static int[] getDataArray(int len) {
		int[] intArray = new int[len];
		
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = new Random().nextInt(1000);
		}
		
		return intArray;
	}
	
}
