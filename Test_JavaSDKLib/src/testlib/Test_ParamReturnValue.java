package testlib;

import java.util.Arrays;

/**
 * 该练习是模拟函数的参数作为函数的返回值的练习。
 * @author Kwok
 */
public class Test_ParamReturnValue {

	public static void main(String[] args) {
		
		StringBuffer targetStr = new StringBuffer();
		copyStr("Hello World.", targetStr);
		System.out.println(targetStr);
		
	}
	
	
	public static void copyStr(String src, StringBuffer target){
		//target=new StringBuffer(src); //注：该方式错误，不能创建新的对象！！！并且 target 类型应该是值可变的。
		target.delete(0, target.length()).append(src);
	}
	
	
	//复制数组
	/*
	public static void main(String[] args) {
		
		Object[] srcObj = { 1, 2, 3, 'a', 'b', 'c', "abc123"};
		
		Object[] targetObj = new Object[srcObj.length]; 
		
		copyArr(srcObj, targetObj);
		
		System.out.println(Arrays.toString(targetObj));
		
	}
	
	public static void copyArr(Object[] src, Object[] target){
		
		for (int i = 0; i < src.length; i++) {
			target[i]=src[i];
		}
		
	}
	*/
}
