package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderForm;

public interface IOrderFormService {
	//保存订单
	OrderForm saveOrderForm(OrderForm orderForm) throws Exception;
	//根据顾客id查询订单
	List<OrderForm> findOrderFormByCustomerId(int id) throws Exception;
	//根据订单id查询订单
	OrderForm findOrderFormById(int id)throws Exception;
	//根据订单id删除订单
	void deleteOrderFormById(int id)throws Exception;
}
