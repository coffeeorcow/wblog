package com.yi.wblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yi.wblog.entity.Tag;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
    List<Tag> findByTagNameLikeIgnoreCase(String tagName);
}
