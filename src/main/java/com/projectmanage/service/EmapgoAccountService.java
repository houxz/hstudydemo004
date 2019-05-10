package com.projectmanage.service;

import org.springframework.stereotype.Service;

import com.projectmanage.pojo.AuthorityModel;

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
}
