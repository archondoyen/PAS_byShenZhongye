<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>工作经验</title>
    <script>
    </script>
</head>
<body>
<span>${info}</span>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="/exp/visitorAddWorkExp.do">
                <table class="table table-bordered">
                    <tr>
                        <td>用户名</td>
                        <td><input type="text" value="${sessionScope.visitor.VName}" readonly="readonly"></td>
                    </tr><tr>
                        <td>开始时间</td>
                        <td><input type="date" name="startDate1"></td>
                    </tr><tr>
                        <td>截止时间</td>
                        <td><input type="date" name="endDate1"></td>
                    </tr><tr>
                        <td>详情&奖励&职位</td>
                        <td><input type="text" name="positionRewarding"></td>
                    </tr>
                    <tr><td><button type="submit" >提交</button></td></tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>