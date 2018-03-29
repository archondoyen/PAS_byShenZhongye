<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>基本信息</title>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form action="/visitor/visitorAddPersonalMsg.do">
            用户名：<input type="text" value="${visitor.VName}" readonly="readonly"><br/>
            邮箱：<input type="email" value="${visitor.VEmail}" name="vEmail"><br/>
            身份证：<input type="text" value="${visitor.videntityCard}"><br/>
            性别：<input type="text" value="${visitor.VGender}" name="vGender"><br/>
            年龄：<input type="text" value="${visitor.VAge}" name="vAge"><br/>
            电话：<input type="tel" value="${visitor.VPhone}" name="vPhone"><br/>
            <button type="submit" value="提交"></button><br/>
        </form>
    </div>
</div>
</body>
</html>