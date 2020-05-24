package testlib.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

/**
 * 类注解
 * @author Kwok
 */
@Documented   
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.TYPE)
public @interface A {
	
	/**
	 * 如果只有一个成员变量，最好将参数名称设为value，赋值时不用制定名称而可以直接赋值 
	 */
	String value() default "KwokA";
	
	/**
	 * 成员变量的只能使用基本类型(byte、short、int、char、long、double、float、boolean 和 String、Enum、Class、annotations 以及该类型的 数组）
	 */
	String[] value1() default {"KwokA1", "KwokA2"};
	
	
	Class<?>[] value2() default {UseAnno.class};
	
}
