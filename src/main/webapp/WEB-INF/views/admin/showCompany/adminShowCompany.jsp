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
<%--模板--%>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <c:import url="../success.jsp"></c:import>
        </div>
        <div class="col-md-9">

        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <c:import url="../success.jsp"></c:import>
        </div>
        <div class="col-md-9">
            <table class="table table-bordered">
                <c:set value="${company}" var="comp"></c:set>
                <tr><td><c:out value="公司名称：${comp.CName}"></c:out></td></tr>
                <tr><td><c:out value="公司名称：${comp.CAddress}"></c:out></td></tr>
                <tr><td><c:out value="公司名称：${comp.CInfo}"></c:out></td></tr><br/>
                <a href="/admin/adminSuccess.do">返回</a>
            </table>
        </div>
    </div>
</div>
</body>
</html>