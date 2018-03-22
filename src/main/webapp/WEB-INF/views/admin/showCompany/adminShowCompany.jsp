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
            <c:set value="${requestScope.company}" var="company"></c:set>
            <h3>我的公司信息</h3><c:out value="${requestScope.info}"></c:out>
            <c:out value="公司名称：${company.cName}"></c:out></br>
            <c:out value="公司地址：${company.cAddress}"></c:out></br>
            <c:out value="公司简介：${company.cInfo}"></c:out></br>
            <a href="/admin/adminSuccess.do">返回</a>
    </div>
</div>
</body>
</html>