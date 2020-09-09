package com.briup.estore.mapper.ex;

import java.util.List;

import com.briup.estore.bean.ex.CategoryEx;

public interface CategoryExMapper {
	//查询以及分类级联查询出二级分类
	List<CategoryEx> findAllCategoryEx() throws Exception;
}
