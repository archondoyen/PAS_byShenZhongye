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
    <script src="/scripts/ajax.js"></script>
    <title>发送培训结果</title>
    <script>
        function overRead(trIndex,trainId) {
            var result = prompt("请输入评级：优秀-中-差","未评级");
            $.ajax({
                url:"empAndTrain/adminSetTrainResult.oper",
                data:{"trainId":trainId,"trainResult":result},
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
                    <th>培训内容</th>
                    <th>员工id</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${empAndTrainList}" var="eT">
                    <tr>
                        <td><c:out value="${eT.train.trainContent}"></c:out></td>
                        <td><c:out value="${eT.employee.empName}"></c:out></td>
                        <td><c:out value="${eT.train.startTime}"></c:out></td>
                        <td><c:out value="${eT.train.endTime}"></c:out></td>
                        <td>
                            <button class="btn btn-success" id="readNotice" onclick="overRead(this,${eT.train.id})">评分</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a href="/visitor/visitorMain.entrance">返回</a>
        </div>
    </div>
</div>
</body>
</html>