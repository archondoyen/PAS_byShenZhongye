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
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>工资管理</title>
    <script>
        function iKnow(trIndex,salId) {

        }
        function getSal(trIndex,salId) {
            $.ajax({
                url:"salay/employyGetSalay.oper",
                data:{"salayIdStr":salId},
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
        <div class="col-md-12">
                <table class="table table-bordered">
                    <tr>
                        <th>员工名字</th>
                        <th>部门</th>
                        <th>职位</th>
                        <th>工作表现</th>
                        <th>奖金/罚金</th>
                        <th>领取时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${salayList}" var="salay">
                        <tr>
                            <td><c:out value="${salay.employee.empName}"></c:out></td>
                            <td><c:out value="${salay.employee.deptAndJob.department.deptName}"></c:out></td>
                            <td><c:out value="${salay.employee.deptAndJob.job.JName}"></c:out></td>
                            <td><c:out value="${salay.workerPerformance}"></c:out></td>
                            <td><c:out value="${salay.rewardAndPunish}"></c:out></td>
                            <td><c:out value="${salay.getSalDate}"></c:out></td>
                            <td>
                                <button value="我知道了" onclick="iKnow(this,${salay.id})"></button>
                                <button value="领工资" onclick="getSal(this,${salay.id})"></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            <a href="/emp/empReturnEntrance.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>