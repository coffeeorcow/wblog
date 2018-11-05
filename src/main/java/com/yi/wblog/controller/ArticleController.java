package com.yi.wblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yi.wblog.entity.Article;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	/**
	 * 添加文章
	 * @param article 文章对象
	 * @return 成败信息
	 */
	@PostMapping("/add")
	public RespBody addArticle(Article article) {
		return articleService.addArticle(article);
	}
	
	/**
	 * 获取所有文章
	 * @return
	 */
	@GetMapping("/all")
	public List<Article> getAll() {
		return articleService.getAll();
	}
}
