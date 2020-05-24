package testlib.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法注解
 * @author Kwok
 */
@Documented   
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.METHOD)
public @interface C {
	
	String value1() default "KwokC1";
	
    String value2() default "KwokC2";
    
}
