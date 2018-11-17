package com.yi.wblog.controller;

import com.yi.wblog.entity.Article;
import com.yi.wblog.entity.User;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("")
    public Set<Article> queryArticles(String query) {
        log.info("query is " + query);
        return articleService.queryArticles(query);
    }

    /**
     * 添加文章
     *
     * @param article 文章对象
     * @return 成败信息
     */
    @PostMapping("/add")
    public RespBody addArticle(@RequestBody Article article) {
        log.info(article.toString());
        User user = article.getUser();
        if (user != null) {
            log.info(user.toString());
        } else {
            log.info("user is null");
        }
        return articleService.addArticle(article);
    }

    /**
     * 获取所有文章
     *
     * @return
     */
    @GetMapping("/all")
    public List<Article> getAll() {
        return articleService.getAll();
    }
}
