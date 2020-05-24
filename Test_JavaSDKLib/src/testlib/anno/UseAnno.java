package testlib.anno;

/**
 * 使用自定义注解标识
 * @author Kwok
 */
@A(value="KA", value1={"KA1","KA2"})
public class UseAnno {
	
	@B("KB")
	private String value1="";
	
	@C(value1="KC11", value2="KC12")
	public String mothod1(){
		return "mothod1...";
	}
	
	//@C(value1="KC21", value2="KC22")
	@C
	public void mothod2(){
		
	}
}
