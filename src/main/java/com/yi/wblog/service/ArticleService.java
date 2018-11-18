package com.yi.wblog.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.yi.wblog.entity.Tag;
import com.yi.wblog.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.Category;
import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.repository.ArticleRepository;
import com.yi.wblog.repository.CategoryRepository;
import com.yi.wblog.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {

	@Autowired
	ArticleRepository articleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CategoryRepository cateRepository;

	@Autowired
	TagRepository tagRepository;

	@Autowired
	UserService userService;

	@Autowired
	CateService cateService;

	/**
	 * 添加文章
	 *
	 * @param article 文章对象
	 * @return 添加成败信息
	 */
	@Transactional
	public RespBody addArticle(Article article) {
		if (article == null)
			return new RespBody("error", "Null Object");
		if (StringUtils.isEmpty(article.getTitle()) && StringUtils.isEmpty(article.getContent()))
			return new RespBody("error", "文章标题或内容不能为空");

		// 用户处理
		User user = article.getUser();
		if (user == null)
			return new RespBody("error", "用户不能为空");
		else if (!userService.ifExist(user.getId()))
			return new RespBody("error", "用户不存在");

		// 分类处理
		Category cate = article.getCate();
		if (cate == null)
			return new RespBody("error", "分类不能为空");
		else if (!cateService.ifExist(cate.getId()))
			return new RespBody("error", "分类不存在");

		// 标签处理
		Set<Tag> tags = article.getTags();
		if (tags != null) {
			if (tags.size() > 0) {
				Tag t;
				for (Tag tag : tags) {
					t = tagRepository.findByTagName(tag.getTagName());
					if (t != null) {
						tag.setId(t.getId());
					} else {
						tagRepository.save(tag);
					}
				}
			}
		}

		articleRepository.save(article);
		return new RespBody("success", "文章添加成功");
	}

	/**
	 * 获取所有文章
	 *
	 * @return
	 */
	public List<Article> getAll() {
		return articleRepository.findAll();
	}

	/**
	 * 根据查询条件查询文章
	 *
	 * @return
	 */
	public Set<Article> queryArticles(String query) {
		Set<Article> articles = new HashSet<>();
		List<Article> at1 = articleRepository.findByTitleLikeIgnoreCase("%" + query + "%");
		List<Tag> tags = tagRepository.findByTagNameLikeIgnoreCase("%" + query + "%");
		for (Article at : at1) {
			articles.add(at);
		}
		for (Tag tag : tags) {
			Set<Article> at2 = tag.getArticles();
			if (at2.size() == 0) {
				articles.addAll(at2);
			}
		}
		return articles;
	}

	/**
	 * 根据文章 id 查询文章信息
	 *
	 * @param id
	 * @return
	 */
	public Article findByID(Long id) {
		return articleRepository.findById(id).get();
	}
}
