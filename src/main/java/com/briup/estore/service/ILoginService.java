package com.briup.estore.service;

import com.briup.estore.bean.Customer;

public interface ILoginService {
	//登录功能
	boolean userLogin(Customer customer) throws RuntimeException;
}
