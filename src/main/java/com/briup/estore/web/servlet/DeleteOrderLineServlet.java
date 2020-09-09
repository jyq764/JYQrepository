package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.service.impl.OrderLineServiceImpl;

/**
 * 删除订单表中的一个订单
 * Servlet implementation class DeleteOrderLineServlet
 */
public class DeleteOrderLineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			Customer customer = (Customer) session.getAttribute("customer");
			//1.获取参数
			String id = request.getParameter("id");
			//2.调用dao层
			IOrderFormService orderFormServiceImpl = new OrderFormServiceImpl();
			orderFormServiceImpl.deleteOrderFormById(Integer.parseInt(id));
			IOrderLineService orderLineServiceImpl = new OrderLineServiceImpl();
			orderLineServiceImpl.deleteOrderLineById(Integer.parseInt(id));
			//.查询订单信息并设值到session范围内
			List<OrderForm> list = orderFormServiceImpl.findOrderFormByCustomerId(customer.getId());
			session.setAttribute("orderformlist2", list);
			response.sendRedirect(request.getContextPath()+"/after/orderlist2.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
