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

/**
 * 访问控制
 * @author wjy
 *	用户登录、注册、注销
 */
@RestController
public class AccessController{
	
	@Autowired
	UserService userService;
	
	/**
	 * 用于测试的 get 请求
	 * @return hello
	 */
	@GetMapping("/hello")
	public String hello() {
		return "hello!";
	}
	
	/**
	 * 用户登录
	 * @param userName 用户名
	 * @param password 密码
	 * @param session null
	 * @return 成败信息
	 */
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
	
	/**
	 * 用户注销
	 * @param session null
	 * @return 成败信息
	 */
	@GetMapping("/logout")
	public RespBody logout(HttpSession session) {
		if (session.getAttribute("id") != null)
			session.removeAttribute("id");
		return new RespBody("success", "注销成功");
	}

	/**
	 * 用户注册
	 * @param user 用户对象
	 * @return 成败信息
	 */
	@PostMapping("/registry")
	public RespBody registry(User user) {
		return userService.registry(user);
	}

}
