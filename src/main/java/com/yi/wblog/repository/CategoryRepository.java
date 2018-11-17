package com.yi.wblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findCategoryByCateName(String cateName);
	List<Category> findByCateNameLikeIgnoreCase(String cateName);
	Category findByCateName(String cateName);
}
