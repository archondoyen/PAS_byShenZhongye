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
    <title>新职位</title>
    <script>
        var deptAndJobArray;
        var deptSelectOption = document.getElementsByName("getDeptId");
/*        $(document).ready(function(){
            $.getJSON("Dept/showDeptAjax.view",function(data,status){
                alert("Data: " + data + "nStatus: " + status);
                deptAndJobArray = data;
                addDept();
            });
        });*/
        $.ajax({
            url:"Dept/showDeptAjax.view",
            type: "get",
            async: false,
            timeout: 5000,
            dataType: "json",
            success:function (data,status) {
                deptAndJobArray=data;
                console.log(data);
                console.log(status);
                addDept();
                console.log(data[0].id);
                console.log(data[0].deptName);
            }
        });
        function addDept(){
            deptSelectOption.length = deptAndJobArray.length;
            for(var i=0;i<deptSelectOption.length;i++){
                deptSelectOption.options[i].value=deptAndJobArray[i].id;
                deptSelectOption.options[i].text=deptAndJobArray[i].deptName;
            }
        }
        function addDeptAndJob(){
            var deptId = deptAndJobArray[0].id;
            console.log(deptId);
            $.get("admin/adminAddJob.do",{deptId:deptId});
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form name="form1" action="admin/adminAddJob.do">
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
                    <tr>
                        <td>
                                <select name="getDeptId">
                                    <option value="-1" >选择部门</option>
                                </select>
                        </td>
                        <td>
                            <input type="text" name="jName" placeholder="职位名称">
                        </td>
                        <td>
                            <input type="number" name="sal" placeholder="工资水平">
                        </td>
                        <td>
                            <label>
                                <select>
                                    <option value="-1" id="jobTypeFirstId">
                                    </option>
                                </select>
                            </label>
                        </td><td>
                            <label>
                                <select>
                                    <option value="-1" id="jobTypeSecondId">
                                    </option>
                                </select>
                            </label>
                        </td>
                        <td>
                            <input type="text" name="jInfo" placeholder="职位详情">
                        </td><td>
                        <input type="reset" class="btn btn-danger" value="清除">
                        <input type="submit" class="btn btn-success" value="提交" onclick="addDeptAndJob()">
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