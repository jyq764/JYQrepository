package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ShopAddressExample;
import com.briup.estore.mapper.ShopAddressMapper;
import com.briup.estore.service.IShoppingAddressService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class ShoppingAddressServiceImpl implements IShoppingAddressService{

	@Override
	public List<ShopAddress> selectAddress(int customerid) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
		ShopAddressExample example = new ShopAddressExample();
		example.createCriteria().andCustomerIdEqualTo(customerid);
		List<ShopAddress> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public void insertAddress(ShopAddress address) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		ShopAddressMapper mapper = sqlSession.getMapper(ShopAddressMapper.class);
		if (address.getPhone()!=null&&address.getReceivename()!=null&&address.getAddress()!=null) {
			mapper.insert(address);				
		}
	}
	
	
}
