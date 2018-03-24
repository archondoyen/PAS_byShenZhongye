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
    <style>
        .navbar-header ,.container-fluid{
            background-color: #ff7e8e;
        }
    </style>
    <script>
        $(document).ready(function () {
            $.ajax({
                url:"notice/getNoticeNum.view",
                type:"post",
                success:function xx(data) {
                    $("#nociceNumber").html(data);
                }
            });
        });
    </script>
    <title>访客首页</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/visitor/visitorMain.entrance">游客首页</a>
        </div>
        <div>
            <c:choose>
                <c:when test="${visitor!=null}">
                    <a class="navbar-text navbar-left" href=""><c:out value="${visitor.VName}"></c:out></a>
                </c:when>
                <c:otherwise>
                    <a class="navbar-text navbar-left" href="/visitor/visitorTop.entrance">请登录</a>
                </c:otherwise>
            </c:choose>
            <a class="navbar-text navbar-left" href="/notice/visitorViewNoticeNotRead.view">消息</a>
            <span id="nociceNumber"></span>
            <a class="navbar-text navbar-left" href="/recruit/showRec">找工作</a>
            <li></li>
            <a class="navbar-text navbar-left" href="">写简历</a>
            <a class="navbar-text navbar-left" href="">简历管理</a>
            <a class="navbar-text navbar-right" href="">退出</a>
        </div>
    </div>
</nav>
</body>
</html>
