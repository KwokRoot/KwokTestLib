package testlib.base;

import java.util.Comparator;
import java.util.Objects;

/**
 * 自 JDK 7 新增 java.util.Objects 类 提供：
 * 一个空安全（null-safe）的 equals(arg1, arg2) 方法，如果两个参数都为 null 返回 true ，如果只有一个为 null 返回 false ，其他情况则调用 arg1.equals(arg2)。 
 * 一套针对所有原生类型（int、long等）的 compareTo(arg1, arg2) 方法。
 * JDK8 新增 Objects.isNull(obj)、Objects.nonNull(obj) 方法。
 * @author Kwok
 */
public class Test_Objects {

	public static void main(String[] args) {
		
		String nullStr=null;
		try{
			System.out.println(nullStr.equals(null));  // 抛异常。 Objects.equals() 可以解决比较对象为空的情况。
		}catch(NullPointerException e){
			System.out.println("已抛异常！！！");
		}
		
		
		System.out.println(Objects.equals(null,null));
		System.out.println(Objects.deepEquals(null,null));
		
		System.out.println(Objects.equals("123",new String("123")));
		System.out.println(Objects.deepEquals(new String("123"),new String("123")));
		
		System.out.println(Objects.compare(123, 126, new Comparator<Integer>(){
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		}));
		
		System.out.println(Objects.isNull(nullStr));

		System.out.println(Objects.nonNull(nullStr));
		
		System.out.println(Objects.requireNonNull(nullStr, "该对象为 Null"));
	}
}