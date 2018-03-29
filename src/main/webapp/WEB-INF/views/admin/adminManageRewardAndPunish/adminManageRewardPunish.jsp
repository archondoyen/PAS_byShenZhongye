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
    <title>奖惩管理</title>
    <script>
        function del(trIndex,rpId) {
 /*           $.ajax({
                url:"empAndTrain/adminSetTrainResult.oper",
                data:{"trainId":trainId,"trainResult":result},
                success:function (data) {
                    alert(data);
                }
            });*/
        }
            function change(trIndex,rpId) {

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
                        <th>员工部门</th>
                        <th>员工职位</th>
                        <th>奖惩类型</th>
                        <th>详情</th>
                        <th>奖金/罚金</th>
                        <th>发布时间</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${rp}" var="rewardAndPunish">
                        <tr>
                            <td><c:out value="${rewardAndPunish.employee.empName}"></c:out> </td>
                            <td><c:out value="${rewardAndPunish.employee.deptAndJob.department.deptName}"></c:out></td>
                            <td><c:out value="${rewardAndPunish.employee.deptAndJob.job.JName}"></c:out></td>
                            <td><c:out value="${rewardAndPunish.rpType}"></c:out></td>
                            <td><c:out value="${rewardAndPunish.rpContent}"></c:out></td>
                            <td><c:out value="${rewardAndPunish.money}"></c:out></td>
                            <td><c:out value="${rewardAndPunish.rpTime}"></c:out></td>
                            <td>
                                <button value="删除" onclick="del(this,${rewardAndPunish.id})">删除</button>
                                <button value="修改" onclick="change(this,${rewardAndPunish.id})">修改</button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            <a href="/admin/adminSuccess.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>