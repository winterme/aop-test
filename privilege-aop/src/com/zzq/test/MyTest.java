package com.zzq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzq.aspect.PrivilegeAspect;
import com.zzq.privilege.Privilege;
import com.zzq.service.IPersonService;

public class MyTest {
	
	@Test
	public void testPrivilege(){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Privilege p1=new Privilege();
		p1.setName("deletePerson");
		Privilege p2=new Privilege();
		p2.setName("savePerson");
		
		//��ȡ���棬ע��Ȩ��
		PrivilegeAspect aspect=context.getBean("privilegeAspect",PrivilegeAspect.class);
		aspect.getPrivileges().add(p1);
		aspect.getPrivileges().add(p2);
		
		//��ȡservice��ִ�з���
		IPersonService service =(IPersonService) context.getBean("personServiceImpl");
		
		service.savePerson();
		
	}
	
}
