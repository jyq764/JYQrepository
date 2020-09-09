package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.OrderLine;

public interface IOrderLineService {
	//保存订单项
	void saveOrderLine(OrderLine orderLine) throws Exception;
	//根据订单表的id查询每个订单项下的具体商品信息
	List<OrderLine> findOrderLineById(int id) throws Exception;
	//根据orderform_id删除订单项表中的记录
	void deleteOrderLineById(int id)throws Exception;
}
