package com.JspidersSecurity.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.JspidersSecurity.Exception.UserNotFoundException;
import com.JspidersSecurity.Repo.UserInterface;
import com.JspidersSecurity.entity.UserEntity;

@Component
public class UserInfoUSerDetailsService implements UserDetailsService {

	@Autowired
	UserInterface repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		Optional<UserEntity> userInfo = repo.findByName(username);
		if (ObjectUtils.isEmpty(userInfo)) {
			throw new UserNotFoundException(username);
		}
		return new UserInfoUSerDetails(userInfo);
	}

}
