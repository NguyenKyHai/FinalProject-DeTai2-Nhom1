<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="templates/cart.css">
        <link rel="stylesheet" href="templates/detail.css">
        <title>Cart</title>
    </head>
    <body>
        <%@include file="common/header.jsp" %>
        <div style="width: auto; padding-top: 100px;" class="topping">
            <div style="stroke: #907c66; padding: 10px; border-radius: 20px;">
                <img style="margin-right: 15px; width: 60px;" src="images/tranchau.png">
                <label style="padding: 0px;">Trân châu (t1)</label>
                <label style="padding: 0px;">Giá: 5K</label>
            </div>
            <div style="stroke: #907c66; padding: 10px; border-radius: 20px;">
                <img style="margin-right: 15px; width: 60px;" src="images/thachtraicay.jpg">
                <label style="padding: 0px;">Thạch trái cây (t2)</label>
                <label style="padding: 0px;">Giá: 5K<label>
            </div>
            <div style="stroke: #907c66; padding: 10px; border-radius: 20px;">
                <img style="margin-right: 15px; width: 60px;" src="images/raucau.png">
                <label style="padding: 0px;">Rau câu (t3)</label>
                <label style="padding: 0px;">Giá: 5K</label>
            </div>
            <div style="stroke: #907c66; padding: 10px; border-radius: 20px;">
                <img style="margin-right: 15px; width: 60px;" src="images/flan.png">
                <label style="padding: 0px;">Flan (t4)</label>
                <label style="padding: 0px;">Giá: 10K</label>
            </div>
            <div style="stroke: #907c66; padding: 10px; border-radius: 20px;">
                <img style="margin-right: 15px; width: 60px;" src="images/kemphomai.jpg">
                <label style="padding: 0px;">Kem Cheese (t5)</label>
                <label style="padding: 0px;">Giá: 10K</label>
            </div>
        </div>

        <div class="cart_drink">
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">
                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div style="padding: 0px; margin: 0px;" class="col-lg-12 rounded shadow-sm">
                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                    </th>
                                                </th>                                                                                                      <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Size</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Topping</div>

                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Số Lượng</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Thành tiền</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Xóa</div>
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list}" var="o">
                                            <tr>
                                                <th scope="row">
                                                    <div class="p-2">
                                                        <img src="images/${o.image}.png" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                        <div class="ml-3 d-inline-block align-middle">
                                                            <h5 class="mb-0">${o.productname}</h5><span class="text-muted font-weight-normal font-italic"></span>
                                                        </div>
                                                    </div>
                                                </th>
                                                <td class="align-middle"><strong>${o.size}</strong></td>
                                                <td class="align-middle"><strong>${o.topping}</strong></td>

                                                <td class="align-middle">
                                                    <a href="edit-quantity?id=${o.productcode}&type=sub"><button class="btnSub">-</button></a> 
                                                    <strong>${o.quantity}</strong>
                                                    <a href="edit-quantity?id=${o.productcode}&type=add"><button class="btnAdd">+</button></a>
                                                <td  class="align-middle">${o.price *o.quantity} K<strong></strong></td>
                                                </td>
                                                <td class="align-middle"><a href="remove-cart?id=${o.productcode}&topping=${o.topping}" class="text-dark">
                                                        <button type="button" class="btn btn-danger">Xóa</button>
                                                    </a>
                                                </td>
                                            </tr> 
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- End -->
                        </div>
                        <div style="padding: 0px; margin: 0px;">
                            <div style="font-weight: bold;" class="p-4 rounded shadow-sm">
                                Thành tiền: ${sum} K
                            </div>
                        </div>
                    </div>
                    <div class="row d-flex justify-content-end">
                        <div class="p-4 rounded shadow-sm">
                            <a href="home" style="border: none; border-radius: 10px; font-size: medium; padding: 10px; background-color: #907c66;" class="btn btn-success btn-block">Tiếp tục mua hàng</a>
                        </div>  
                    </div>
                    <div class="row py-5 p-4 bg-white rounded shadow-sm">
                        <div class="col-lg-6">
                            <c:if test="${sessionScope.order!=null && sessionScope.qcart>0}">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thông tin giao hàng
                                </div>
                                <div class="p-4">
                                    <form action="order" method="post">
                                        <label>Tên khách hàng: </label>
                                        <input style="border: solid 2px #907c66; border-radius: 10px; padding: 5px;" type="text" name="hoten" required="">
                                        <label>Địa chỉ giao hàng: </label>
                                        <input style="border: solid 2px #907c66; border-radius: 10px; padding: 5px;" type="text" name="diachi" required="">
                                        <label>Số điện thoại: </label>
                                        <input style="border: solid 2px #907c66; border-radius: 10px; padding: 5px;" type="text" name="sodienthoai" required="">
                                        <button class="order btn-success"type="submit" style="border: none; border-radius: 10px; font-size: medium; padding: 10px; background-color: #907c66;" onclick="message()">Tiến hành mua hàng</button>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
crossorigin="anonymous"></script>
<script src="templates/functionWeb.js"></script>
</body>
<footer>
    <img src="images/logo.png">
</footer>
</html>