package com.yi.wblog.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * 访问控制
 * @author wjy
 *	用户登录、注册、注销
 */
@Slf4j
@RestController
public class AccessController{
	
	@Autowired
	UserService userService;

	/**
	 * 用户登录
     * @param map 用户登录信息
	 * @param session null
	 * @return 成败信息
	 */
	@PostMapping("/login")
	public RespBody login(@RequestBody Map<String, String> map, HttpSession session) {
		// @RequestParam("userName") String userName,
		// @RequestParam("password") String password
		String userName = map.get("userName");
		String password = map.get("password");
		log.info("login info: " + userName + "/" + password);
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
	public RespBody registry(@RequestBody User user) {
		log.info(user.toString());
		return userService.registry(user);
	}
	
	/**
	 * 用于测试的 get 请求
	 * @return hello
	 */
	@GetMapping("/hello")
	public String getHello() {
		return "hello!";
	}
	
	/**
	 * 用于测试的 post 请求
	 */
	@PostMapping("/hello")
	public String postHello(String msg) {
		log.info("msg is: " + msg);
		return "hello!";
	}

}
