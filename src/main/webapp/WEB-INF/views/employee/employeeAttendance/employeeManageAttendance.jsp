<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <title>考勤</title>
    <script>
        function signIn() {
            $.ajax({
                url:"attendance/empSignIn.oper",
                success:function (data) {
                    alert(data);
                }
            });
        }function signOut() {
            $.ajax({
                url:"attendance/empSignOut.oper",
                success:function (data) {
                    alert(data);
                }
            });
        }
    </script>
</head>
<body>
<div class="alert">${info}</div>
<div class="container">
    <div class="row">
        <button onclick="signIn()" value="上班签到" class="btn btn-success"></button>
        <button onclick="signOut()" value="下班打卡" class="btn btn-link"></button>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <th>姓名</th>
                    <th>签到时间</th>
                    <th>签退时间</th>
                </tr>
                <c:forEach items="${attendances}" var="attend">
                    <tr>
                        <td><c:out value="${attend.employee.empName}"></c:out></td>
                        <td><c:out value="${attend.starttime}"></c:out></td>
                        <td><c:out value="${attend.endtime}"></c:out></td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/emp/empReturnEntrance.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>