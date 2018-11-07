package com.yi.wblog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Tag {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String tagName;
	
	@JsonIgnore
	@ManyToMany(mappedBy="tags", fetch=FetchType.LAZY)
	private List<Article> articles;
	
}
