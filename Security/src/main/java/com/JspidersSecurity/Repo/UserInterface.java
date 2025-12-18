package com.JspidersSecurity.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.JspidersSecurity.entity.UserEntity;

public interface UserInterface extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByName(String username);

//	UserEntity addUserInfo(UserEntity u);

//	Optional<UserEntity> addUserInfo(UserEntity u);

//	UserEntity addUserInfo(UserEntity u);

	

}
