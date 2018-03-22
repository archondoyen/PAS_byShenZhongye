<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>管理员登录</title>
</head>
<body>
<h3>${info}</h3>
<form action="/Dept/adminNewDept.do" method="post">
    部门名：<input type="text" name="deptName"></br>
    部门详情：<input type="text" name="deptInfo"></br>
    <input type="submit" value="提交">
    <input type="reset" value="重置">
    <a href="/admin/adminSuccess.do">返回</a>
</form>
</body>
</html>