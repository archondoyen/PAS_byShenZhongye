<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <title>新建奖惩</title>
</head>
<body>
<div class="alert"><h3>${info}</h3></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form name="form1" action="/rewardAndPunish/adminNewRewardAndPunish.do">
                <table class="table table-bordered">
                    <tr>
                        <th>员工id</th>
                        <th>奖惩类型</th>
                        <th>详情</th>
                        <th>奖金/罚金</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" name="empId" placeholder="员工id">
                        </td>
                        <td>
                            <input type="text" name="rpType" placeholder="奖惩类型">
                        </td><td>
                            <input type="text" name="rpContent" placeholder="详情">
                        </td>
                        <td>
                            <input type="number" name="money" placeholder="奖金/罚金">
                        </td>
                        <td>
                        <input type="reset" class="btn btn-danger" value="清除">
                        <input type="submit" class="btn btn-success" value="提交">
                    </td>
                    </tr>
                </table>
            </form>
            <a href="/admin/adminSuccess.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>