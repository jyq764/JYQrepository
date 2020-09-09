package com.briup.estore.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.estore.bean.OrderForm;
import com.briup.estore.service.IOrderFormService;
import com.briup.estore.service.impl.OrderFormServiceImpl;
import com.briup.estore.util.AlipayConfig;

public class PayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			IOrderFormService orderFormServiceImpl = new OrderFormServiceImpl();
			OrderForm orderForm = orderFormServiceImpl.findOrderFormById(Integer.parseInt(id));
			/*
			 * 动态生成支付二维码
			 */
			 AlipayClient alipayClient = AlipayConfig.getAlipayClient();
	         //设置请求参数
	         AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
	          
	         AlipayTradePayModel model = new AlipayTradePayModel();
	          
	         // 设定订单号 必须要写,且订单号不能重复，目前已经只是做测试，已经写死
	         model.setOutTradeNo(System.currentTimeMillis()+"");
	          
	         // 设置订单金额
	         model.setTotalAmount(orderForm.getCost()+"");
	         // 订单名字
	         model.setSubject("书籍订单");
	         // 订单描述
	         model.setBody(System.currentTimeMillis()+"");
	          
	         // 产品码
	         model.setProductCode("FAST_INSTANT_TRADE_PAY");

	        // 设置参数
	        alipayRequest.setBizModel(model);
	         
	        // 设置回调地址
	        alipayRequest.setReturnUrl(AlipayConfig.return_url);
	            
	        String result = alipayClient.pageExecute(alipayRequest).getBody();
	             
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
