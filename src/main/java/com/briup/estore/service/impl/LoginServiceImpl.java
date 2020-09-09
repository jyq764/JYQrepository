package com.briup.estore.service.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.bean.CustomerExample.Criteria;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.estore.service.ILoginService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class LoginServiceImpl implements ILoginService{

	@Override
	public boolean userLogin(Customer customer) throws RuntimeException {
		if (customer==null) {
			throw new RuntimeException("参数为空");
		}
		if (customer.getName()==null) {
			throw new RuntimeException("用户名为空");
		}
		if (customer.getPassword()==null) {
			throw new RuntimeException("密码为空");
		}
		//先从数据库中找对应的名字和密码再做逻辑判断
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		CustomerExample example = new CustomerExample();
		Criteria c = example.createCriteria();
		c.andNameEqualTo(customer.getName());
		List<Customer> customers = mapper.selectByExample(example);
		boolean flag=false;
		for(Customer cus:customers) {
			if (customer.getPassword().equals(cus.getPassword())) {
				flag=true;
				return flag;
			}
		}
		return flag;
	}
}
