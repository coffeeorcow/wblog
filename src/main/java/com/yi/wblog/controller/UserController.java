package com.yi.wblog.controller;

import java.util.List;
import java.util.Map;

import com.yi.wblog.pojo.RespBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/update")
	public RespBody update(@RequestBody User user) {
		log.info("user is " + user.toString());
		return userService.update(user);
	}

	@PostMapping("/pwd")
	public RespBody udpatePwd(@RequestBody Map<String, String> map) {
		String idStr = map.get("id");
		String newpwd = map.get("newpwd");
		String oldpwd = map.get("oldpwd");
		Long id = Long.parseLong(idStr);
		return userService.updatePwd(id, oldpwd, newpwd);
	}
}
