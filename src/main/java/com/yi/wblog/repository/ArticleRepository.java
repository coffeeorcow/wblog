package com.yi.wblog.repository;

import com.yi.wblog.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	List<Article> findByTitleLikeIgnoreCase(String title);
}
