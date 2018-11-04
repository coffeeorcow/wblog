package com.yi.wblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
	
}
