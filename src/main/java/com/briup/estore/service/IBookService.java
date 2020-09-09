package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Book;

public interface IBookService {
	//根据书名查找数据库中对应书的详情
	Book findBookesById(int id) throws Exception;
	//查找数据库中书的信息
	List<Book> findAllBooks() throws Exception;
	
}
