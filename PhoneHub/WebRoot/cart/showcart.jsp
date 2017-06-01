<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="cn.edu.zhku.phonehub.cart.model.Cart" %>
<%@page import="cn.edu.zhku.phonehub.cart.model.CartItem" %>
<%@page import="cn.edu.zhku.phonehub.product.model.Product" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<title>购物车页面</title>
		<link href="../AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="../basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="../css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="../css/optstyle.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="../js/jquery.js"></script>
        <script type="text/javascript">
		 function plus(id){  
		//    var value = $("#userName").val();
		    // alert(value);
             $.ajax({  
               type:"get",//请求方式  
               url:"/PhoneHub/cart/PlusCart?productId=" + id,//发送请求地址  
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
           function de(id){  
		    // alert(value);
             $.ajax({  
               type:"get",//请求方式  
               url:"/PhoneHub/cart/DeCart?productId=" + id,//发送请求地址  
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
         
function formsubmit() {
		document.getElementById("form1").action = "/PhoneHub/servlet/ShowOrderCtrl";
		document.getElementById("form1").submit();
		alert("成功");
		}
	</script>
		<script type="text/javascript">
			function totalPrice(op,one,i){
				//alert("one"+one);
				var buyNum = document.getElementById("buyNum"+i).value;
				if(op==1){	//加法
					buyNum = parseFloat(buyNum)+parseFloat(1);
				}
				else if(op==2){	//减法
					buyNum = parseFloat(buyNum)-parseFloat(1);
				}
				//alert("buyNum="+buyNum);
				var total = parseFloat(buyNum)*parseFloat(one);
				//alert("total="+total);
				//document.getElementById("totalPrices").value=total;
					document.getElementById("totalPrices"+i).innerText=total;
				}
		</script>

	</head>
  
  <body>
  <%
  String name =(String)session.getAttribute("userName");
  
   %>
  <div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">欢迎,<%=name %></a>
						
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
			</div>
			<!--悬浮搜索框-->

			<div class="nav white">
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
  <%
   
	   
	 
      Cart cart= null;
    // cart.setUserId(2);
     if(session.getAttribute("px_cart")!=null){
     cart=(Cart)session.getAttribute("px_cart");
     }
    
    if(cart==null)
    {
     %>
     <div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
                            </div>
                            </div>
                            </div>
                            </div>
                            </div>
                             <div class="clear" align="center">
                               <a href="/PhoneHub/index.jsp" >沒有東西，去購物吧</a>
                             </div>
                            
     <% }
     else
      {
       CartItem item =null;
      Product p =  null;
      List<CartItem> items = new ArrayList<CartItem>();
      items=cart.getItems();
      
   %>
    	<form id="form1" action=".sevlet/ShowOrderCtrl" method="post">
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
       <%
       
        for(int i= 0;i<items.size();i++){
           item=items.get(i);
           if(item!=null){
           
     %> 
	 <div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<div class="bd-promos">
									
									<span class="list-change theme-login"></span>
								</div>
							</div>
							<div class="clear"></div>
							<div class="bundle-main">
								<ul class="item-content clearfix">
									<li class="td td-chk">
										<div class="cart-checkbox ">
											<input class="check" id="J_CheckBox_170037950254" name="selectedProduct" value="<%=item.getProduct().getProductId()%>" type="checkbox">
											<label for="J_CheckBox_170037950254"></label>
										</div>
									</li>
									
									<li class="td td-item">
										<div class="item-pic">
											<a href="#" target="_blank" class="J_MakePoint" data-point="tbcart.8.12">
												<img src="/PhoneHub/Image/<%=item.getProduct().getImage1()%>" width="80px" height="80px" class="itempic J_ItemImg"></a>
										</div>
										<div class="item-info">
										
											<div class="item-basic-info">
												<a  target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11"><%=item.getProduct().getProductName() %>
												 <br><%=item.getProduct().getDescription() %>
												
												</a>
											</div>
										</div>
									</li>
									<li class="td td-info">
									<div class="item-props">
											<span class="sku-line">cpu：<%=item.getProduct().getCpu() %></span>
											<span class="sku-line">内存：<%=item.getProduct().getMemory() %></span>
											<span class="sku-line">颜色：<%=item.getProduct().getColor() %></span>
											<i class="theme-login am-icon-sort-desc"></i>
										</div>
									</li>
									<li class="td td-price">
										<div class="item-price price-promo-promo">
											<div class="price-content">
												<div class="price-line">
													<em class="J_Price price-now" tabindex="0"><%=item.getProduct().getPrice() %></em>
												</div>
											</div>
										</div>
									</li>
									<li class="td td-amount">
										<div class="amount-wrapper ">
											<div class="item-amount ">
												<div class="sl">
													<input class="min am-btn" name="" type="button" value="-" onclick="de(<%=item.getProduct().getProductId() %>)"/>
													<input class="text_box"  readonly="value" name="" type="text" value="<%=item.getCount()%>" style="width:30px;" />
													<input class="add am-btn" name="" type="button" value="+" onclick="plus(<%=item.getProduct().getProductId() %>)" />
												</div>
											</div>
										</div>
									</li>
									<li class="td td-sum">
										<div class="td-inner">
											<em tabindex="0" class="J_ItemSum number"><%=item.getCount()*item.getProduct().getPrice()%></em>
										</div>
									</li>
									<li class="td td-op">
										<div class="td-inner">
					
											<a href="/PhoneHub/cart/DelCart?productId=<%=item.getProduct().getProductId() %>" data-point-url="#" class="delete">
                                           删除</a>
										</div>
									</li>
								</ul>
      
      <%    }
      
        }
          %>
           				
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						
					</div>
					<div class="operations">
						<a href="#" hidefocus="true" class="deleteAll"></a>
						<a href="#" hidefocus="true" class="J_BatchFav"></a>
					</div>
					<div class="float-bar-right">
						<div class="amount-sum">
							<span class="txt"></span>
							<em id="J_SelectedItemsCount"></em><span class="txt"></span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
							
						</div>
						
						<div class="price-sum">
							<span class="txt"></span>
							<strong class="price"><em id="J_Total"></em></strong>
						</div>
						<div class="btn-area" >
							<a onclick="formsubmit()" id="J_Go" class="submit-btn submit-btn-disabled" >
<!---      ---------------------------------------- -----           -----------------------------------------------    !----->
<!---      ---------------------------------------- -----           -----------------------------------------------    !----->
	
								<span>结&nbsp;算</span></a>
								
						</div>
					</div>
				</div>
	 <% 
         }
     %>
   
     </div>
      </div>
    </div>
   </div>
     </form>
  </body>
</html>
