<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link rel="stylesheet" href="templates/detail.css">
        <title>Chi tiết</title>
    </head>
    <body>
        <%@include file="common/header.jsp" %>
        <div class="detail_drink">
            <div class="detail_text">
                <div class="detail_container">
                    <div><p class="detail_size">Tên sản phẩm: ${sanpham}</p>
                        <p class="detail_price">Giá: ${price}/ly, Size S</p>
                        <p class="detail_title">Các lựa chọn</p>
                    </div>
                    <form method="post" action="cart">
                        <input class="detail_size" type="hidden" name="masp" value="${id}">
                        </div>
                        <div class="size">
                            <select class="detail_size" name="size">
                                <option value="Small">Size S</option>
                                <option value="Medium">Size M</option>
                                <option value="Large">Size L</option>
                            </select>
                        </div>
                        <p style="padding-left:200px">Thêm Topping:</p>
                        <div class="topping">
                            <img src="images/tranchau.png">
                            <img src="images/thachtraicay.jpg">
                            <img src="images/raucau.png">
                            <img src="images/flan.png">
                            <img src="images/kemphomai.jpg">
                        </div>

                        <div class="topping_check">
                            <input type="checkbox" name="topping" value="t1"><label>Trân chân 5K</label><br>
                            <input type="checkbox"name="topping" value="t2"><label>Thạch trái cây 5K</label><br>
                            <input type="checkbox"name="topping" value="t3"><label>Thạch rau câu 5K</label><br>
                            <input type="checkbox"name="topping" value="t4"><label>Bánh flan 10K</label><br>
                            <input type="checkbox"name="topping" value="t5"><label>Kem cheese 10K</label><br>
                        </div>
                        <div class="quantity">
                            <p>Số lượng:</p>
                            <input type="number" name="quantity" value="1" placeholder="1" min="1" max="100">
                        </div>
                        <input  type="submit" style="border: none; padding: 10px 20px; border-radius: 30px;
                                background-color: #907c66; margin-left: 200px; color: white; font-size: 20px; cursor: pointer;" 
                                value="Đặt món">
                    </form>

                </div>
                <c:if test="${id==1}">
                    <div class="detail_img">
                        <img src="images/hongtra.png">
                    </div>
                </c:if>
                <c:if test="${id==2}">
                    <div class="detail_img">
                        <img src="images/trasua.png">
                    </div>
                </c:if>
                <c:if test="${id==3}">
                    <div class="detail_img">
                        <img src="images/traolong.png">
                    </div>
                </c:if>
                <c:if test="${id==4}">
                    <div class="detail_img">
                        <img src="images/tratraicay.png">
                    </div>
                </c:if>
            </div>
    </body>

    <footer>
        <img src="images/logo.png">
    </footer>
</html>