package com.Jspiders.User.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Jspiders.User.Exception.UserNotFoundException;
import com.Jspiders.User.entity.User;
import com.Jspiders.User.repo.IuserRepo;
import com.Jspiders.User.service.IUserService;

@Service
public class UserServiceImp implements IUserService {

	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	@Autowired
	IuserRepo repo;

	@Override
	public User registerUser(User user) {
		String encodedPass = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPass);
		return repo.save(user);
	}

	@Override
	public User loginUser(String userName, String password) {
		User user1 = repo.findByUserNameorEmail(userName, password).orElseThrow(() -> new UserNotFoundException());
		if (bCryptPasswordEncoder.matches(password, user1.getPassword())) {
			return user1;
		} else {
			throw new UserNotFoundException();
		}
	}
}
