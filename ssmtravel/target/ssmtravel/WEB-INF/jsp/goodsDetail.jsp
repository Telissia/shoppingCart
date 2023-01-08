<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col">
        <div class="card">
            <h5 class="card-header">${goods.gname }</h5>
            <div class="card-body">
                <table class="table">
                    <thead class="thead-light">
                    <tr>
                        <th scope="col">名称</th>
                        <th scope="col">原价</th>
                        <th scope="col">折扣价</th>
                        <th scope="col">库存</th>
                        <th scope="col">图片</th>
                        <th scope="col">类型</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            ${goods.gname }
                        </td>
                        <td>
                            ${goods.goprice }
                        </td>
                        <td>
                            ${goods.grprice }
                        </td>
                        <td>
                            ${goods.gstore }
                        </td>
                        <td>
                            <c:if test="${goods.gpicture != '' }">
                                <input type="hidden" name="id" value="${goods.id }"/>
                                <img alt="" width="300" height="250"
                                     src="/Logos/${goods.gpicture}"/>
                            </c:if>
                        </td>
                        <td>
                            ${goods.typename }
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
<script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>