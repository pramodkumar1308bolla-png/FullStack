package com.Jspiders.User.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Jspiders.User.entity.User;

public interface IuserRepo extends JpaRepository<User, Integer>{

	@Query(nativeQuery=true,value="select * from user where user_name=?1 userName or email=?2 email")
	Optional<User> findByUserNameorEmail(String userName,String email);
	
	 
	
}
