package testlib;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class Test_Unsafe {

	int i = 0;
	
	public static void main(String[] args) throws Exception {
		
		//注：该方式直接获取异常，只有通过根加载器的类才能通过这个方法获取。
		//Unsafe unSafe = Unsafe.getUnsafe();
	
		Unsafe unsafe = UnsafeAccessor.getUnsafe();
		
		//获取字段的偏移地址
		long i_offset = unsafe.objectFieldOffset(Test_Unsafe.class.getDeclaredField("i"));
		
		Test_Unsafe test_Unsafe = new Test_Unsafe();
		System.out.println(unsafe.compareAndSwapInt(test_Unsafe, i_offset, 0, 2));
		
		System.out.println(test_Unsafe.i);
        
	}

	/**
	 * 获取 Unsafe 实例
	 * @author Kwok
	 * 2023-07-09
	 */
	public static class UnsafeAccessor {
		
	    private static Unsafe unsafe;
	    
	    static {
	        try {
	            Field unsafeFile = Unsafe.class.getDeclaredField("theUnsafe");
	            unsafeFile.setAccessible(true);
	            //因为是静态属性
	            unsafe = (Unsafe) unsafeFile.get(null);
	        }catch (Exception e){}
	    }
	    
	    public static Unsafe getUnsafe(){
	        return unsafe;
	    }
	}
	
}
