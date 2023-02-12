<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Goods List</title>

    <meta name="Keywords" content="">
    <script src="${pageContext.request.contextPath }/static/js/Management/cartStorage.js" ></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
    <script type="text/javascript">
        function goCart()
        {
            var num = document.getElementById("SNUM").value;
            if (!(/(^[1-9]\d*$)/.test(num)))
            {
                alert("请输入正整数！！！")
                alert(num)
            }
            else
            {
                document.putcartform.submit();
            }
        }
        function clearValue(){
            document.myForm.mykey.value = "";
        }
        function postCart()
        {

            var xhr = new XMLHttpRequest();
            var url = "url";
            var tableId = document.getElementById("tab");
            xhr.open("POST", url, true);
            xhr.setRequestHeader("Content-Type", "application/json");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var json = JSON.parse(xhr.responseText);
                    console.log(json.Goods_Name + ", " + json.Goods_Price);
                }
            };
            for (var i = 1; i < tableId.rows.length; i++)
            {
                var content1 = tableId.rows[i].ceil(1).innerHTML;
                var content2 = tableId.rows[i].ceil(2).innerHTML;
                var data = JSON.stringify({"Goods_Name": content1, "Goods_Price": content2});
            }
            xhr.send(data);
        }
    </script>

</head>
<body>
    <div class="container">
    <div class="row clearfix">
        <div class="col-md-12 flex-column">
            <div class="page-header">
                <h1>
                    <small>Goods List - Show All Goods</small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 flex-column">
                <h1>
                    <small>Add New Goods
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/goods/toAddGoods">Add New Goods</a>
                    </small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 flex-column">
                <h1>
                    <small>Query Cart
                        <a class="btn btn-primary" href="selectCart.jsp" target="_blank">Query Cart</a>
                    </small>
                </h1>
            </div>
        </div>

        <div class="row">
            <div class="col-md-16 flex-column">
                <form action="${pageContext.request.contextPath}/index/search" name="myForm" method="post">
                    <input type="text" name="mykey" class="txt" value="please enter the content"  onfocus="clearValue()" />
                    <button type="submit" class="btn-primary">search now</button>
                </form>
            </div>
        </div>

        <div class="row">
            <div class="col-md-8 flex-column">
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/index/toRegister">register</a>
                    </li>
                </ul>
                <ul>
                    <c:if test="${bruser!=null}"><li>Welcome ${bruser.bemail }</li></c:if>
                    <c:if test="${bruser==null}"><li><a href="${pageContext.request.contextPath}/user/login">Login</a></li></c:if>
                    <c:if test="${bruser!= null}">
                        <li><a href="user/exit">exit</a></li>
                    </c:if>
                </ul>
            </div>
        </div>

    </div>


        <div class="card">
            <div class="card-header">
                Goods List
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/cart/putCart" name="putcartform" method="post">
                <table class="table" id="tab">
                    <thead>
                    <tr>
                        <th scope="col">Goods_ID</th>
                        <th scope="col">Goods_Name</th>
                        <th scope="col">Goods_Price</th>
                        <th scope="col">Goods_Store</th>
                        <th scope="col">Goods_Details</th>
                        <th scope="col">Do you like it?</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list }" var="goods">
                        <tr>
                            <td>${goods.id }</td>
                            <td>${goods.gname }</td>
                            <td>${goods.grprice }</td>
                            <td>${goods.gstore }</td>
                            <td><a href="${pageContext.request.contextPath}/goods/selectAGoods?id=${goods.id }" target="_blank">GoodsDetails</a></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/cart/putCart" name="putcartform" method="post">
                                    <input type="hidden" name="id" value="${goods.id }"/>
                                    <input type="text" name="shoppingnum" size="3" id="SNUM" value="1"/>
                                    <button type="submit" class="btn-primary" onclick="goCart()">Add it to Cart</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="5" align="right">
                            &nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;A total of&nbsp;${totalCount}&nbsp;records&nbsp;&nbsp;A total of &nbsp; ${totalPage} &nbsp; pages&nbsp;&nbsp;
                            The&nbsp;${pageCur}&nbsp;page&nbsp;&nbsp;
                            <c:url var="url_pre" value="${pageContext.request.contextPath}/goods/allGoods">
                                <c:param name="pageCur" value="${pageCur - 1 }"/>
                            </c:url>
                            <c:url var="url_next" value="${pageContext.request.contextPath}/goods/allGoods">
                                <c:param name="pageCur" value="${pageCur + 1 }"/>
                            </c:url>
                            <!-- 第一页没有上一页 -->
                            <c:if test="${pageCur != 1 }">
                                <a href="${url_pre}">Last Page</a>&nbsp;&nbsp;&nbsp;&nbsp;
                            </c:if>
                            <!-- 最后一页，没有下一页 -->
                            <c:if test="${pageCur != totalPage && totalPage != 0}">
                                <a href="${url_next}">Next Page</a>
                            </c:if>
                        </td>
                    </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </div>

    </div>
    <script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>

</body>
</html>
