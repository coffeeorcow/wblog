package com.yi.wblog.pojo;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class CommentBody {
	private Long id;
	private String content;
	private Date createdTime;

	private User user;

	private Article article;

	@Override
	public String toString() {
		return "CommentBody{" +
				"id=" + id +
				", content='" + content + '\'' +
				", createdTime=" + createdTime +
				'}';
	}
}
