package com.yi.wblog.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public RespBody login(String userName, String password) {
		if (StringUtils.isEmpty(userName) && StringUtils.isEmpty(password))
			return new RespBody("error", "用户名或密码不能为空");
		User u = userRepository.findUserByUserName(userName);
		if (u == null)
			return new RespBody("error", "用户不存在");
		if (!password.equals(u.getPassward()))
			return new RespBody("error", "账户名或密码错误");
		u.setLoginTime(new Date());
		userRepository.save(u);
		return new RespBody("success", "登录成功");
	}

	public RespBody registry(User user) {
		if (user == null)
			return new RespBody("error", "Null Object");
		if (StringUtils.isEmpty(user.getUserName())&&StringUtils.isEmpty(user.getPassward()))
			return new RespBody("error", "用户名或密码不能为空");
		User u = userRepository.findUserByUserName(user.getUserName());
		if (u != null)
			return new RespBody("error", "用户名已存在");
		user.setLoginTime(new Date());
		userRepository.save(user);
		return new RespBody("success", "注册成功");
	}
	
	/**
	 * 查询所有用户
	 * @return 用户信息列表
	 */
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	/**
	 * 根据用户名查询用户
	 * @param userName 用户名
	 * @return 用户信息
	 */
	public User findUserByUserName(String userName) {
		return userRepository.findUserByUserName(userName);
	}
}
