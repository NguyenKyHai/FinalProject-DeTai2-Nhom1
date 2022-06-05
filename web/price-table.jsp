<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>Price</title>
    <link rel="stylesheet" href="templates/template.css">
</head>
<body>
    <%@include file="common/header.jsp" %>
    <h2>Bảng giá</h2>
    <style>  
        body{
            padding: 0px;
            margin: 0px;
        }    
        .container{
            display: flex;
            padding: 30px;
            justify-content: space-around;
        }
        table, th, td {  
            border: 1px solid #907c66;  
            text-align: center;
        }  
        h2{
            text-align: center;
        }
        img{
            width: 60px;
        }
        th, td {  
            padding: 10px 30px;  
        }  
        </style>
    <div class="container">
        <table border="2">  
            <tr><th>Tên đồ uống</th><th>Size</th><th>Giá</th></tr>    
            <tr><td>Hồng trà</td><td>S</td><td>28K</td></tr>  
            <tr><td>Hồng trà</td><td>M</td><td>36K</td></tr>  
            <tr><td>Hồng trà</td><td>L</td><td>44K</td></tr>  
            <tr><td>Trà sữa</td><td>S</td><td>24K</td></tr>
            <tr><td>Trà sữa</td><td>M</td><td>28K</td></tr>  
            <tr><td>Trà sữa</td><td>L</td><td>32K</td></tr>  
            <tr><td>Trà Ô long</td><td>S</td><td>28K</td></tr>
            <tr><td>Trà Ô long</td><td>M</td><td>32K</td></tr>  
            <tr><td>Trà Ô long</td><td>L</td><td>40K</td></tr> 
            <tr><td>Trà trái cây</td><td>S</td><td>25K</td></tr>
            <tr><td>Trà trái cây</td><td>M</td><td>30K</td></tr>  
            <tr><td>Trà trái cây</td><td>L</td><td>35K</td></tr> 
        </table>

        <table border="1">  
            <tr><th>Hình ảnh</th><th>Tên Topping</th><th>Giá</th></tr>  
            <tr><td><img src="images/tranchau.png"></td><td>Trân châu (t1)</td><td>5K</td></tr>  
            <tr><td><img src="images/thachtraicay.jpg"></td><td>Thạch trái cây (t2)</td><td>5K</td></tr>  
            <tr><td><img src="images/raucau.png"></td><td>Râu câu (t3)</td><td>5K </td></tr>  
            <tr><td><img src="images/flan.png"></td><td>Bánh Flan (t4)</td><td>10K </td></tr>  
            <tr><td><img src="images/kemphomai.jpg"></td><td>Kem Cheese (t5)</td><td>10K </td></tr> 
        </table>
    </div>  
</body>
<footer>
    <img src="images/logo.png">
</footer>
</html>
