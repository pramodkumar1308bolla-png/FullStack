package com.JspidersSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JspidersSecurity.Repo.UserInterface;
import com.JspidersSecurity.entity.UserEntity;
import com.JspidersSecurity.service.userServiceI;

@RestController
@RequestMapping("/demo")
public class SecurityController {
	
	@Autowired
	userServiceI service;

	@GetMapping("/info1")
	String m1() {
		return "Hello this is spring security api 1";
	}

	@GetMapping("/info2")
	@PreAuthorize("hasRole('USER')")
	String m2() {
		return "USER Can Access....";
	}

	@GetMapping("/info3")
	@PreAuthorize("hasRole('ADMIN')")
	String m3() {
		return "Only Admin can access....!!!";
	}

	@PostMapping("/post")
	UserEntity addUserInfo(@RequestBody UserEntity u) {

		return service.addUserInfo(u);

	}

}
