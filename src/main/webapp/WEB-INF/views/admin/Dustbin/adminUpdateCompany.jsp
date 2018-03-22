<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>公司信息</title>
</head>
<body>
<c:import url="../success.jsp"></c:import>
<div class="container">
    <div class="col-md-12">
        <form class="table-bordered" action="/company/addCompany.do">
            <h3>更新公司信息</h3>
            公司名称：<input type="text" name="cName" placeholder=""></br>
            公司地址：<input type="text" name="cAddress"></br>
            公司简介：<input type="text" name="cInfo"></br>
            <input type="submit" value="提交">
            <input type="reset" value="重置">
        </form>
    </div>
</div>

</body>
</html>
