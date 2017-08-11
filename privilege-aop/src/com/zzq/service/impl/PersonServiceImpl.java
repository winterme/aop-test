package com.zzq.service.impl;

import org.springframework.stereotype.Service;

import com.zzq.annotation.MethodAnnotation;
import com.zzq.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

	@MethodAnnotation(name="savePerson")
	public void savePerson() {
		// TODO Auto-generated method stub
		System.out.println("save person");
	}

	@MethodAnnotation(name="deletePerson")
	public void deletePerson() {
		// TODO Auto-generated method stub
		System.out.println("delete person");
	}

}
