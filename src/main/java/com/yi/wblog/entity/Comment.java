package com.yi.wblog.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	private String content;
	@CreatedDate
	private Date createdTime;
	
	@JsonIgnore
	@JoinColumn(name="userId")
	@ManyToOne
	private User user;
	
	@JsonIgnore
	@JoinColumn(name="articleId")
	@ManyToOne
	private Article article;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
