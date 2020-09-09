package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ex.CategoryEx;

public interface ICategoryService {
	//查询一级分类
	List<CategoryEx> findAllCategoryEx() throws Exception;
}
