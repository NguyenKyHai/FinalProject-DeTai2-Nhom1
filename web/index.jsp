<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
        <link rel="stylesheet" href="templates/template.css">
        <title>Drink Web</title>
    </head>
    <body>
        <%@include file="common/header.jsp" %>

        <div id="product">
            <div class="item">
                <img class="img_item" src="${sessionScope.hongtra_img}">
                <div class="container">
                    <p class="tittle">Hồng trà</p>
                    <p class="size">(size: S)</p>
                </div>
                <p class="content">
                    Hồng trà cũng được gọi là trà đen (black tea) xuất phát từ tên gọi của người phương Tây khi dựa vào màu sắc của lá trà sau khi được sấy khô.
                </p>
                <p class="price">28 K</p>
                <a class="add_topping" href="detail?id=1">
                    Mua hàng
                    <i class="fa fa-angle-double-right"></i>
                </a></br>    
            </div>
            <div class="item">
                <img class="img_item" src="${sessionScope.trasua_img}">
                <div class="container">
                    <p class="tittle">Trà sữa</p>
                    <p class="size">(size: S)</p>
                </div>
                <p class="content">
                    Trà sữa là loại trà kết hợp giữa trà và sữa. Nhắc đến trà sữa, chúng ta nghĩ ngay đến những ly trà sữa mát lạnh với những hạt trân châu dẻo ngọt.
                </p>
                <p class="price">${trasua} K</p>
                <a class="add_topping" href="detail?id=2">
                    Mua hàng
                    <i class="fa fa-angle-double-right"></i>
                </a></br>
            </div>
            <div class="item">
                <img class="img_item" src="images/traolong.png">
                <div class="container">
                    <p class="tittle">Trà Ô long</p>
                    <p class="size">(size: S)</p>
                </div>
                <p class="content">
                    Trà Ô Long được cả thế giới đánh giá cao về phẩm chất rất tốt của nó: trà thơm, giàu mùi vị, hậu vị kéo dài, nước dày… Tất cả đều rất tinh tế.
                </p>
                <p class="price">28 K</p>
                <a class="add_topping" href="detail?id=3">
                    Mua hàng
                    <i class="fa fa-angle-double-right"></i>
                </a></br>
            </div>
            <div class="item">
                <img class="img_item" src="images/tratraicay.png">
                <div class="container">
                    <p class="tittle">Trà trái cây</p>
                    <p class="size">(size: S)</p>
                </div>
                <p class="content">
                    Trà trái cây cũng là một trong những thực đơn giảm cân rất tốt trong mùa hè này đó. Nó sẽ giúp các bạn giải nhiệt cho mình và cả gia đình.
                </p>
                <p class="price">25 K</p>
                <a class="add_topping" href="detail?id=4">
                    Mua hàng
                    <i class="fa fa-angle-double-right"></i>
                </a></br>
            </div>
        </div>

    </body>
    <footer>
        <img src="images/logo.png">
    </footer>
</html>