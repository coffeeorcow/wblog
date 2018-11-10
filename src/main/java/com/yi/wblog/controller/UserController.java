package com.yi.wblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.User;
import com.yi.wblog.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	/**
	  * 查询所有用户
	 * @return 包含所有用户信息的列表
	 */
	@GetMapping("/all")
	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
	/**
	 * 按用户名查询用户
	 * @param userName 用户名
	 * @return 用户信息
	 */
	@GetMapping("/name")
	public User findByName(String userName) {
		User user = userService.findUserByUserName(userName);
		log.info("userName: " + userName);
		log.info("user:" + user);
		return user;
	}
}
