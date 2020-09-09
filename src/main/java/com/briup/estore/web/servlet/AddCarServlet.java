package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.bean.ex.ShopCar;
import com.briup.estore.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AddCarServlet
 */
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.拿到订单中提交的书的id值和num数量信息
			String id = request.getParameter("id");
			String num = request.getParameter("num");
			//2.查找书籍的信息，调用service层代码
			BookServiceImpl bookServiceImpl = new BookServiceImpl();
			Book book = bookServiceImpl.findBookesById(Integer.parseInt(id));
			//3.创建订单项
			OrderLine orderLine = new OrderLine();
			orderLine.setBookId(book.getId());
			orderLine.setNum(Integer.parseInt(num));
			orderLine.setCost(book.getPrice()*orderLine.getNum());
			orderLine.setBook(book);
			
			HttpSession session = request.getSession();
			ShopCar shopCar = (ShopCar)session.getAttribute("cart");
			//这里其实只要登录就已经创建好购物车了
			if (shopCar==null) {
				//没有购物车创建一个
				shopCar= new ShopCar();
				session.setAttribute("cart", shopCar);
			}
			//4.把订单项放进购物车中
			shopCar.add(orderLine);
			
			response.sendRedirect(request.getContextPath()+"/viewBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
