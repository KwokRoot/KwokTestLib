package testlib.base;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 关于 hashCode() 方法理解的练习。
 * 如果没重写对象类的 hashCode() 方法，则直接调用本地 Object 的 native hashCode()方法。
 * @author Kwok
 */
public class Test_HashCode {

	public static void main(String[] args) throws IOException {
		
		System.out.println("*** 属性值修改前 ***");
		
		HashCodeInnerClass a = new HashCodeInnerClass();
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		
		a.setList(list);
		System.out.println(a.getList()); //结果：[1, 2, 3]
		System.out.println(a.hashCode()); //结果：1829164700
		
		System.out.println("*** 属性值修改后 ***");
		
		list.add("6");
		System.out.println(a.getList()); //结果：[1, 2, 3, 6]
		System.out.println(a.hashCode()); //结果：1829164700
		
	}
	
}

class HashCodeInnerClass {
	
	private List<String> list;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
	/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		return result;
	}
	*/
	
}
