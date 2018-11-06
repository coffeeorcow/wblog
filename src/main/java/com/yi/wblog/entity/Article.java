package com.yi.wblog.entity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String content;
	@CreatedDate
	private Date createdTime;
	@LastModifiedDate
	private Date modifiedTime;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	@JoinColumn(name="cateId")
	@ManyToOne
	private Category cate;
	
	@OneToMany(mappedBy="article", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Comment> comments;
	
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Tag> tags;
}
