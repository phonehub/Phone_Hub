<%@page import="cn.edu.zhku.phonehub.address.model.Address"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>地址管理</title>

		<link href="../AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="../css/personal.css" rel="stylesheet" type="text/css">
		<link href="../css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="../AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="../AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>
	 

	<body>
	<%   
	if(request.getAttribute("address_list")==null){
	            RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/user/AddressCtrl?methods=get1"); //
				rd.forward(request, response); ;
	           return ;
	       }
     Address address = null;
	String name =(String)session.getAttribute("userName");
    List<Address> list = (ArrayList<Address>)request.getAttribute("address_list");
    
	
	  %>
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<a  target="_top" class="h">欢迎你,<%=name %></a>
									
								</div>
							</div>
						</ul>
						<ul class="message-r">
							<div class="topMessage home">
								<div class="menu-hd"><a href="../index.jsp" target="_top" class="h">商城首页</a></div>
							</div>
							<div class="topMessage my-shangcheng">
								<div class="menu-hd MyShangcheng"><a href="/PhoneHub/user/information.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
							</div>
							<div class="topMessage mini-cart">
								<div class="menu-hd"><a id="mc-menu-hd" href="/PhoneHub/cart/showcart.jsp" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
							</div>
							<div class="topMessage favorite">
						
						</ul>
					
						<!--悬浮搜索框-->

							</div>
  	                            <div class="nav white" >
							<div class="logoBig">
								<li><img  src="../Image/logo.jpg" width="200px" alt="" /></li>
							</div>

							<div class="search-bar pr">
								<a name="index_none_header_sysc" href="#"></a>
								<form>
									<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
									<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
								</form>
							</div>
						</div>

						<div class="clear"></div>
					</div>
				</div>
			</article>
		</header>

		<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="./index.jsp">首页</a></li>
				
				</ul>
			
			
			</div>
		</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
 
					<div class="user-address">
						<!--标题 -->
					
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址更改</strong> / <small>Address&nbsp;Modify</small></div>
							
					  </div>
						<hr/>
						
						<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails" id="add-num">
                          	<%  
						 for(int i = 0;i<list.size();i++){
						  address = list.get(i);
						if(address.getIfdefault()==1)
						{
						 %>
							<li class="user-addresslist defaultAddr">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>选择</span>
								<input type="hidden" value="<%=address.getAddressId() %>" name ="default">
								<p class="new-tit new-p-re">
									<span class="new-txt"><%=address.getReceiver() %></span>
									<span class="new-txt-rd2"><%=address.getPhone() %></span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span>
										<span class="province"><%=address.getProvince() %></span>
										<span class="city"><%=address.getCity() %></span>
									
										<span class="street"><%=address.getDetailAddress() %></span></p>
								</div>
								<div class="new-addr-btn">
									<a href="javascript:void(0);" class="del" ><i class="am-icon-trash"></i>编辑</a>
								</div>
							</li>
                      <% 
                      
                      }
                      else
                      {
                      %>
							<li class="user-addresslist">
							<input type="hidden" value="<%=address.getAddressId() %>" name ="kaka">
								<span class="new-option-r"><i class="am-icon-check-circle"></i>选择</span>
								<p class="new-tit new-p-re">
									<span class="new-txt"><%=address.getReceiver() %></span>
									<span class="new-txt-rd2"><%=address.getPhone() %></span>
								</p>
								<div class="new-mu_l2a new-p-re">
									<p class="new-mu_l2cw">
										<span class="title">地址：</span>
										<span class="province"><%=address.getProvince() %></span>
										<span class="city"><%=address.getCity() %></span>
									
										<span class="street"><%=address.getDetailAddress() %></span></p>
								</div>
								<div class="new-addr-btn">
									<a href="javascript:void(0);" class="del"><i class="am-icon-trash"></i>编辑</a>
								</div>
							</li>
						
							<%
							
							}
							}
							 %>
						</ul>
						<div class="clear"></div>
						<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加新地址</a>
						<!--例子-->
						<div class="am-modal am-modal-no-btn" id="doc-modal-1">

							<div class="add-dress">

								<!--标题 -->
								<div class="am-cf am-padding">
									<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
								</div>
								<hr/>

								<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
									<form class="am-form am-form-horizontal"  id="form1" action="/PhoneHub/user/AddressCtrl" method="post"  >
                                    <input type="hidden"  value="update"  name="methods">
                                   <input type="hidden"  id="ars1" value=""  name="addressId">
										<div class="am-form-group">
											<label for="receiver" class="am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="receiver" placeholder="收货人" name="receiver">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="phone" placeholder="手机号必填" type="email" name="phone">
											</div>
										</div>
										<div class="am-form-group">
												<label for="user-phone" class="am-form-label">省份</label>
											<div class="am-form-content">
												<input id="province" placeholder="省份必填" type="text" name="province">
											</div>
											
										</div>

										<div class="am-form-group">
												<label for="user-phone" class="am-form-label">城市</label>
											<div class="am-form-content">
												<input id="city" placeholder="城市必填" type="text"  name="city">
											</div>
											</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea class="" rows="3" id="detail" placeholder="输入详细地址"   name="detailAddress"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<a class="am-btn am-btn-danger" id="save">更改</a>
											</div>
										</div>
									</form>
								</div>

							</div>

						</div>

					</div>
<!--  ---------------------------------------------------------------->
					<script type="text/javascript">
						$(document).ready(function() {							
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').find("input").attr("name","default");
								$(this).parent('.user-addresslist').siblings().find("input").attr("name","noDefault");
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
								var set=$(this).parent('.user-addresslist').find("input").val();
								
							 }); 
			
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn");
							}
							
							$("#save").click(function(){
							
							   if(confirm("是否确认更改"))
                                  {
                                  
                                 
                                  if($("#receiver").val().length==0||$("#phone").val().length==0||$("#province").val().length==0||$("#city").val().length==0||$("#detail").val().length==0){
                                        alert("请填上所有信息");
                                      return false;
                                  }

                                 $("#form1").submit();
        
                                 }
                           else
                          return false;							
							});  
							});
							  $(document).ready(function() {
                        
                            $(".del").click(function(){
                            if(!confirm("是否确认编辑"))  
                            ;
                            else {
                             var name = $(this).parent("div").siblings('.new-tit').children('.new-txt').html();
                             var phone = $(this).parent("div").siblings('.new-tit').children('.new-txt-rd2').html();
                             var province =$(this).parent("div").siblings(".new-mu_l2a").find(".new-mu_l2cw").children(".province").html();
                             var city =$(this).parent("div").siblings(".new-mu_l2a").find(".new-mu_l2cw").children(".city").html();
                             var detail =$(this).parent("div").siblings(".new-mu_l2a").find(".new-mu_l2cw").children(".street").html();
                             
                            var id = $(this).parent("div").parent('.user-addresslist').find("input").val();
                             $("#form1").find("#ars1").val(id);
                             $("#receiver").val(name);
                             $("#phone").val(phone);
                             $("#province").val(province);
                             $("#city").val(city);
                             $("#detail").val(detail);
                            }
                        
                            });
                            })
                            
				
					</script>

					<div class="clear"></div>

				</div>
				<!--底部-->
				<div class="footer">
					<div class="footer-hd">
						<p>
							
						</p>
					</div>
					<div class="footer-bd">
						<p>
						</p>
					</div>
				</div>
			</div>

			<aside class="menu">
					<ul>
					<li class="person active">
						<a href="index.html"><i class="am-icon-user"></i>个人中心</a>
					</li>
					<li class="person">
						<p><i class="am-icon-newspaper-o"></i>个人资料</p>
						<ul>
							<li> <a href="information.jsp">个人信息</a></li>
							<li> <a href="password.jsp">安全设置</a></li>
							<li> <a href="address.jsp">地址管理</a></li>
						</ul>
					</li>
					<li class="person">
						<p><i class="am-icon-balance-scale"></i>我的交易</p>
						<ul>
							<li><a href="order.html">订单管理</a></li>
						</ul>
					</li>
				

				</ul>

			</aside>
		</div>

	</body>

</html>
    

