<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<body>
<head>
    <title>Index Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>

<div class="container">
    <a href="${pageContext.request.contextPath}/goods/allGoods"><img src="${pageContext.request.contextPath}/static/images/user.jpg" class="img-fluid" alt="User"></a>
    <a href="${pageContext.request.contextPath}/goods/allGoods"><img src="${pageContext.request.contextPath}/static/images/admin.jpg" class="img-fluid" alt="Admin"></a>
</div>

<script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
<script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>

</body>
</html>
