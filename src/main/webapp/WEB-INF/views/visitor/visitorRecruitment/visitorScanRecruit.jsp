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
    <title>找工作，上海同</title>
</head>
<body>
<div id="alert"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <th>公司</th>
                    <th>部门</th>
                    <th>职位</th>
                    <th>工资</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${Recruit}" var="rec">
                    <tr>
                        <td><c:out value="${rec.deptAndJob.company.CName}"></c:out></td>
                        <td><c:out value="${rec.deptAndJob.department.deptName}"></c:out></td>
                        <td><c:out value="${rec.deptAndJob.job.JName}"></c:out></td>
                        <td><c:out value="${rec.deptAndJob.job.sal}"></c:out></td>
                        <td>
                            <a class="btn-success btn" href="">投递</a>
                            <a class="btn-success btn" href="/recruit/showRec/${rec.id}">详情</a>
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