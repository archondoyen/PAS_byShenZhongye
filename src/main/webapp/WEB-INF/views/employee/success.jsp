<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <meta charset="utf-8">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <style>
        .navbar-header ,.container-fluid{
            background-color: #39ff43;
        }
    </style>
    <script>
        $(document).ready(function () {
            $.ajax({
                url:"notice/empGetNoticeNum.view",
                type:"get",
                success:function (data,status) {
                    console.log(data);
                    $("#nociceNumber").html(data);
                }
            });
        });
    </script>
    <title>员工首页</title>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/emp/empReturnEntrance.do">员工首页</a>
        </div>
        <div>
            <c:choose>
                <c:when test="${sessionScope.employee!=null}">
                    <a class="navbar-text navbar-left"><c:out value="欢迎${sessionScope.employee.empName}！"></c:out></a>
                </c:when>
                <c:otherwise>
                    <a class="navbar-text navbar-left" href="/visitor/visitorTop.entrance">请登录</a>
                </c:otherwise>
            </c:choose>
            <a class="navbar-text navbar-left" href="/attendance/empAttendance.entrance">打卡</a>
            <a class="navbar-text navbar-left" href="/notice/empViewNoticeNotRead.view">消息
                <span id="nociceNumber" style="color: red"></span></a>
            <a class="navbar-text navbar-left" href="/salay/employeeGetSalay.entrance">领工资</a>
            <a class="navbar-text navbar-right" href="/logOut.do">退出</a>
        </div>
    </div>
</nav>
</body>
</html>
