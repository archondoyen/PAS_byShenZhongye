<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>旅客登录</title>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form action="visitor/visitorLog.do">
        用户名：<input type="text" name="vName"></br>
        密码：<input type="password" name="vPassword"></br>
            <input type="submit" value="提交">
        </form>
    </div>
</div>

</body>
</html>