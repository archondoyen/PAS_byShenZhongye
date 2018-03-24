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
    <title>找工作，上海同</title>
    <script>
        var element;
        var textInfo/*;alert显示的字符串*/
        var mydate;/*ajax的返回值,布尔*/
        function del(paramsIndex,ele) {
            element=ele;
            textInfo="删除部门";
            var params = {oper:"delete",deptId:paramsIndex.toString()};
            var ajaxReturn = ajax("get","Dept/deleteDept.do",params,true,ajaxDoDelete());
            console.log(ajaxReturn);
            console.log(eval(ajaxReturn));
            console.log(mydate);
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