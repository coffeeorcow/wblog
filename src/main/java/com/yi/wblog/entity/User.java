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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;			// 用户id
    @Column(unique=true)
    private String userName;	// 用户名
    private String email;		// 邮箱
    @JsonIgnore
    private String password;	// 密码
    private String avatar;		// 头像的url地址
    private Integer gender = 0; // 0未知，1男，2女
    @CreatedDate
    private Date registyTime;	// 注册时间
    private Date loginTime;		// 最近登录时间
    
    @JsonIgnore
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Article> articles;
    
    @JsonIgnore
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private List<Comment> comments;
    
}
