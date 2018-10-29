package com.yi.wblog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String nickName;
    private String Email;
    private boolean gender;
    private String passwd;

}
