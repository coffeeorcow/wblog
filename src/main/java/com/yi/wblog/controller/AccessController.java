package com.yi.wblog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.UserService;

@RestController
public class AccessController{
	
	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello!";
	}
	
	@PostMapping("/login")
	public RespBody login(@RequestParam("userName") String userName,
			@RequestParam("password") String password, HttpSession session) {
		RespBody resp = userService.login(userName, password);
		if (resp.getCode().equals("success")) {
			User user = userService.findUserByUserName(userName);
			session.setAttribute("id", user.getId());
		}
		return resp;
	}
	
	@GetMapping("/logout")
	public RespBody logout(HttpSession session) {
		if (session.getAttribute("id") != null)
			session.removeAttribute("id");
		return new RespBody("success", "注销成功");
	}

	@PostMapping("/registry")
	public RespBody registry(User user) {
		return userService.registry(user);
	}

}
