<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
  StringBuilder builder = new StringBuilder();
  builder.append(request.getScheme()).append("://")
  .append(request.getServerName()).append(":")
  .append(request.getServerPort())
  .append(request.getContextPath()).append("/");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=builder.toString() %>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-首页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/icons.css" />
<link rel="stylesheet" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/turn.css">

</head>
<body>
	<!--顶部-->
	<div class="top">
    	<div class="top_center">
            <ul class="top_bars">
            	<li>
            		<c:choose>
            			<c:when test="${empty sessionScope.customer}">
            				<a href="/JD03_estore/login.jsp">亲，请登录</a>
            			</c:when>
            			<c:otherwise>
            				<a href="/JD03_estore/exit">退出</a>
            			</c:otherwise>
            		</c:choose>
            	|</li>
                <li><a href="/JD03_estore/after/orderlist.jsp">我的订单<span class="jt_down"></span></a>|</li>
                <li><a href="/JD03_estore/focus.html">关注杰普<span class="jt_down"></span></a>|</li>
                <li><a href="#">网站导航<span class="jt_down"></span></a></li>
            </ul>
        </div>
    </div>
    <!--头部-->
    <div class="header3">
    	<a href="#"><img src="images/logo.png"></a>
    	<div class="h3_center">
        	<div class="search_box">
            	<input type="text"/>
                <span>搜索</span>
            </div>
            <p>
            	<c:forEach items="${applicationScope.categories}" var="ca">
            		<a href="#">${ca.name}</a>|
            	</c:forEach>           
            </p>
        </div>
        <div class="h3_right">
        	<div class="myyy">
            	<a href="Person.html">个人信息</a>
                <span class="sj_down"></span>
             </div>
            <div class="tsc">
            	<a href="/JD03_estore/after/shopCart.jsp">去购物车结算</a>
                <span class="sj_right"></span>
            </div>
        </div>
    </div>
    <!--头部导航-->
    <div class="nav_top">
    	<div class="nav_top_center">
            <div>
                	全部图书分类
            </div>
            <ul>
            	<c:forEach items="${applicationScope.categories}" var="ca">
	                <li><a href="#">${ca.name}</a></li>            	
            	</c:forEach>                
            </ul>
        </div>
    </div>

	<div class="container3">
    	<div class="c3_b1">
        	<div class="c3_b1_left">
            	<dl>
            		<c:forEach items="${applicationScope.categories}" var="ca">
	               		<dd>
	                    	<h1>${ca.name}</h1>
	                    	<p>
	                    		<c:forEach items="${ca.categories}" var="cas">
		                        	<a href="list.jsp">${cas.name}</a>	                    		
	                    		</c:forEach>								
	                      	</p>
	                    </dd>           		
            		</c:forEach>
                </dl>
            </div>
            <div class="c3_b1_center">
                <!-- 图片轮播 -->
                <div class="carousel" id="carousel">
                    <div class="btns">
                        <a href="javascript:;" class="leftBtn" id="leftBtn"></a>
                        <a href="javascript:;" class="rightBtn" id="rightBtn"></a>
                    </div>
                    <div class="m_unit" id="m_unit">
                        <ul>
                        	<c:forEach items="${applicationScope.books}" var="books">
                        		 <li><a href="/JD03_estore/book?id=${books.id}"><img src="images/bookcover/${books.name}.jpg"/></a></li>
                        	</c:forEach>
                    
                        </ul>
                    </div>
                    <div class="circles" id="circles">
                        <ol>
                            <li class="cur"></li>
                            <li></li>
                            <li></li>
                            <li></li>
                            <li></li>
                        </ol>
                    </div>
                </div>
                <div class="c3_b1_c_bottom">
                    <ul>
                    	<c:forEach items="${applicationScope.books}" var="books">
	                        <li>
	                           <a href="/JD03_estore/book?id=${books.id}"><img src="images/bookcover/${books.name}.jpg" width="70%" height="80%"/></a>
	                           <a href="/JD03_estore/book?id=${books.id}">${books.name}</a>
	                        </li>
                    	</c:forEach>                     	
                    </ul>
            	</div>
            </div>
            <div class="c3_b1_right">
            	<h1>杰普快报<a href="#">更多</a></h1>
            	<ul>
                	<li><a href="#">最专业的母猪的产后护理  </a></li>
                	<li><a href="#">相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">今天你学习了吗  </a></li>
                	<li><a href="#">震惊！某女子光天化日下偷吃辣条  </a></li>
                	<li><a href="#">苏州黄色暴风预警  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                	<li><a href="#">〈加措〉相信这一切都是对我们最好的安排  </a></li>
                </ul>
                
            </div>
            <div style="clear:both"></div>
        </div>
        <div class="c3_b2">
        	<ul>
        		<c:forEach items="${applicationScope.books}" var="books">
	            	<li>
	                	<div class="c3_b2_txt">
	                    	<h1>${books.name}</h1>
	                        <p>${books.author}</p>
	                        <h2>畅销书籍</h2>
	                        <h2>${books.publisher}</h2>
	                        <p><a href="/JD03_estore/book?id=${books.id}">更多精彩，点击进入</a></p>
	                    </div>
	                </li>
        		</c:forEach>
            </ul>
        </div>
    <div class="c20"></div>
    <!--脚部-->
    <div class="footer3">
    	<div class="f3_top">
        	<div class="f3_center">
                <div class="ts1">品目繁多 愉悦购物</div>
                <div class="ts2">正品保障 天天低价</div>
                <div class="ts3">极速物流 特色定制</div>
                <div class="ts4">优质服务 以客为尊</div>
            </div>
        </div>
        <div class="f3_middle">
        	<ul class="f3_center">
            	<li class="f3_mi_li01">
                	<h1>购物指南</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>配送方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>支付方式</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>售后服务</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li01">
                	<h1>服务保障</h1>
                    <p>常见问题</p>
                    <p>找回密码</p>
                    <p>会员介绍</p>
                    <p>购物演示</p>
                </li>
                <li class="f3_mi_li06">
                	<h1>客服中心</h1>
                    <img src="images/qrcode_jprj.jpg" width="80px" height="80px">
                    <p>抢红包、疑问咨询、优惠活动</p>
                </li>
            </ul>
        </div>
        <div class="f3_bottom">
        	<p class="f3_links">
                <a href="#">关于我们</a>|
                <a href="#">联系我们</a>|
                <a href="#">友情链接</a>|
                <a href="#">供货商入驻</a>
           	</p>
            <p>沪ICP备14033591号-8 杰普briup.com版权所有 杰普软件科技有限公司 </p>
          	<img src="images/police.png">
        </div>
    </div>
<script type="text/javascript" src="js/animate-2.0.1.js"></script>
<script type="text/javascript" src="js/turn.js"></script>
</body>
</html>
    