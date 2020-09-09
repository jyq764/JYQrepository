package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ICustomerService {
	//注册功能
	void saveCustomer(Customer customer) throws RuntimeException;
	//登录功能
	Customer findUserByNameAndPssword(String name,String password) throws RuntimeException;
}
