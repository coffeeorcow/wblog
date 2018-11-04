package com.yi.wblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findUserByUserName(String userName);
}
