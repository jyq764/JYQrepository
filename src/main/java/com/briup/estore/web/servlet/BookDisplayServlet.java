package com.briup.estore.web.servlet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.lf5.util.DateFormatManager;

import com.briup.estore.bean.Book;
import com.briup.estore.service.IBookService;
import com.briup.estore.service.impl.BookServiceImpl;

public class BookDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = getServletContext();
		try {
			//1.从页面获取信息
			String id = request.getParameter("id");
			//2.将名字传递给service层
			IBookService bookServiceImpl = new BookServiceImpl();
			Book book = bookServiceImpl.findBookesById(Integer.parseInt(id));
			
			//3.将书的信息设置
			application.setAttribute("book", book);
			//System.out.println(book);
			response.sendRedirect(request.getContextPath()+"/viewBook.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
