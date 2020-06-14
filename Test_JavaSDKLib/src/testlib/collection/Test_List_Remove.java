package testlib.collection;

import java.util.ArrayList;
import java.util.List;

import testlib.bean.User;

/**
 * 该练习是对 List 的 contains(Object o)、remove(int index)、remove(Object o)方法的练习。
 * @author Kwok
 */
public class Test_List_Remove {

	public static void main(String[] args) {
		
		System.out.println("------------------------------ 操作 1:List.remove(XX xx) 方法 ------------------------------");
		/*
		 * E remove(int index)：移除此列表中指定位置上的元素。 
		 * boolean remove(Object o)：移除此列表中首次出现的指定元素（如果存在）。 
		*/
		List<Object> list1 = new ArrayList<Object>();
		list1.add(null);
		list1.add(2);
		list1.add(1);
		list1.add("3");
		System.out.println(list1);	//[null, 2, 1, 3]
		
		System.out.println(list1.remove(2));	//结果：1。移除 index = 2 上的元素即 1。
		System.out.println(list1);	//[null, 2, 3]
		
		System.out.println(list1.remove((Integer)2));	//结果：true。移除值为 2 的元素
		System.out.println(list1);	//[null, 3]
		
		
		System.out.println("------------------------------ 操作 1:List.remove(Object o) 方法移除引用类型 ------------------------------");
		
		List<User> userList = new ArrayList<>();
		User user1 = new User("001", "111", "111");
		User user2 = new User("002", "222", "222");
		User user3 = new User("003", "333", "333");
		User user6 = new User("003", "333", "333");
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		
		
		//@see testlib.bean.User#equals
		System.out.println(userList.contains(user6));	//true。只有重写 User.equals(Object obj)方法才能起效。
		
		System.out.println(userList.size()); // 3
		System.out.println(userList.remove(user6));	//true。只有重写 User.equals(Object obj)方法才能移除和 user6 值相同的 user3。
		System.out.println(userList.size()); // 2
		
	}
}
