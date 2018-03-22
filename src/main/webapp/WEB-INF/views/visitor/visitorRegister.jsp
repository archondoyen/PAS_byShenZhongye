<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>旅客注册</title>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form action="/visitor/visitorReg.do">
            用户名：<input type="text" name="vName"></br>
            密码：<input type="password" name="vPassword"></br>
            邮箱：<input type="email" name="vEmail"></br>
            身份证：<input type="text" name="vIdentityCard"></br>
            性别：<input type="text" name="vGender"></br>
            年龄：<input type="text" name="vAge"></br>
            电话：<input type="tel" name="vPhone"></br>
            照片：<input type="file" name="vPhoto"></br>
            <input type="submit" value="提交"></br>
        </form>
    </div>
</div>

</body>
</html>