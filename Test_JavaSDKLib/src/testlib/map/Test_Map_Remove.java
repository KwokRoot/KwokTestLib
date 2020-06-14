package testlib.map;

import java.util.HashMap;
import java.util.Map;

import testlib.bean.User;

/**
 * 该练习是对 Map 的 containsKey(Object key)、containsValue(Object value)、remove(Object key)方法的练习。 
 * @author Kwok
 */
public class Test_Map_Remove {

	public static void main(String[] args) {
		
		Map<String, User> userMap = new HashMap<String, User>();
		User user1 = new User("001", "111", "111");
		User user2 = new User("002", "222", "222");
		User user3 = new User("003", "333", "333");
		User user6 = new User("003", "333", "333");
		userMap.put("001", user1);
		userMap.put("002", user2);
		userMap.put("003", user3);
		
		System.out.println(userMap.containsKey(user6.getNo()));	//true。

		//@see testlib.bean.User#equals
		System.out.println(userMap.containsValue(user6));	//true。只有重写 User.equals(Object obj)方法才能起效。
		
		
		System.out.println(userMap.size()); //3
		System.out.println(userMap.remove(user6.getNo()));	//V remove(Object key)  
		System.out.println(userMap.size()); //2
		
	}
}
