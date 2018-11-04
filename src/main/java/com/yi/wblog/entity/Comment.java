package com.yi.wblog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	private String content;
	@CreatedDate
	private Date createdTime;
	
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	@JoinColumn(name="articleId")
	@ManyToOne
	private Article article;
}
