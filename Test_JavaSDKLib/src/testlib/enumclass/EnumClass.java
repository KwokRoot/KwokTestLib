package testlib.enumclass;

/**
 * 枚举类
 * @author Kwok
 */
public enum  EnumClass {
	
	Create("增加", 1), Retrieve("查询", 2), Update("更新", 3), Delete("删除", 4);
    
	// 成员变量
    private String name;
    private int code;
	
    // 构造方法，注意：构造方法不能为public，因为enum并不可以被实例化
    private EnumClass(String name, int code) {
		this.name = name;
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public int getCode() {
		return code;
	}

	/*
	 * 错误使用！不要给枚举类中的属性值提供 Set 方法修改，否则会造成属性不一致。 
	 */
	@Deprecated
	public void setName(String name) {
		this.name = name;
	}
	
}
