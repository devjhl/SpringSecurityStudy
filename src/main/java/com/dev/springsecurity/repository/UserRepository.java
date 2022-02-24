package com.dev.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.springsecurity.model.User;

//CRUD
//JpaRepositoryあるので自動的にbean登録される
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUsername(String username);
}
