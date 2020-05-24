package testlib.enumclass;

/**
 * 该练习是对 枚举类 的简单练习。
 * @author Kwok
 */
public class TestEnum {

	public static void main(String[] args) {
		
		//所有的枚举类，默认继承 java.lang.Enum 该类，name() 为 Enum 类的方法。
		System.out.println(EnumClass.Update.name());
		
		System.out.println(EnumClass.Update.getName());
		System.out.println(EnumClass.Update.getCode());
		
		//错误使用！不要给枚举类中的属性值提供 Set 方法修改，否则会造成属性不一致。 
		EnumClass.Update.setName("*更新2");
		System.out.println(EnumClass.Update.getName());
		
	}

}
