<%@ page language="java" 
import="java.util.*" 
import="cn.edu.zhku.phonehub.order.model.*" 
import="java.util.ArrayList"

pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <base href="<%=basePath%>"> 
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="./AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="./basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="./css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="./css/optstyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="./js/jquery.js"></script>  
  </head> 
  
  <body>
  
	<%
  	 	//测试数据ArrayList<ShopCartDao>
		ArrayList<ShopCart> shopcartList = (ArrayList<ShopCart>)request.getAttribute("shopcartList");
		
		
		//这里只能以如下方式请求转发request.setAttribute("shopCart",shopCart);不可以用，因为一旦用这个要用
		//request.getRequestDispatcher("b.jsp").forward(request, response);
		
		//request.getSession().setAttribute("shopcartList",shopcartList);
		//out.write(shopcartList.toString());
  	  %>
  	  
  	  <!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a> 
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage home"> 
					<div class="menu-hd"><a href="./index.jsp" target="_top" class="h">商城首页</a></div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng"><a href="./servlet/ConsumerSeeOrderCtrl" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd"><a id="mc-menu-hd" href="./servlet/ShowShopcartCtrl" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
				</div>
			</ul>
			</div>
  	  <!--悬浮搜索框-->

			<div class="nav white">
				<div class="logo"><img src="../images/logo.png" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
				</div>

							<script>
								function search(){
									var searchInfo = document.getElementById("searchInput").value;
									alert("searchInfo="+searchInfo);
									var search_form = document.getElementById("search_form");
									search_form.action="./servlet/SearchProductCtrl?searchType=商品&searchInfo="+searchInfo;
									search_form.submit();
								}
							</script>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form id="search_form" action="" method="post">
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off">
					<input onclick="search()" id="ai-topsearch" class="submit am-btn"
						value="搜索" index="1" type="submit">
				</form>
			</div>
		</div>
  	  <div class="clear"></div>

			<!--购物车 -->
		<form action="./servlet/ShowOrderCtrl" id="submit_form"> 
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>
				<%
				if(shopcartList!=null){
					//System.out.println("shopcartCommit-----shopcartList="+shopcartList);
					for(int i=0;i<shopcartList.size();i++){
				%>
  	  				<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
							</div>
							<div class="clear"></div>
							
							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div>  
											<input type="checkbox" name="selectedProduct" value="<%=shopcartList.get(i).getProductId()%>" >
											<!-- <input type="checkbox" name="selectedProduct" value="<%=shopcartList.get(i).getProductId()%>"> -->
										</div>
									</li>
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" data-title=<%=shopcartList.get(i).getProductName() %> class="J_MakePoint" data-point="tbcart.8.12">
												<img src="/PhoneHub/Image/<%=shopcartList.get(i).getImage()%>" width="80px" height="80px" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
											<div class="item-basic-info">
												<a href="#" target="_blank" title=<%=shopcartList.get(i).getProductName() %> class="item-title J_MakePoint" data-point="tbcart.8.11"><%=shopcartList.get(i).getProductName() %></a>
											</div>
										</div>
									</li>
									<li class="td td-info">
										<div class="item-props item-props-can">
											<span class="sku-line">颜色：<%=shopcartList.get(i).getColor() %></span>
											<br>
											<span class="sku-line">邮费：包邮</span>
											<span tabindex="0" class="btn-edit-sku theme-login"></span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0"><%=shopcartList.get(i).getPrice() %></em>
												</div>
											</div>
										</div>
									</li>
									<script type="text/javascript">
												function totalPrice(op,one,i,pid){
													//alert("one"+one);
													alert("pid"+pid);
													var buyNum = document.getElementById("buyNum"+i).value;
													if(op==1){	//加法
														buyNum = parseFloat(buyNum)+parseFloat(1);
														  $.ajax({  
												               type:"get",//请求方式  
												               url:"/PhoneHub/cart/PlusCart?productId=" + pid,//发送请求地址  
												               timeout:30000,//超时时间：30秒  
												             //  dataType:"json",//设置返回数据的格式  
												               //请求成功后的回调函数 data为json格式  
												               success:function(){  
												                  alert("plus成功");
												                  
												              },  
												              //请求出错的处理  
												              error:function(){  
												                        alert("请求出错");  
												              }  
												           }); 
													}
													else if(op==2){	//减法
														buyNum = parseFloat(buyNum)-parseFloat(1);
														$.ajax({  
											               type:"get",//请求方式  
											               url:"/PhoneHub/cart/DeCart?productId=" + pid,//发送请求地址  
											               timeout:30000,//超时时间：30秒  
											               dataType:"json",//设置返回数据的格式  
											               //请求成功后的回调函数 data为json格式  
											               success:function(){
											                  alert("de成功");
											               //   var flag = data.flag;
											               //  if(flag == "true"){
											                //     $("#userInfo").html( value + "已经被使用了,请换一个用户名！")
											                 // }
											              }, 
											              //请求出错的处理  
											              error:function(){  
											                        alert("请求出错");  
											              }
											           });  
													}
													//alert("buyNum="+buyNum);
													var total = parseFloat(buyNum)*parseFloat(one);
													//alert("total="+total);
													//document.getElementById("totalPrices").value=total;
													document.getElementById("totalPrices"+i).innerText=total;
												}
											</script>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" onclick="totalPrice(2,<%=shopcartList.get(i).getPrice()%>,<%=i%>,<%=shopcartList.get(i).getProductId()%>)" />
													<input id="buyNum<%=i %>" class="text_box" name="" type="text" value="1" disabled="true" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+"  onclick="totalPrice(1,<%=shopcartList.get(i).getPrice()%>,<%=i%>,<%=shopcartList.get(i).getProductId()%>)"/>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											
											<em tabindex="0" class="J_ItemSum number" id="totalPrices<%=i %>" ><%=shopcartList.get(i).getPrice()*shopcartList.get(i).getNum() %></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
											<a href="javascript:;" data-point-url="" class="delete">删除</a>
										</div>
									</li>
								</ul>
								
							</div>
						</div>
					</tr>
					<div class="clear"></div>
					<%
						}
					} 
					%>
				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div class="float-bar-right">
						<!-- 
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div>
						 -->
						<div class="btn-area">
							<script type="text/javascript">
								function submit(){
									document.getElementById("submit_form").submit();
								}
							</script>
							<a onclick="submit()" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></a>
							<input id="input_submit" style="display: none;" type="submit" value="结算">
						</div>
					</div>
				</div>
		</div>
	</form>
  </body>
</html>
