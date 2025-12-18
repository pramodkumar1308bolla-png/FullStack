package com.JspidersSecurity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.JspidersSecurity.Repo.UserInterface;
import com.JspidersSecurity.entity.UserEntity;
import com.JspidersSecurity.service.userServiceI;

@Service
public class UserServiceImpl implements userServiceI {

	@Autowired
	UserInterface userRepo;

	BCryptPasswordEncoder bCryptoPasswordENcoder = new BCryptPasswordEncoder();

	@Override
	public UserEntity addUserInfo(UserEntity u) {
		u.setPswd(bCryptoPasswordENcoder.encode(u.getPswd()));
		return userRepo.save(u);
	}

}
