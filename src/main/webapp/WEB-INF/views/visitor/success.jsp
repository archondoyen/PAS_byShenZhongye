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
                url:"notice/visitorGetNoticeNum.view",
                type:"post",
                success:function (data) {
                    $("#nociceNumber").html(data);
                }
            });
        });
    </script>
    <title>访客首页</title>
</head>
<body>
<p>${info}</p>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/visitor/visitorMain.entrance">游客首页</a>
        </div>
        <div>
            <c:choose>
                <c:when test="${sessionScope.visitor!=null}">
                    <a class="navbar-text navbar-left"><c:out value="欢迎${sessionScope.visitor.VName}"></c:out></a>
                </c:when>
                <c:otherwise>
                    <a class="navbar-text navbar-left" href="/visitor/visitorTop.entrance">请登录</a>
                </c:otherwise>
            </c:choose>
            <a class="navbar-text navbar-left" href="/notice/visitorViewNoticeNotRead.view">消息
                <span id="nociceNumber" style="color: red"></span>
            </a>
            <a class="navbar-text navbar-left">完善信息
                <ul>
                    <li><a class="navbar-text navbar-left" href="/visitor/visitorAddPesonalMsg.entrance">基本信息</a></li>
                    <li><a class="navbar-text navbar-left" href="/recruit/showRec">技能&证书</a></li>
                    <li><a class="navbar-text navbar-left" href="/recruit/showRec">工作经历</a></li>
                    <li><a class="navbar-text navbar-left" href="/recruit/showRec">教育经历</a></li>
                </ul>
            </a>
            <a class="navbar-text navbar-left" href="/recruit/showRec">找工作</a>
            <a class="navbar-text navbar-left" href="">写简历</a>
            <a class="navbar-text navbar-left" href="">简历管理</a>
            <a class="navbar-text navbar-right" href="/logOut.do">退出</a>
        </div>
    </div>
</nav>
</body>
</html>
