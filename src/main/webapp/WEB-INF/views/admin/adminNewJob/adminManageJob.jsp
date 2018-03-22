<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>新职位</title>
    <script>
        var deptArray = new Array();
        var deptSelectOption = document.getElementById("deptTd");
        $(document).ready{function () {
            $.ajax({
                url:"deptAndJob/showJobAjax.view",
                type:"post",
                success:function (data,textStatus){
                    deptArray = data;
                    console.log(data);
                    console.log(textStatus);
                    addDept();
                }
            })
        }}
        function addDept(){
            for(var i=0;i<deptArray.length;i++){
                deptSelectOption.options[i].value=deptArray[i].id;
                deptSelectOption.options[i].text=deptArray[i].deptName;
            }

        }
        var oper;
        function modify(oper) {

        }
        function del(oper) {

        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="admin/adminAddJob.do">
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
                            <label>
                                <select>
                                    <option value="-1" id="deptTd"></option>
                                </select>
                            </label>
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
                                        <select>
                                            <option value="-1" id="jobTypeSecondId"></option>
                                        </select>
                                    </option>
                                </select>
                            </label>
                        </td>
                        <td>
                            <input type="text" name="jInfo" placeholder="职位详情">
                        </td><td>
                        <input type="reset" class="btn btn-danger" value="清除">
                        <input type="submit" class="btn btn-success" value="提交">
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