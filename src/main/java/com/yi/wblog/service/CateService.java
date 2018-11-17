package com.yi.wblog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yi.wblog.entity.Category;
import com.yi.wblog.pojo.RespBody;
import com.yi.wblog.repository.CategoryRepository;

/**
 * 文章相关操作
 * @author wjy
 *
 */
@Service
public class CateService {
	
	@Autowired
	CategoryRepository cateRepository;
	
	/**
	 * 判断分类是否存在
	 * @param id 分类 id
	 * @return true-存在， false-不存在
	 */
	public boolean ifExist(Long id) {
		if (cateRepository.findById(id) == null)
			return false;
		return true;
	}
	
	/**
	 * 添加分类
	 * @param cate 分类信息
	 * @return 成败信息
	 */
	public RespBody addCate(Category cate) {
		if (cate == null)
			return new RespBody("error", "Null Object");
		else if (StringUtils.isEmpty(cate.getCateName()))
			return new RespBody("error", "分类名不能为空");
		else if (cateRepository.findCategoryByCateName(cate.getCateName()) != null)
			return new RespBody("error", "分类已存在");
		cateRepository.save(cate);
		return new RespBody("success", "分类添加成功");
	}
	
	/**
	 * 查询所有分类
	 * @return 所有分类信息
	 */
	public List<Category> getAllCate() {
		return cateRepository.findAll();
	}
	
	/**
	 * 根据分类名模糊查找分类
	 * @param cateName 分类名称
	 * @return 分类信息列表
	 */
	public List<Category> findByCateNameLike(String cateName) {
		return cateRepository.findByCateNameLikeIgnoreCase(cateName);
	}
	
	/**
	 * 根据分类名查找分类
	 * @param cateName 分类名称
	 * @return 分类信息列表
	 */
	public Category findByName(String cateName) {
		return cateRepository.findByCateName(cateName);
	}
	
	/**
	 * 更改分类名称
	 * @param id
	 * @return
	 */
	public RespBody changeCateName(Long id, String cateName) {
		Category cate = cateRepository.findById(id).get();
		if (cate == null)
			return new RespBody("error", "分类不存在");
		cate.setCateName(cateName);
		cateRepository.save(cate);
		return new RespBody("success", "分类名称修改成功");
	}
}
