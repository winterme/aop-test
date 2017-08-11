package com.zzq.aspect;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.zzq.annotation.ParseAnnotation;
import com.zzq.privilege.Privilege;

@Component
public class PrivilegeAspect {
	
	private List<Privilege> privileges=new ArrayList<Privilege>();

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
	
	public void isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		/**
		 * ��ȡ������Ŀ�귽��Ӧ�þ߱���Ȩ��
		 * ��	��ȡĿ�����class
		 * 		Ŀ�귽��������
		 */
		Class targetClass=joinPoint.getTarget().getClass();
		
		String methodName=joinPoint.getSignature().getName();
		
		//��ȡĿ�귽������Ҫ��Ȩ��
		String targatMethodAccess=ParseAnnotation.getAnnotationValue(targetClass, methodName);
		
		boolean falg=false;
		
		for (Privilege privilege : privileges) {
			if(targatMethodAccess.equals(privilege.getName())){
				falg=true;
			}
		}
		
		if(falg){
			//�����Ȩ�޾ͷ���
			joinPoint.proceed();
		}else{
			System.out.println("������˼����û��Ȩ��");
		}
		
	}
	
}
