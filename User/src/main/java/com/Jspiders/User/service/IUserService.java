package com.Jspiders.User.service;

import com.Jspiders.User.dto.ResponseDto;
import com.Jspiders.User.entity.User;

public interface IUserService {

	

	User loginUser(String emailOrUsername, String password);

	User registerUser(User user);

	

}
