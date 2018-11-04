package com.yi.wblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.User;
import com.yi.wblog.service.UserService;

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
}
