<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 flex-column">
                <div class="page-header">
                    <h1>
                        <small>Add New Goods</small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/goods/addGoods" method="post">
            <div class="card">
                <h5 class="card-header">Add Goods</h5>
                <div class="card-body">
                    <div class="form-group">
                        <label for="gname">Goods Name:</label>
                        <input type="text" name="gname" class="form-control" id="gname" placeholder="Name" required>
                    </div>
                    <div class="form-group">
                        <label for="goodstype_id">Goods Type:</label>
                        <input type="text" name="goodstype_id" class="form-control" id="goodstype_id" placeholder="Type">
                    </div>
                    <div class="form-group">
                        <label for="gpicture">Goods Picture:</label>
                        <input type="text" name="gpicture" class="form-control" id="gpicture" placeholder="Picture">
                    </div>
                    <div class="form-group">
                        <label for="grprice">Goods RealPrice:</label>
                        <input type="text" name="grprice" class="form-control" id="grprice" placeholder="RPrice">
                    </div>
                    <div class="form-group">
                        <label for="goprice">Goods OriginalPrice:</label>
                        <input type="text" name="goprice" class="form-control" id="goprice" placeholder="OPrice">
                    </div>
                    <div class="form-group">
                        <label for="gstore">Goods Store:</label>
                        <input type="text" name="gstore" class="form-control" id="gstore" placeholder="Store">
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">sumbit</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>
</body>
</html>
