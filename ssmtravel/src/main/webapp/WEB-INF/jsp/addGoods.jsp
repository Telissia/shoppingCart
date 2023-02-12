<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
            <div class="card">
                <h5 class="card-header">Add Goods</h5>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/goods/addGoods" method="post" modelAttribute="goods" enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="gname">Goods Name:</label>
                            <input type="text" name="gname" class="form-control" id="gname" placeholder="Name" >
                        </div>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect01">Type Options</label>
                            </div>
                                <select name="goodstype_id" id="inputGroupSelect01">
                                    <c:forEach items="${goodsType}" var="g">
                                        <option value="${g.id}">${g.typename}</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="form-group">
                            <label for="logoImage">Goods Picture:</label>
                            <input type="file" name="logoImage" class="form-control" id="logoImage" placeholder="Picture">
                        </div>
                        <div class="form-group">
                            <img id="fileImage" alt="Picture Preview">
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
                        </form>
<%--                    &lt;%&ndash;@elvariable id="goods" type="com.teldrasill.pojo.Goods"&ndash;%&gt;--%>
<%--                    <form:form action="${pageContext.request.contextPath}/goods/addGoods" method="post" modelAttribute="goods" enctype="multipart/form-data">--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="gname">Goods Name:</label>--%>
<%--                        <form:input path="gname" class="form-control" id="gname" placeholder="Name" ></form:input>--%>
<%--                    </div>--%>
<%--                    <div class="input-group mb-3">--%>
<%--                        <div class="input-group-prepend">--%>
<%--                            <label class="input-group-text" for="inputGroupSelect01">Options</label>--%>
<%--                        </div>--%>
<%--                        <form:select path="goodstype_id" class="form-control" id="inputGroupSelect01">--%>
<%--                        <form:option value=""> 请选择.... </form:option>--%>
<%--                        <form:options items="${goodsType }" itemLabel="typename" itemValue="id"/>--%>
<%--                        </form:select>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="logoImage">Goods Picture:</label>--%>
<%--                        <input type="file" name="logoImage" class="form-control" id="logoImage" placeholder="Picture"></input>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <img id="fileImage" alt="Picture Preview">--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="grprice">Goods RealPrice:</label>--%>
<%--                        <form:input path="grprice" class="form-control" id="grprice" placeholder="RPrice"></form:input>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="goprice">Goods OriginalPrice:</label>--%>
<%--                        <form:input path="goprice" class="form-control" id="goprice" placeholder="OPrice"></form:input>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <label for="gstore">Goods Store:</label>--%>
<%--                        <form:input path="gstore" class="form-control" id="gstore" placeholder="Store"></form:input>--%>
<%--                    </div>--%>
<%--                    <div class="form-group">--%>
<%--                        <button type="submit" class="btn btn-primary">sumbit</button>--%>
<%--                    </div>--%>
<%--                    </form:form>--%>
                </div>
            </div>


    </div>
    <script src="${pageContext.request.contextPath }/static/js/jquery/jquery-3.6.0.min.js" ></script>
    <script src="${pageContext.request.contextPath }/static/bootstrap-4.6.1-dist/js/bootstrap.bundle.min.js" ></script>
    <script type="text/javascript">
        $(document).ready(function ()
        {
            $('#logoImage').change(function ()
            {
                showImageFile(this);
            })
        });

        function showImageFile(fileInput)
        {
            file = fileInput.files[0];
            reader = new FileReader();

            reader.onload = function (e)
            {
                $('#fileImage').attr('src', e.target.result);
            };

            reader.readAsDataURL(file);
        }
    </script>
</body>
</html>
