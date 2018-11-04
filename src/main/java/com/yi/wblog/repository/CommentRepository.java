package com.yi.wblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	
}
