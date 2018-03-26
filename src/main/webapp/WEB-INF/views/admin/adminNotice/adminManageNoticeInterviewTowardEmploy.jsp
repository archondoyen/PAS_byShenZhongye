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
    <title>面试是否录用</title>
    <script>
        function del(trIndex,noticeId) {
            $.ajax({
                url:"notice/delNotice.do",
                data:noticeId,
                success:function (data) {
                    alert(data);
                }
            });
        }function overRead(trIndex,noticeId) {
            $.ajax({
                url:"notice/readNotice.do",
                data:noticeId,
                success:function (data) {
                    alert(data);
                }
            });
        }function employ(noticeId,targetId,content) {
            var sal=prompt("请输入工资","2000.00");
            var deptAndJobId = prompt("请输入公司部门id","0");
            $.ajax({
                url:"emp/changeVisitorToEmployeeByInterviewNotice.do",
                data:{"noticeId":noticeId,"noticeContent":content,"noticeTargetId":targetId,"sal":sal,"deptAndJobId":deptAndJobId},
                success:function (info) {
                    alert(info);
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
                    <th>消息详情</th>
                    <th>消息类型</th>
                    <th>时间</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${noticeList}" var="notice">
                    <tr>
                        <td><c:out value="${notice.noticeContent}"></c:out></td>
                        <td><c:out value="${notice.noticeType}"></c:out></td>
                        <td><c:out value="${notice.createTime}"></c:out></td>
                        <td>
                            <button class="btn btn-danger" id="delNotice" onclick="del(this,${notice.id})">删除</button>
                            <button class="btn btn-success" id="readNotice" onclick="overRead(this,${notice.id})">我知道了</button>
                            <button class="btn btn-link" id="interViewNotice" onclick="employ(${notice.id},${notice.senderId},${notice.noticeContent})">成为同事</button>
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