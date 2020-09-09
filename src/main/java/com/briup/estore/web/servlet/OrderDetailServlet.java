package com.briup.estore.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.IOrderLineService;
import com.briup.estore.service.impl.OrderLineServiceImpl;

public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String id = request.getParameter("id");
			IOrderLineService orderLineServiceImpl = new OrderLineServiceImpl();
			List<OrderLine> list = orderLineServiceImpl.findOrderLineById(Integer.parseInt(id));
			session.setAttribute("orderdetail", list);
			
			response.sendRedirect(request.getContextPath()+"/after/orderdetail.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
