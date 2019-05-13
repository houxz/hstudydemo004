package com.projectmanage.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.projectmanage.pojo.AuthorityModel;
import com.projectmanage.pojo.EmployeeModel;

@Service
public class EmapgoAccountService {

	public AuthorityModel getAuthorityByUsername(String username) {
		
		//fot test;
		AuthorityModel au = new AuthorityModel();
		au.setId(417);
		au.setUsername("houxizhao");
		au.setEnabled(1);
		return au;
	}
	
//	@Cacheable(value = CACHEVALUE, keyGenerator = CACHEKEYGENERATOR)
	public EmployeeModel getOneEmployeeWithCache(EmployeeModel record) {
		///return employeeModelDao.getOneEmployee(record);
		return null;
	}
}
