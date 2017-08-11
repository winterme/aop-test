package com.zzq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//目标类，放在哪个上面注解
@Target(ElementType.METHOD)
//什么使用运用
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
	
	public String name() default "";
	
}
