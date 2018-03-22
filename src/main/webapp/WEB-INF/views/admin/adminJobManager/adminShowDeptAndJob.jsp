<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script>
        var oper;
        function modify(oper) {

        }
        function modifyDo() {

        }
        function del(oper) {

        }
    </script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <th>部门名称</th>
                    <th>职位名称</th>
                    <th>工资</th>
                    <th>操作</th>
    <%--                <th>部门人数</th>
                    <th>职位人数</th>--%>
                </tr>
                <c:forEach items="${deptAndJobs}"  var="deptOfMyComp">
                    <tr>
                       <td><c:out value="${deptOfMyComp.department.deptName}"></c:out></td>
                       <td><c:out value="${deptOfMyComp.job.JName}"></c:out></td>
                       <td><c:out value="${deptOfMyComp.job.sal}"></c:out></td>
                        <td><input type="button" class="btn-danger" value="删除"> </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/admin/adminSuccess.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>