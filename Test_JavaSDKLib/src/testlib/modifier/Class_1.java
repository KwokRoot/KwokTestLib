package testlib.modifier;

/*
 * 区别：
 * （1）public：可以被所有其他类所访问。
 * （2）protected：自身，子类及同一个包中类可以访问。
 * （3）default（默认）：同一包中的类可以访问，声明时没有加修饰符，认为是friendly。
 * （4）private：只能被自己访问和修改。
 */
public class Class_1 {

	public String a = "String-A";
	protected String b = "String-B";
	String c = "String-C";
	private String d = "String-D";
	
	public static void main(String[] args) {
		
		System.out.println(new Class_1().a);
		
		System.out.println(new Class_1().b);
		
		System.out.println(new Class_1().c);
		
		System.out.println(new Class_1().d);
	}
}
