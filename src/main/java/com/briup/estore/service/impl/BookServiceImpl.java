package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.BookExample;
import com.briup.estore.bean.BookExample.Criteria;
import com.briup.estore.mapper.BookMapper;
import com.briup.estore.service.IBookService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class BookServiceImpl implements IBookService{

	@Override
	public Book findBookesById(int id) throws Exception {
		//1.根据前台拿到的书的名字去数据库中查找对应的书的信息
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		BookExample example = new BookExample();
		example.createCriteria().andIdEqualTo(id);
		List<Book> list = mapper.selectByExample(example);
		return list.get(0);
	}

	@Override
	public List<Book> findAllBooks() throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		BookMapper mapper = sqlSession.getMapper(BookMapper.class);
		BookExample example = new BookExample();
		long num = mapper.countByExample(example);
		example.createCriteria().andIdGreaterThan((int)num-6);
		List<Book> list = mapper.selectByExample(example);
		return list;
	}

}
