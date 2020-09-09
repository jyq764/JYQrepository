package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ex.ShopCar;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;

public class OrderListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String Customer = null;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			//1.获取地址的id
			String addressId = request.getParameter("addressId");
			//2.获取顾客信息
			Customer customer = (Customer) session.getAttribute("customer");
			//3.获取购物车
			ShopCar shopCar = (ShopCar)session.getAttribute("cart");
			System.out.println("购物车："+shopCar);
			//4.获取订单项
			Collection<OrderLine> lines = shopCar.getLines();
			System.out.println("订单项："+lines);
			//5.向数据库插入数据
			OrderForm orderForm = new OrderForm();
			orderForm.setCost(shopCar.getCost());
			orderForm.setCustomerId(customer.getId());
			orderForm.setOrderdate(new Date());
			orderForm.setShopaddressId(Integer.parseInt(addressId));
			
			IOrderFormService orderFormServiceImpl = new OrderFormServiceImpl();
			OrderForm orderForm2 = orderFormServiceImpl.saveOrderForm(orderForm);
//			System.out.println(orderForm2.getId());
			//6.向数据库中插入订单项
			IOrderLineService orderLineServiceImpl = new OrderLineServiceImpl();
			for(OrderLine orderLine:lines) {
				orderLine.setOrderformId(orderForm2.getId());
				orderLineServiceImpl.saveOrderLine(orderLine);				
			}
			//7.查询订单信息并设值到session范围内
			List<OrderForm> list = orderFormServiceImpl.findOrderFormByCustomerId(orderForm2.getCustomerId());
			session.setAttribute("orderformlist", list);
			//8.跳转订单详情页面--展示动态数据
			response.sendRedirect(request.getContextPath()+"/after/orderlist.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
