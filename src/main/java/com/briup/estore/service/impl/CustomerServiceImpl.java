package com.briup.estore.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.bean.CustomerExample.Criteria;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class CustomerServiceImpl implements ICustomerService{

	@Override
	public void saveCustomer(Customer customer) throws RuntimeException {
		//1.所有的引用类型都进行判空
		if (customer==null) {
			throw new RuntimeException("参数为空");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		//需求：相同的用户名不允许注册
		//进行插入之前先查询
		CustomerExample example = new CustomerExample();	
		example.createCriteria().andNameEqualTo(customer.getName());
		List<Customer> list = customerMapper.selectByExample(example);
		if (list!=null||list.size()>0) {
			throw new RuntimeException("用户名已存在");
		}
		customerMapper.insert(customer);
		//sqlSession.commit();
	}

	@Override
	public Customer findUserByNameAndPssword(String name, String password) throws RuntimeException {
		if (StringUtils.isBlank(name)&&StringUtils.isBlank(password)) {
			return null;
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
		CustomerExample example = new CustomerExample();
		Criteria c = example.createCriteria();
		c.andNameEqualTo(name).andPasswordEqualTo(password);
		List<Customer> list = customerMapper.selectByExample(example);
		if (list==null||list.size()==0) {
			return null;
		}
		return list.get(0);
	}	
}
