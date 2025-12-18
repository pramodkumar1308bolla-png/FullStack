package com.JspidersSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JspidersSecurity.Repo.UserInterface;
import com.JspidersSecurity.entity.UserEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserInterface service;
	
	@GetMapping("/login")
	String login( AuthRequest authRequest) {
		return null;
	}
	
//	@PostMapping("/post")
//	UserEntity addUserInfo(@RequestBody UserEntity u) {
//
//		return service.addUserInfo(u);
//
//	}

}
