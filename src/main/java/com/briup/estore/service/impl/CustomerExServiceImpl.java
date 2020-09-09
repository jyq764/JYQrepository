package com.briup.estore.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ex.CustomerEx;
import com.briup.estore.mapper.ex.CustomerExMapper;
import com.briup.estore.service.ICustomerExService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class CustomerExServiceImpl implements ICustomerExService{

	@Override
	public CustomerEx findCustomerExById(int id) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		CustomerExMapper mapper = sqlSession.getMapper(CustomerExMapper.class);
		CustomerEx ex = mapper.findCustomerExById(id);
		return ex;
	}
}
