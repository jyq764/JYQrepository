package com.briup.estore.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.ex.CategoryEx;
import com.briup.estore.service.ICategoryService;
import com.briup.estore.service.impl.BookServiceImpl;
import com.briup.estore.service.impl.CategoryServiceImpl;

public class IndexListener implements ServletContextListener {

    public IndexListener() {
       
    }

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
        
    	try {
			ServletContext application = sce.getServletContext();
			//1.调用service层得到数据
			ICategoryService categoryServiceImpl = new CategoryServiceImpl();
			List<CategoryEx> list = categoryServiceImpl.findAllCategoryEx();
			//2.数据放到application容器中
			application.setAttribute("categories",list);
						
			BookServiceImpl serviceImpl = new BookServiceImpl();
			List<Book> books = serviceImpl.findAllBooks();
			application.setAttribute("books",books);
			//3.页面动态展示数据
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
	
}
