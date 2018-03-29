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
/*        var deptSelectOption = document.form1.deptName;
        var jobSelectOption = document.form1.jobName;*/
        var deptSelectOption;
        var jobSelectOption;
        var deptArray;
        var jobArray;
        $(document).ready(function(){
            /*$.ajax({
                url:"deptAndJob/showJobAjax.view",
                type: "get",
                async: false,
                timeout: 5000,
                dataType: "json",
                success:function (data,status) {
                    deptArray=data;
                    console.log(deptArray);
                    $("#compName").val(deptArray[0].company.cname);
                    addDeptName();
                }
            });*/
            deptArray = ${dList};
            deptSelectOption = document.getElementById("deptName1");
            jobSelectOption = document.getElementById("jobName1");
            deptSelectOption.length = ${dSize};
            addDeptName();
        });
        function addDeptName(){
            console.log('部门'+deptSelectOption.length);
            for(var i=0;i<deptSelectOption.length;i++){
                deptSelectOption.options[i].value = deptArray[i].id;
                deptSelectOption.options[i].text = deptArray[i].deptName;
            }
            addJobName(0);
        }
        function addJobName(thisIndex) {
            var deptId = $('#deptName1').val();
            console.log('deptIdStr,'+deptId);
            jobSelectOption.length = getJobNum(deptId);
            console.log('工作'+jobSelectOption.length);
            for(var i=0;i<jobSelectOption.length;i++){
                jobSelectOption.options[i].value = jobArray[i].id;
                jobSelectOption.options[i].text = jobArray[i].job.jname;
            }
        }
        function getJobNum(thisIndex) {
            $.ajax({
                url:"deptAndJob/showJobNumAjax.view",
                type: "get",
                async: true,
                timeout: 5000,
                dataType: "json",
                data:{"deptIdStr":thisIndex},
                success:function (data,status) {
                    jobArray = data;
                    console.log(data);
                }
            });
            return jobArray.length;
        }
    </script>
</head>
<body>
<c:out value="${info}"></c:out>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <c:import url="../success.jsp"></c:import>
        </div>
        <div class="col-md-10">
            <form name="form1" enctype="multipart/form-data" action="/recruit/adminAddRecruit.do">
                <table class="table table-bordered">
                    <caption>发布招聘</caption>
                        <tr>
                            <td>公司名</td>
                            <td><input type="text" readonly="readonly" value="${compName}"></input></td>
                        </tr>
                        <tr>
                            <td>部门名</td>
                            <td>
                                <label>
                                    <select name="deptName" id="deptName1" onchange="addJobName(this.selectedIndex)">
                                        <option value="-1">选择部门</option>
                                    </select>
                                </label>
                            </td>
                        </tr><tr>
                            <td>职位名</td>
                            <td>
                                <label>
                                    <select name="jobName" id="jobName1">
                                        <option value="-1">选择职位</option>
                                    </select>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td>招聘人数</td>
                            <td><input type="number" name="workerNumber"></td>
                        </tr>
                        <tr>
                            <td>工作类型</td>
                            <td><textarea name="workType"></textarea></td>
                        </tr>
                        <tr>
                            <td>工作地点</td>
                            <td><input type="text" name="workLocation"></td>
                        </tr>
                        <tr>
                            <td ><input type="reset" value="重置"></td>
                            <td ><input type="submit" value="保存" ></td>
                        </tr>
                </table>
            </form>
            <a href="/admin/adminSuccess.do">返回</a>
        </div>
    </div>
</div>
</body>
</html>