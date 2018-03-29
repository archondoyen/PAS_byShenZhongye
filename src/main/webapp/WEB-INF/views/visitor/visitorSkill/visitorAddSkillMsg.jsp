<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>新增技能</title>
    <script>
    </script>
</head>
<body>
<span>${info}</span>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="/skill/visiotrAddSkill.do">
                <table class="table table-bordered">
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" value="${sessionScope.visitor.VName}" readonly="readonly"><br/></td>
                    </tr><tr>
                        <td>技能名称</td>
                        <td><input type="text" name="sName"><br/></td>
                    </tr><tr>
                        <td>证书</td>
                        <td><input type="text" name="certificate"><br/></td>
                    </tr>
                    <tr><td><button type="submit">提交</button><br/></td></tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>