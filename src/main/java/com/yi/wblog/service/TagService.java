package com.yi.wblog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.yi.wblog.entity.Tag;
import com.yi.wblog.pojo.RespBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yi.wblog.repository.TagRepository;
import org.springframework.util.StringUtils;

@Service
public class TagService {

    @Autowired
    TagRepository tagRepository;

    /**
     * 根据一个标签名构成的 List 返回一组标签信息
     * @param tagNames 标签名 List
     * @return 标签信息
     */
    public List<Tag> getTagsByNames(Set<String> tagNames) {
        List<Tag> tags = new ArrayList<>();
        Tag tag;
        for (String tagName : tagNames) {
            tag = tagRepository.findByTagName(tagName);
            if (tag != null)
                tags.add(tag);
        }
        return tags;
    }

    public RespBody addTag(String tagName) {
        if (StringUtils.isEmpty(tagName)) {
            return new RespBody("error", "标签名不能为空");
        } else if (tagRepository.findByTagName(tagName) != null) {
            return new RespBody("error", "标签已存在");
        }
        Tag tag = new Tag();
        tag.setTagName(tagName);
        tagRepository.save(tag);
        return new RespBody("success", "标签添加成功");
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }
}
