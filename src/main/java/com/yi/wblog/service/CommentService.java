package com.yi.wblog.service;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.Comment;
import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.CommentBody;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.repository.ArticleRepository;
import com.yi.wblog.repository.CommentRepository;
import com.yi.wblog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ArticleRepository articleRepository;

	/**
	 * 添加评论
	 * @param body 评论信息
	 * @return
	 */
	public RespBody add(CommentBody body) {
		// 验证信息的完整性和正确性
		if (body == null)
			return new RespBody("error", "评论信息不能为空！");
		if (StringUtils.isEmpty(body.getContent()))
			return new RespBody("error", "评论信息不能为空！");
		User u = body.getUser();
		if (u == null)
			return new RespBody("error", "用户不存在");
		User user = userRepository.findById(u.getId()).get();
		if (user == null)
			return new RespBody("error", "用户不存在");
		Article a = body.getArticle();
		if (a == null)
			return new RespBody("error", "文章不存在");
		Article article = articleRepository.findById(a.getId()).get();
		if (article == null)
			return new RespBody("error", "文章不存在");
		Comment comment = new Comment();
		comment.setContent(body.getContent());
		comment.setUser(user);
		comment.setArticle(article);
		log.info(comment.toString());
		commentRepository.save(comment);
		return new RespBody("success", "评论添加成功");
	}
}
