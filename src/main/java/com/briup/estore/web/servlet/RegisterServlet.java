package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.impl.CustomerServiceImpl;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =null;
		try {
			session = request.getSession();
			//1.接收数据
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String zipCode = request.getParameter("zipCode");
			String telephone = request.getParameter("telephone");
			String email = request.getParameter("email");
			//2.封装对象
			Customer customer = new Customer();
			customer.setName(name);
			customer.setPassword(password);
			customer.setZipcode(zipCode);
			customer.setTelephone(telephone);
			customer.setEmail(email);
			//3.测试打印
			System.out.println(customer);
			//4.调用service
			ICustomerService customerService = new CustomerServiceImpl();
			customerService.saveCustomer(customer);
			session.setAttribute("msg", "注册成功，请登录");
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
		} catch (RuntimeException e) {
			//把异常信息以用户能看懂的形式展现给用户
			session.setAttribute("msg", "注册失败:"+e.getMessage());
			response.sendRedirect(request.getContextPath()+"/register.jsp");
			//request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
