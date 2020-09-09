package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class OrderLineServiceImpl implements IOrderLineService{

	@Override
	public void saveOrderLine(OrderLine orderLine) throws Exception {
		if (orderLine==null) {
			throw new Exception("订单项为空");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
		mapper.insert(orderLine);
	}

	@Override
	public List<OrderLine> findOrderLineById(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
		OrderLineExample example = new OrderLineExample();
		example.createCriteria().andOrderformIdEqualTo(id);
		List<OrderLine> list = mapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteOrderLineById(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		OrderLineMapper mapper = sqlSession.getMapper(OrderLineMapper.class);
		OrderLineExample example = new OrderLineExample();
		example.createCriteria().andOrderformIdEqualTo(id);
		mapper.deleteByExample(example);
		
	}

}
