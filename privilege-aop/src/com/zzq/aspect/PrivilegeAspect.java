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
		 * 获取到访问目标方法应该具备的权限
		 * ·	获取目标类的class
		 * 		目标方法的名称
		 */
		Class targetClass=joinPoint.getTarget().getClass();
		
		String methodName=joinPoint.getSignature().getName();
		
		//获取目标方法所需要的权限
		String targatMethodAccess=ParseAnnotation.getAnnotationValue(targetClass, methodName);
		
		boolean falg=false;
		
		for (Privilege privilege : privileges) {
			if(targatMethodAccess.equals(privilege.getName())){
				falg=true;
			}
		}
		
		if(falg){
			//如果有权限就放行
			joinPoint.proceed();
		}else{
			System.out.println("不好意思，您没有权限");
		}
		
	}
	
}
