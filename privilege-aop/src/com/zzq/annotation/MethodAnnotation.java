package com.zzq.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Ŀ���࣬�����ĸ�����ע��
@Target(ElementType.METHOD)
//ʲôʹ������
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodAnnotation {
	
	public String name() default "";
	
}
