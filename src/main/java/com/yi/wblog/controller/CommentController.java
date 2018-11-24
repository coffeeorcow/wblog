package com.yi.wblog.controller;

import com.yi.wblog.entity.Comment;
import com.yi.wblog.pojo.CommentBody;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/add")
	public RespBody add(@RequestBody CommentBody comment) {
		log.info(comment.toString());
		return commentService.add(comment);
	}
}
