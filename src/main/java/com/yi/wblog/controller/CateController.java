package com.yi.wblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.Category;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.CateService;

@RestController
@RequestMapping("/cate")
public class CateController {
	
	@Autowired
	CateService cateService;
	
	/**
	 * 添加分类
	 * @param cate 分类信息
	 * @return 成败信息
	 */
	@PostMapping("/add")
	public RespBody addCate(@RequestBody Category cate) {
		return cateService.addCate(cate);
	}
	
	/**
	 * 查询所有有分类
	 * @return 所有分类的信息
	 */
	@GetMapping("/all")
	public List<Category> getAllCate() {
		return cateService.getAllCate();
	}
	
	/**
	 * 模糊查找分类
	 * @param cateName 分类名
	 * @return 分类信息
	 */
	@GetMapping("/like")
	public List<Category> findByCateNameLike(String cateName) {
		return cateService.findByCateNameLike(cateName + "%");
	}
	
	@GetMapping("/change")
	public RespBody changeCateName(String cateName) {
		
	}
}
