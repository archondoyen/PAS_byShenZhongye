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
    <title>新招聘</title>
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
            <form name="form1" action="/recruit/adminAddRecruit.do">
                <table class="table table-bordered">
                    <caption>发布招聘</caption>
                    <tr>
                        <%--<th>公司名称</th>
                        <th>部门名称</th>
                        <th>职位名称</th>
                        <th>一级标签</th>
                        <th>二级标签</th>--%>
                        <td>DeptAndJobId</td>
                            <td><input type="number" name="jobAndDeptId"></td>
                        <td>招聘人数</td>
                            <td><input type="number" name="workerNumber"></td>
                        <td>工作类型</td>
                            <td><textarea name="workType"></textarea></td>
                        <td>工作地点</td>
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