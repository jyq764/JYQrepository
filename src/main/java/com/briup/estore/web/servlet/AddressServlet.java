package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopAddress;
import com.briup.estore.bean.ex.CustomerEx;
import com.briup.estore.service.ICustomerExService;
import com.briup.estore.service.impl.CustomerExServiceImpl;
import com.briup.estore.service.impl.ShoppingAddressServiceImpl;

/**
 * Servlet implementation class AddressServlet
 */
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {					
		HttpSession session = request.getSession();
		//从购物车页面拿到新增的收获信息
		Customer customer = (Customer)session.getAttribute("customer");
		Integer id = customer.getId();
		
		String receivename = request.getParameter("receiveName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
//		System.out.println(receivename);
//		System.out.println(address);
//		System.out.println(phone);
				
		ShopAddress shopAddress = new ShopAddress();
		shopAddress.setCustomerId(id);
		shopAddress.setReceivename(receivename);
		shopAddress.setPhone(phone);
		shopAddress.setAddress(address);
		System.out.println(shopAddress);
		//调用service层
		ShoppingAddressServiceImpl shoppingAddressServiceImpl = new ShoppingAddressServiceImpl();
		shoppingAddressServiceImpl.insertAddress(shopAddress);
		
		ICustomerExService customerExServiceImpl = new CustomerExServiceImpl();
		CustomerEx ex = customerExServiceImpl.findCustomerExById(id);
		System.out.println(ex);
		session.setAttribute("addresscus", ex);
		response.sendRedirect(request.getContextPath()+"/after/confirm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
