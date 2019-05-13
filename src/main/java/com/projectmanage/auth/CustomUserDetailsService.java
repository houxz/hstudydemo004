package com.projectmanage.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;
import org.springframework.stereotype.Component;

import com.projectmanage.common.RoleType;
import com.projectmanage.pojo.AuthorityModel;
import com.projectmanage.service.EmapgoAccountService;
import com.projectmanage.service.SessionService;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private EmapgoAccountService emapgoAccountService;
	
	@Autowired
	private SessionService sessionService;

	public CustomUserDetails   loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
System.out.println("=======CustomUserDetailsService:loadUserByUsername()=======================");
		
		if( sessionService.isDuplicateLogin(username) ) {
			throw new SessionAuthenticationException(new String());
		}
		
		AuthorityModel authority = emapgoAccountService.getAuthorityByUsername(username);
		if( authority == null) {
			throw new UsernameNotFoundException(new String());
		}
		
		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setUsername(username);
		userDetails.setPassword(authority.getPassword());
		userDetails.setEnable(authority.getEnabled().equals(1));
		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		Map<String, Object> auth = new HashMap<String,Object>();
		auth.put("rolename", RoleType.ROLE_POIVIDEOEDIT);//byhxz bug
		auths.add( new SimpleGrantedAuthority(MapUtils.getString(auth, "rolename")));
		
		Integer userid = authority.getId();
		
		//int s1= userDetails.getAuthorities().size();
		userDetails.setAuthorities(auths);
		int s2 = userDetails.getAuthorities().size();
		
		return userDetails;
	}
	
	
}
