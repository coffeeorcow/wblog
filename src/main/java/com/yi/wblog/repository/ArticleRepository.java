package com.yi.wblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
}
