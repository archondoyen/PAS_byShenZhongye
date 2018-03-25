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
    <title>新培训</title>
    <script>
        var deptAndJobArray;
        var deptSelectOption = document.getElementsByName("djId");
        $(document).ready(function(){
            $.ajax({
                url:"deptAndJob/showJobAjax.view",
                type: "get",
                async: false,
                timeout: 5000,
                dataType: "json",
                success:function (data,status) {
                    deptAndJobArray=data;
                    console.log(data);
                    console.log(status);
                }
            });
        });

    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form name="form1" action="/empAndTrain/adminNewTrain.do">
                <table class="table table-bordered">
                    <caption>新培训</caption>
                    <tr>
                        <td>员工id</td>
                            <td><input type="number" name="empId"></td>
                        <td>教练</td>
                            <td><input type="text" name="coach"></td>
                        <td>开始时间</td>
                            <td><input type="date" name="startTime"></td>
                        <td>完讯时间</td>
                            <td><input type="date" name="endTime"></td>
                        <td>培训详情</td>
                            <td><textarea name="trainContent"></textarea></td>
                        <td>培训地点</td>
                            <td><input type="text" name="workLocation"></td>
                            <td colspan="2">
                                <input type="reset" value="重置">
                            </td>
                            <td colspan="5">
                                <input type="submit" value="保存" >
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