package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.mapper.ex.CategoryExMapper;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class CategoryServiceImpl implements ICategoryService{

	@Override
	public List<CategoryEx> findAllCategoryEx() throws Exception {
		//1.调用dao层查询数据
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		CategoryExMapper categoryExMapper = sqlSession.getMapper(CategoryExMapper.class);
		List<CategoryEx> list = categoryExMapper.findAllCategoryEx();
		return list;
	}
}
