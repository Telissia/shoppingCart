<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>
<body>

<div class="card-header">
    商品列表
</div>
<div class="card-body">
    <table class="table">
        <thead class="thead-light">
        <tr>
            <th scope="col">商品编号</th>
            <th scope="col">商品名称</th>
            <th scope="col">商品图片</th>
            <th scope="col">商品价格</th>
            <th scope="col">去看看</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${searchlist }" var="mf">
            <tr>
                <td >${mf.id }</td>
                <td >${mf.gname }</td>
                <td><img
                        style="width: 50px; height: 50px;"
                        src="logos/${mf.gpicture }" border="0" title="${mf.gname }" />
                </td>
                <td>${mf.grprice }</td>
                <td><a
                        style="text-decoration: none;" class="f6"
                        href="#">去看看</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
<script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>