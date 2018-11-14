package com.yi.wblog.controller;

import com.yi.wblog.entity.Tag;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;

    @GetMapping("/all")
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @PostMapping("/tagNames")
    public List<Tag> getByTagNames(@RequestBody Set<String> tags) {
        tags.forEach(tag -> log.info(tag.toString()));
        return tagService.getTagsByNames(tags);
    }

    @GetMapping("/add")
    public RespBody addTag(String tagName) {
        log.info("tagName: " + tagName);
        return tagService.addTag(tagName);
    }
}
