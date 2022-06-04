<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="templates/oder-manager.css">
        <title>Order Management</title>
    </head>
    <body>

        <h2 style="text-align: center;  padding-bottom: 30px;" class="title-main">Quản lý đơn hàng</h2>
        <div>
            <a style="text-decoration: 
               none; background-color: #907c66; border-radius: 30px; color: white; padding: 10px 20px;" 
               class="return" href="home">Về trang chủ</a>
        </div>
        <div class="edit-content">
            <form action="edit-order" method="post">
                <div class="modal-header">
                    <h4>Chỉnh sửa thông tin đơn hàng</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input name="cartid" type="hidden" value="${cart.id}" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Sản phẩm</label>
                        <input name="sanpham" type="text" value="${item.productname}" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Giá</label>
                        <input name="price" type="text" value="${item.price}" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Ngày mua</label>
                        <input name="ngaymua" type="text" value="${cart.buydate}" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Người mua</label>
                        <input name="nguoimua" type="text" value="${cart.hoten}" class="form-control" readonly>
                    </div>
                    <div class="form-group">
                        <label>Địa chỉ</label>
                        <input name="soluong" type="text" value="${cart.diachi}" class="form-control" readonly >
                    </div>
                    <div class="form-group">

                        <label>SĐT</label>
                        <input name="sdt" type="text" value="${cart.sdt}" class="form-control" readonly>

                    </div>
                    <div class="form-group">
                        <label>Tình trạng: </label>
                        <select name="tinhtrang" class="form-select" aria-label="Default select example">
                            <c:if test="${cart.status==0}">
                                <option value="0" selected="">Chưa giao</option>
                                <option value="1">Đã giao</option>
                            </c:if>
                            <c:if test="${cart.status==1}">
                                <option value="1" selected="">Đã giao</option>
                                <option value="0">Chưa giao</option>
                            </c:if>
                        </select>
                    </div>
                    <div><p style="color: green;">${message}</p></div>
                </div>
                <div class="modal-footer">
                    <input type="submit" class="btn-save" value="Lưu">
                </div>
            </form>
        </div>
        <div class="container">
            <form action="sort-price" method="get">
                <div class="form-group">
                    <label>Sắp xếp theo giá: </label>
                    <select name="sort" class="form-select" aria-label="Default select example">
                        <c:if test="${sort==0 || sort==null}">
                        <option value="0" selected="">Bình thường</option>
                        <option value="1" >Tăng dần</option>
                        <option value="-1">Giảm dần</option>
                        </c:if>
                          <c:if test="${sort==1}">
                        <option value="0" >Bình thường</option>
                        <option value="1" selected="" >Tăng dần</option>
                        <option value="-1">Giảm dần</option>
                        </c:if>
                          <c:if test="${sort==2}">
                        <option value="0" >Bình thường</option>
                        <option value="1" >Tăng dần</option>
                        <option value="-1" selected="">Giảm dần</option>
                        </c:if>
                    </select>
                </div>
<!--                <div><p style="color: green;">{message}</p></div>-->
                <div class="">
                    <input type="submit" class="btn-save" value="Sắp xếp">
                </div>
            </form>
            <div class="table-wrapper">
                <table style=" margin-top: 30px;" class="table table-striped table-hover">
                    <thead>
                        <tr>
                             <th>Id</th>
                            <th>Thông tin đồ uống</th>
                            <th>Giá</th>
                            <th>Ngày mua</th>
                            <th>Người mua</th>
                            <th>Địa chỉ</th>
                            <th>SĐT</th>
                            <th>Tình trạng</th>
                            <th>Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listOrder}" var="o">
                            <tr>
                                <td>${o.itemid}</td>
                                <td>${o.productname}, ${o.size}, topping:${o.topping}</td>
                                <td>${o.price}</td>
                                <td>${o.buydate}</td>
                                <td>${o.hoten}</td>
                                <td>${o.diachi}</td>
                                <td>${o.sdt}</td>
                                <td>${o.status}</td>
                                <td>
                                    <a href="edit-order?id=${o.itemid}&&cartid=${o.cartid}" class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Chỉnh sửa sản phẩm">&#xE254;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
        <!-- Edit Modal HTML -->

    </body>
</html>