package testlib.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段注解
 * @author Kwok
 */
@Documented   
@Retention(RetentionPolicy.RUNTIME)   
@Target(ElementType.FIELD)
public @interface B {
	
	String value() default "KwokB";
	
}
