package com.briup.estore.bean.ex;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.briup.estore.bean.OrderLine;

public class ShopCar {
	//key 商品id value订单项（商品 数量）
	private Map<Integer,OrderLine> map=null;
	
	public ShopCar() {
		map=new HashMap<>();
	}
	
	//向购物车内添加商品，需要判断购物车中是否存在该商品的订单项，
	//如果存在，在数量上直接加1
	//如果不存在，直接添加这个订单项
	public void add(OrderLine line){
		//购物车有这个商品
		if (map.containsKey(line.getBookId())) {
			//订单项改变了
			//获取一个新的订单项
			OrderLine newLine = map.get(line.getBookId());//从数据库中获取到原有的订单项
			newLine.setNum(newLine.getNum()+line.getNum());//原有的数量加上新增的数量
			newLine.setCost(line.getBook().getPrice()*newLine.getNum());//现有的数量*单价
			map.put(line.getBookId(), newLine);
		}else{
			line.setNum(1);
			map.put(line.getBookId(), line);
		}

	}
	//获取购物车的总价钱
	public double getCost(){
		Collection<OrderLine> orderLines = map.values();
		double sum =0;
		for (OrderLine orderLine : orderLines) {
			sum+=orderLine.getCost();
		}
		return sum;
	}
	
	//修改指定订单中的数量
	public void update(int key,int num){
		OrderLine orderLine = map.get(key);
		if (orderLine!=null) {
			orderLine.setNum(orderLine.getNum()+num);
			
		}
	}
	
	//删除订单项
	public void delete(Integer bookId){
	    map.remove(bookId);
	}
	
	//获取购物车中所有的订单项
	public Collection<OrderLine> getLines(){
	   return	map.values();
	}
	
	//清空购物车
	public void clear(){
		map.clear();
	}
	//获得商品的总数量
	public int getSize(){
		return map.size();
	}
	
}

