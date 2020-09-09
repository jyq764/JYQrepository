package com.briup.estore.service;

import com.briup.estore.bean.ex.CustomerEx;

public interface ICustomerExService {
	//获取收获地址
	CustomerEx findCustomerExById(int id);
}
