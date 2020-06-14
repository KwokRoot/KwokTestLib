package testlib.clone.deepclone;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * 该练习是 使用序列化实现 深度克隆对象 的练习。
 * 
 * 克隆对象的类需要：
 * 1、克隆对象的类 以及 其属性引用类 都需要实现 java.io.Serializable 接口 。
 * 2、使用序列化重新实现 Object 类中的 clone() 方法。
 * 
 * 注：1、克隆后返回的是一个新对象，而不是一个引用对象。2、克隆对象与用 new 操作符返回的新对象的区别就是这个克隆对象已经包含了原对象的一些信息，而不是对象的初始信息。 
 * 该练习 能够实现 深克隆。
 * @author Kwok
 */
public class Test_DeepClone {

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

		C1 c11 = new C1();
		c11.setName("001");
		c11.setAge(111);
		
		List<String> list=new ArrayList<String>();
		list.add("hobby1");
		list.add("hobby2");
		c11.setHobby(list);
		
		C2 cb=new C2();
		cb.setId(123);
		c11.setCb(cb);
		
		try {
			System.out.println("--------------------------------- 操作 1 ------------------------------------");
			C1 c12=(C1) c11.clone();  // c12 是克隆对象。 
			C1 c13=c11;  // c13 是引用对象。
			
			
			System.out.println(c11.hashCode());
			System.out.println(c12.hashCode());
			System.out.println(c13.hashCode());
			
			System.out.println(c11);
			System.out.println(c12);
			System.out.println(c13);
			// 运行结果：c11 与 c12 的 hashCode()不相同，属性值相同。c11 与 c13 的 hashCode()相同，属性值相同。
			/*
			1769608838  (不唯一)
			1314712963  (不唯一)
			1769608838  (不唯一)
			C1 [name=001, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			C1 [name=001, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			C1 [name=001, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			*/
			
			System.out.println("--------------------------------- 操作 2 ------------------------------------");
			
			c11.setName("006");  //只对 C11 的一个基本类型的属性值进行修改。
			
			System.out.println(c11.hashCode());
			System.out.println(c12.hashCode());
			System.out.println(c13.hashCode());
			
			System.out.println(c11);
			System.out.println(c12);
			System.out.println(c13);
			
			// 运行结果： c11 修改属性后 c11 的 hashCode() 与 原 c11 的 hashCode() 相同，属性值 不相同。引用对象 c13 的属性值也变化。
			
			/*
			1769608838  (不唯一)
			1314712963  (不唯一)
			1769608838  (不唯一)
			C1 [name=006, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			C1 [name=001, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			C1 [name=006, age=111, hobby=[hobby1, hobby2], cb=C2 [id=123]]
			*/
			
			System.out.println("--------------------------------- 操作 3 ------------------------------------");
			
			/* 注意：当属性类型不是基本的数据类型时，克隆出来的属性还是引用类型！！！即：浅克隆！！！ */
			
			list.add("hobby3");  // 设置 c11 的复杂类型的属性值属性值,c12、c13 属性值都会改变！
			
			System.out.println(c11.getHobby().hashCode());
			System.out.println(c12.getHobby().hashCode());
			System.out.println(c13.getHobby().hashCode());
			
		
			System.out.println(c11.getHobby());
			System.out.println(c12.getHobby());
			System.out.println(c13.getHobby());
			
			System.out.println("--------------------------------- 操作 4 ------------------------------------");
			
			cb.setId(321);  // 设置 c11 的复杂类型的属性值,c12、c13 属性值都会改变！
			
			System.out.println(c11.getCb().hashCode());
			System.out.println(c12.getCb().hashCode());
			System.out.println(c13.getCb().hashCode());
			
		
			System.out.println(c11.getCb());
			System.out.println(c12.getCb());
			System.out.println(c13.getCb());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
