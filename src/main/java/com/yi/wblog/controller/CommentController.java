package com.yi.wblog.controller;

import com.yi.wblog.entity.Comment;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/add")
	public RespBody add(@RequestBody Comment comment) {
		log.info(comment.toString());
		return commentService.add(comment);
	}

	@GetMapping("/user")
	public Set<Comment> getByUser(Long userId) {
		log.info("userId is " + userId);
		return commentService.getByUserId(userId);
	}

	@GetMapping("/article")
	public Set<Comment> getByArticle(Long articleId) {
		log.info("articleId is " + articleId);
		return commentService.getByArticleId(articleId);
	}
}
