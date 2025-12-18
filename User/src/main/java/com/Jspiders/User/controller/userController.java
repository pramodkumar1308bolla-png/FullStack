package com.Jspiders.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Jspiders.User.entity.User;
import com.Jspiders.User.service.IUserService;

@RestController
public class userController {

	@Autowired
	IUserService service;

	@PostMapping("/signup")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.registerUser(user),HttpStatus.CREATED);
	}

	@GetMapping("/login") 
	public ResponseEntity<User> loginUser(@RequestHeader String email, @RequestHeader String password) {
		return new ResponseEntity<User>(service.loginUser(email, password),HttpStatus.OK);
	}
}
