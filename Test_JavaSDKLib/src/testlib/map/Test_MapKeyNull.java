package testlib.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 该练习是测试 Map 键值能否为 Null 的练习。测试结果：都可以为 Null 。 
 * @author Kwok
 */
public class Test_MapKeyNull {

	public static void main(String[] args) {
		
		Map<Object, Object> hm = new HashMap<Object,Object>();
		
		hm.put(null, "123");
		System.out.println(hm.size());
		//结果：1
		System.out.println(hm.get(null));
		//结果：123
		
		System.out.println("-----------------");
		hm.put(null, null);
		
		System.out.println(hm.size());
		//结果：1
		System.out.println(hm.get(null));
		//结果：null
	}
	
}
