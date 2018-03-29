<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <title>旅客登录</title>
    <style>
        table{
            margin: 0 auto;
            text-align: center;
        }
        tr{
            height: 50px;

        }
        input[type='text'],
        input[type='email'],
        input[type='date']{
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form action="/resume/visitorNewResume.do" name="form1" enctype="multipart/form-data" method="post">
            <input type="text" name="visiorId" value="${sessionScope.visitor.id}" hidden="hidden">
            <table border="1" cellspacing="0" >
                <caption>个人简历</caption>
                <br/>
                <br/>
                <br/>
                <input type="number" name="recruitmentId" value="${recId}" hidden="hidden">
                <input type="number" name="createId" value="${createrId}" hidden="hidden">
                <tr>
                    <td>个人基本信息</td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td><input type="text" name="vName" value="${sessionScope.visitor.vName}" readonly="readonly"></td>
                    <td>年龄</td>
                    <td><input type="number" value="${sessionScope.visitor.vAge}" readonly="readonly"></td>
                    <td>性别</td>
<%--                    <td><select name="empl_sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select></td>--%>
                    <td><input type="text" name="vName" value="${sessionScope.visitor.vAge}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="vEmail" value="${sessionScope.visitor.vEmail}" readonly="readonly"></td>
                    <td>电话</td>
                    <td><input type="text" name="vPhone" value="${sessionScope.visitor.vPhone}" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>工作信息</td>
                </tr>
                <tr>
                    <td>申请职位</td>
                    <td><input type="text" name="vPhone" value="${recruitment.deptAndJob.job.JName}" readonly="readonly"></td>
                    <td>申请部门</td>
                    <td><input type="text" name="deptName" value="${recruitment.deptAndJob.department.deptName}" readonly="readonly"></td>
                    <td>招聘公司名称</td>
                    <td><input type="text" name="deptName" value="${recruitment.deptAndJob.company.CName}" readonly="readonly"></td>
                </tr>
<%--                <tr><td>教育工作经历</td></tr>
                <c:forEach items="${sessionScope.workExps}" var="works">
                    <tr>
                        <td><c:out value="开始时间${works.startDate}"></c:out></td>
                        <td><c:out value="结束时间${works.endDate}"></c:out></td>
                        <td><c:out value="奖励${works.positionRewarding}"></c:out></td>
                    </tr>
                </c:forEach>--%>
                <tr>
                    <td>个人详情</td>
                </tr>
                <tr>
                    <td>自我介绍
                    </td>
                    <td colspan="6" >
                        <textarea name="selfAppraisal" cols="100" rows="20"></textarea>
                    </td>
                </tr>
                <tr>
                    <td >兴趣</td>
                    <td >
                        <input name="interest" type="text">
                    </td>
                </tr><tr>
                <td>技能</td>
                </tr>
                <c:set value="${sessionScope.visitor.skillList}" var="skillList"></c:set>
                <c:forEach items="${skillList}" var="skill">
                    <tr>
                    <td><c:out value="技能：${skill.sName}"></c:out></td>
                    <td><c:out value="证书：${skill.certificate}"></c:out></td>
                </tr></c:forEach>
                <tr>
                    <<input type="number" name="noticeContent" value="${recruitment.deptAndJob.job.JName}--${recruitment.deptAndJob.department.deptName}--${recruitment.deptAndJob.company.CName}" hidden="hidden">
                    <td colspan="2">
                        <input type="reset" value="重置简历">
                    </td>
                    <td colspan="5">
                        <input type="submit" value="保存简历" >
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>