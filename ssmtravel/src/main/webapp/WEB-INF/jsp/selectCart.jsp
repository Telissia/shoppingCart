<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script type="text/javascript">
        function testNumber()
        {
            var num = document.getElementById("IRS").value;
            if (!(/(^[1-9]\d*$)/.test(num)))
            {
                alert("请输入正整数！！！")
            }
            else
            {
                document.updatecartform.submit();
            }
        }
        //确认
        function  goOrderConfirm(){
            window.location.href="/ssmtravel_war/cart/orderConfirm";
        }
    </script>
</head>
<body>

<div class="container">

    <div class="card">
        <div class="card-header">
            Cart List
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Goods_GName</th>
                    <th scope="col">Goods_Price</th>
                    <th scope="col">Shopping_num</th>
                    <th scope="col">Small_Total</th>
                    <th scope="col">GoodsDetails</th>
                    <th scope="col">UpdateGoods</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="ce" items="${cartlist}">
                    <tr>
                        <td>${ce.gname}</td>
                        <td>${ce.grprice}</td>
                        <td>${ce.shoppingnum }</td>
                        <td>${ce.smallsum }</td>
                        <td><a href="${pageContext.request.contextPath}/goods/selectAGoods?id=${ce.id }">GoodsDetails</a></td>
                        <td>
                            <form action="${pageContext.request.contextPath}/cart/deleteAgoods" method="post" name="updatecartform">
                                <img src="${pageContext.request.contextPath }/static/images/cart-1.svg"  height="50" style="cursor: pointer" onclick="testNumber()">

                                <input type="hidden" name="id" value="${ce.id }"/>
                                <input type="hidden" name="shoppingnum" value="${ce.shoppingnum }">

                                <input type="number" name="reshoppingnum" id="IRS">

                                <img src="${pageContext.request.contextPath }/static/images/cart-1.svg"  height="50" style="cursor: pointer" onclick="testNumber()">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <td>Total : ${total}</td>
                <td><a href="javascript:goOrderConfirm()"><img src="${pageContext.request.contextPath }/static/images/cart-1.svg"></a></td>
                </tbody>
            </table>
        </div>
    </div>



</div>
<script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
<script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>
