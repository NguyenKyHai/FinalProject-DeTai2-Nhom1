<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<div id="header">
    <div class="topnav">
        <a class="logo" href="home"><img src="images/logo.png"></a>
        <div class="con_search">
            <input class="search" type="search" placeholder="Tìm kiếm">
        </div>
        <c:if test="${sessionScope.qcart!=null}">
         <a href="show-cart"><i class="fas fa-cart-arrow-down"></i>Giỏ hàng(${sessionScope.qcart})</a>
        </c:if>
        <c:if test="${sessionScope.qcart==null}">
         <a href="show-cart"><i class="fas fa-cart-arrow-down"></i>Giỏ hàng</a>
        </c:if>
        <a href="order-management"><i style="font-size: 20px; padding-right: 10px;" class="fas fa-list"></i>Danh sách đơn hàng</a>
    </div>
</div>