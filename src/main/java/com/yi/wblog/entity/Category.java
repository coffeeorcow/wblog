package com.yi.wblog.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String cateName;
	@CreatedDate
	private Date createdTime;
	
	@OneToMany(mappedBy="cate", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Article> articles;
}
