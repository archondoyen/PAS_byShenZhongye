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
    <title>职位管理</title>
    <script>
        var oper;
        function modify(oper) {

        }
        function del(oper) {

        }
    </script>
</head>
<body>
<c:set value="${jobTypeList}" var="jobType"></c:set>
<c:set value="${jobs}" var="jobList"></c:set>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <th>部门名称</th>
                    <th>职位名称</th>
                    <th>工资水平</th>
                    <th>一级标签</th>
                    <th>二级标签</th>
                    <th>职位详情</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${jobList}" var="jList">
                    <tr>
                        <td><c:out value="${jList.}"></c:out></td>
                        <td><c:out value="${jList.deptInfo}"></c:out></td>
                        <td>
                            <button class="btn-success btn" onclick="modify(this)">修改</button>
                            <button class="btn-success btn" onclick="del(this)">删除</button>
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