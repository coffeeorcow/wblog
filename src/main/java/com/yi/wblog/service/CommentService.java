package com.yi.wblog.service;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.Comment;
import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.repository.ArticleRepository;
import com.yi.wblog.repository.CommentRepository;
import com.yi.wblog.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
	 * @param comment 评论信息
	 * @return
	 */
	public RespBody add(Comment comment) {
		// 验证信息的完整性和正确性
		if (comment == null)
			return new RespBody("error", "评论信息不能为空！");
		if (StringUtils.isEmpty(comment.getContent()))
			return new RespBody("error", "评论信息不能为空！");
		User u = comment.getUser();
		if (u == null)
			return new RespBody("error", "用户不存在");
		User user = userRepository.findById(u.getId()).get();
		if (user == null)
			return new RespBody("error", "用户不存在");
		Article a = comment.getArticle();
		if (a == null)
			return new RespBody("error", "文章不存在");
		Article article = articleRepository.findById(a.getId()).get();
		if (article == null)
			return new RespBody("error", "文章不存在");
		comment.setUser(user);
		comment.setArticle(article);
		log.info(comment.toString());
		commentRepository.save(comment);
		return new RespBody("success", "评论添加成功");
	}

	/**
	 * 根据用户 id 查询评论信息
	 * @param userId    用户 Id
	 * @return          评论信息
	 */
	public Set<Comment> getByUserId(Long userId) {
		User user = userRepository.getOne(userId);
		if (user == null)
			return new HashSet<>();
		Set<Comment> comment = user.getComments();
		return comment;
	}

	/**
	 * 根据文章 id 评论信息
	 * @param articleId     文章 id
	 * @return               评论信息
	 */
	public Set<Comment> getByArticleId(Long articleId) {
		Article article = articleRepository.getOne(articleId);
		if (article == null)
			return new HashSet<>();
		return article.getComments();
	}
}
