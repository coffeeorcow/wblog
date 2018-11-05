package com.yi.wblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
