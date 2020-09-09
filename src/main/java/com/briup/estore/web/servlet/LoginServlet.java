package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ex.ShopCar;
import com.briup.estore.service.ICustomerService;
import com.briup.estore.service.ILoginService;
import com.briup.estore.service.impl.CustomerServiceImpl;
import com.briup.estore.service.impl.LoginServiceImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*//1.接收浏览器页面提交过来的表单数据。
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//2.将拿到的数据交给service层做判断
		//先封装为一个对象
		Customer customer = new Customer();
		customer.setName(name);
		customer.setPassword(password);
		
		ILoginService loginServiceImpl = new LoginServiceImpl();
		boolean flag = loginServiceImpl.userLogin(customer);
		if (flag) {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		//request.getRequestDispatcher("/login.jsp").forward(request, response);	
		response.sendRedirect(request.getContextPath()+"/login.jsp");*/
				
		HttpSession session = request.getSession();
		//1.接收浏览器页面提交过来的表单数据。
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//2.调用service层
		ICustomerService customerServiceImpl = new CustomerServiceImpl();
		Customer customer = customerServiceImpl.findUserByNameAndPssword(name, password);
		if (customer==null) {
			session.setAttribute("msg", "登录失败，没有该用户");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else {
			//登录成功后，创建一个购物车
			ShopCar shopCar = new ShopCar();
			session.setAttribute("cart", shopCar);
			
			session.setAttribute("customer", customer);
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}			
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}
}
