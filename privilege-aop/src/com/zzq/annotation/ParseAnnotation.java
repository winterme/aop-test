package com.zzq.annotation;

import java.lang.reflect.Method;

public class ParseAnnotation {

	/**
	 * Target 目标类的class形式 methodName 在客户端调用哪个方法，method 就代表哪个方法
	 * 
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static String getAnnotationValue(Class targetClass, String methodName)
			throws SecurityException, NoSuchMethodException {

		String privilegeAccess = "";

		/**
		 * 获取目标类调用的该方法
		 */
		Method method = targetClass.getMethod(methodName);

		/**
		 * 判断方法上面是否有我们自定义的注解
		 */
		if (method.isAnnotationPresent(MethodAnnotation.class)) {
			//获取注解。并获取注解的值
			MethodAnnotation methodAnnotation = method
					.getAnnotation(MethodAnnotation.class);
			privilegeAccess = methodAnnotation.name();
		}

		return privilegeAccess;

	}

}
