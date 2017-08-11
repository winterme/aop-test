package com.zzq.annotation;

import java.lang.reflect.Method;

public class ParseAnnotation {

	/**
	 * Target Ŀ�����class��ʽ methodName �ڿͻ��˵����ĸ�������method �ʹ����ĸ�����
	 * 
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static String getAnnotationValue(Class targetClass, String methodName)
			throws SecurityException, NoSuchMethodException {

		String privilegeAccess = "";

		/**
		 * ��ȡĿ������õĸ÷���
		 */
		Method method = targetClass.getMethod(methodName);

		/**
		 * �жϷ��������Ƿ��������Զ����ע��
		 */
		if (method.isAnnotationPresent(MethodAnnotation.class)) {
			//��ȡע�⡣����ȡע���ֵ
			MethodAnnotation methodAnnotation = method
					.getAnnotation(MethodAnnotation.class);
			privilegeAccess = methodAnnotation.name();
		}

		return privilegeAccess;

	}

}
