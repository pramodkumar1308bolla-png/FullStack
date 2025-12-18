package com.JspidersSecurity.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.JspidersSecurity.entity.UserEntity;

public class UserInfoUSerDetails implements UserDetails {
	
	String name;
	String pswd;
	List<SimpleGrantedAuthority> roles;
	
	public UserInfoUSerDetails(UserEntity userInfo) {
		// TODO Auto-generated constructor stub
		name=userInfo.getName();
		pswd=userInfo.getPswd();
		roles=Arrays.stream(userInfo.getRoles()).map(ele->new SimpleGrantedAuthority(ele)).collect(Collectors.toList());
	}
	

	public UserInfoUSerDetails(Optional<UserEntity> userInfo) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		
		return roles;
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return pswd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

}
