package com.briup.estore.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderFormExample;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.OrderLineExample;
import com.briup.estore.mapper.OrderFormMapper;
import com.briup.estore.mapper.OrderLineMapper;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.util.MyBatisSqlSessionFactory;

public class OrderFormServiceImpl implements IOrderFormService{

	@Override
	public OrderForm saveOrderForm(OrderForm orderForm) throws Exception {
		//1.判空
		if (orderForm==null) {
			throw new Exception("获取到的订单为空");
		}
		//2.调用dao层
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		mapper.insert(orderForm);
		return orderForm;
	}

	@Override
	public List<OrderForm> findOrderFormByCustomerId(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
        OrderFormMapper orderFormMapper = sqlSession.getMapper(OrderFormMapper.class);
		OrderFormExample example = new OrderFormExample();
		example.createCriteria().andCustomerIdEqualTo(id);
        List<OrderForm> list = orderFormMapper.selectByExample(example);
        return list;
	}

	@Override
	public OrderForm findOrderFormById(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
        OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
        OrderForm orderForm = mapper.selectByPrimaryKey(id);
		return orderForm;
	}

	@Override
	public void deleteOrderFormById(int id) throws Exception {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
        OrderFormMapper mapper = sqlSession.getMapper(OrderFormMapper.class);
		mapper.deleteByPrimaryKey(id);
	}

}
