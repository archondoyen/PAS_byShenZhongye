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
    <title>工作详情</title>
    <script>
        var element;
        var textInfo/*;alert显示的字符串*/
        var mydate;/*ajax的返回值,布尔*/
        function sendRec(recId){
            $.getJSON()
        }
        function ajaxDoDelete() {
            myShow();
        }
        function modify(oper) {

        }

        function myShow() {
            if(mydate){
                var  tr1=element.parentNode.parentNode;
                var  tab=tr1.parentNode;
                tab.removeChild(tr1);
                var  ale= document.getElementById("alert");
                ale.className="alert alert-success";
                ale.innerHTML="成功"+textInfo;
                setTimeout(function () {
                    ale.className="";
                    ale.innerHTML="";
                },2000);
            }else{
                var  ale= document.getElementById("alert");
                ale.className="alert alert-danger";
                ale.innerHTML=textInfo+"失败";
                setTimeout(function () {
                    ale.className="";
                    ale.innerHTML="";
                },2000);
                textInfo = null;
                mydate=false;
            }
        }
    </script>
</head>
<body>
<div id="alert"></div>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <table class="table table-bordered">
                <tr>
                    <td>职位</td>
                    <td>${Recruit.deptAndJob.job.JName}</td>
                    <td>招聘人数${Recruit.workerNumber}</td>
                </tr>
                <tr><td>工作地点：${Recruit.workLocation}</td></tr>
                <tr>
                    <td>部门:${Recruit.deptAndJob.department.deptName}</td>
                    <td>公司:${Recruit.deptAndJob.company.CName}</td>
                    <td>工作类型--${Recruit.deptAndJob.job.jobtype.firstType}--${Recruit.deptAndJob.job.jobtype.secondType}</td>
                </tr>
                <tr>
                    <td colspan="4">
                        职位详情：&nbsp;&nbsp;&nbsp;&nbsp;
                        ${Recruit.deptAndJob.job.JInfo}
                    </td>
                </tr><tr>
                    <td colspan="2">
                        部门详情：&nbsp;&nbsp;&nbsp;&nbsp;
                        ${Recruit.deptAndJob.department.deptInfo}
                    </td>
                </tr><tr>
                    <td colspan="3">
                        公司详情：&nbsp;&nbsp;&nbsp;&nbsp;
                        ${Recruit.deptAndJob.department.deptInfo}
                    </td>
                </tr>
            </table><br/>
            <input type="number" name="recruitmentId" value="${Recruit.id}" hidden="hidden">
            <a class="btn btn-success" href="/resume/visitorNewResume.entrance/${Recruit.id}/${Recruit.createrId}">投递简历</a>
        </div>
    </div>
</div>
</body>
</html>