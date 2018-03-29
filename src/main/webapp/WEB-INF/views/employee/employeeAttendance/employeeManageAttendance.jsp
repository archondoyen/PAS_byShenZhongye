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
<div class="container">
    <div class="row">
        <button onclick="signIn()" class="btn btn-success">上班签到</button>
        <button onclick="signOut()" class="btn btn-success" style="color:royalblue">下班打卡</button>
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
                        <c:choose>
                            <c:when test="${attend.startTime==null}">
                                <td style="color: red"><c:out value="上班未打卡"></c:out></td>
                            </c:when>
                            <c:otherwise>
                                <td><c:out value="${attend.startTime}"></c:out></td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${attend.endTime==null}">
                                <td style="color: red"><c:out value="下班未打卡"></c:out></td>
                            </c:when>
                            <c:otherwise>
                                <td><c:out value="${attend.endTime}"></c:out></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
            <a href="/emp/empReturnEntrance.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>