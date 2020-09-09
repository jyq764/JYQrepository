package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public interface IShoppingAddressService {
	List<ShopAddress> selectAddress(int customerid);
	//插入新增地址信息
	void insertAddress(ShopAddress address);
}
