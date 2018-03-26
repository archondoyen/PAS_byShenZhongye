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
    <title>新建工资条</title>
    <script>
        function selectEmpBaseSal(inputIndex) {
            /*给baseSal赋值*/
            $.ajax({
                url: "salay/getEmpNameAndBaseSal.oper",
                type: "get",
                data:{"empId":inputIndex.value},
                success: function (data) {
                    if (data == "员工不存在") {
                        alert("员工不存在");
                        return;
                    }
                    $("#baseSal").val(data);
                }
            });
        }function selectRewardAndPunishDetail() {
            /*给baseSal赋值*/
            $.ajax({
                url: "salay/getRewardAndPunishDetail.oper",
                type: "get",
                data:{"rpIdStr":$("#rewardAndPunishId").value},
                success: function (data) {
                    if (data == "奖惩信息不存在") {
                        alert("奖惩信息不存在");
                        return;
                    }
                    $("#rpdetail").val(data);
                }
            });
        }
    </script>
</head>
<body>
<div class="alert"><h3>${info}</h3></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form name="form1" action="/salay/adminPaySalay.do">
                <table class="table table-bordered">
                    <tr>
                        <th>员工id</th>
                        <th>基本工资</th>
                        <th>工作表现</th><%--薪金--%>
                        <th>奖金/罚金id</th><%--先传一个，一堆有点复杂，搞个数组，用json传--%>
                        <th>奖罚明细</th>
                        <th>公积金、五险比例</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td>
                            <input type="number" name="empId" placeholder="员工id" onchange="selectEmpBaseSal(this)">
                        </td>
                        <td>
                            <input type="text" name="base" readonly="readonly" placeholder="基本工资" id="baseSal">
                        </td>
                        <td>
                            <input type="number" name="workerPerformance" placeholder="工作表现工资">
                        </td>
                        <td>
                            <input type="number" id="rewardAndPunishId" placeholder="奖金/罚金" onchange="selectRewardAndPunishDetail()">
                        </td<td>
                            <input type="number" id="rpdetail" placeholder="奖罚明细">
                        </td><td>
                        <input type="number" name="ratio" readonly="readonly" placeholder="五险一金比例:${ratio}">
                    </td>
                        <td>
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