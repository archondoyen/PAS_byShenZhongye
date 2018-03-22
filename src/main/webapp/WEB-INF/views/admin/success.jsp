<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <link href="/styles/font-awesome.css" rel="stylesheet">
    <script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="/scripts/google-maps.js"></script>
    <script>
        $(document).ready(function(){
            $(".vertical-nav").verticalnav({speed: 400,align: "left"});});
    </script>
    <title>管理员首页</title>
</head>
<body>
<div class="left-container">
    <div style="text-align:center;clear:both;">
        <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<%--        <script src="/follow.js" type="text/javascript"></script>--%>
    </div>
    <div class="kePublic">
        <!--效果html开始-->
        <div class="content">
            <ul class="vertical-nav dark red">
                <li class="active"><a href="http://www.iotek.com.cn/">首页，by忠业</a></li>
                <li class="active"><a href="http://www.iotek.com.cn/">全部链接都可以点击哦</a></li>
                <li><i class="icon-cogs"></i>&nbsp;&nbsp;招聘
                    <span class="submenu-icon"></span>
                    <ul>
                        <li><a href="">新招聘</a></li>
                        <li><a href="">招聘管理</a></li>
                    </ul>
                </li>
                <li><i class="icon-cogs"></i>&nbsp;&nbsp;面试
                    <span class="submenu-icon"></span>
                    <ul>
                        <li><a href="">新面试</a></li>
                        <li><a href="">面试管理</a></li>
                    </ul>
                </li>
                <li><i class="icon-cogs"></i>&nbsp;&nbsp;培训
                    <span class="submenu-icon"></span>
                    <ul>
                        <li><a href="">新培训</a></li>
                        <li><a href="">培训管理</a></li>
                    </ul>
                </li>
                <li><i class="icon-cogs"></i>&nbsp;&nbsp;员工
                    <span class="submenu-icon"></span>
                    <ul>
                        <li><a href="">员工管理</a></li>
                        <li><a href="">员工考核</a></li>
                    </ul>
                </li>
                <li><i class="icon-cogs"></i>&nbsp;&nbsp;公司
                    <span class="submenu-icon"></span>
                    <ul>
                        <li><a href="/admin/adminCompany.view">公司信息</a></li>
                        <li>
                            <a href="">部门<span class="submenu-icon"></span></a><ul>
                                <li><a href="/Dept/adminNewDept.entrance">新部门</a></li>
                                <li><a href="/Dept/adminDept.view">部门管理 <span class="submenu-icon"></span>
                            </a>
                        </li><li>
                            <a href="">职位<span class="submenu-icon"></span></a><ul>
                                <li><a href="/job/adminAddJob.Entrance">新职位</a></li>
                                <li><a href="/deptAndJob/showJob.view">职位管理 <span class="submenu-icon"></span>
                            </a>
                        </li>
                        <li><a href="">职位</a></li>
                    </ul>
                    </li>
                </ul>
            </ul></ul>
        </div>
        <!--效果html结束-->
        <div class="clear"></div>
    </div>
</div>

<%--<div class="right-container" style="float: left">
    <h1>欢迎${sessionScope.admin}!</h1>
    <a href="">新招聘</a>
    <a href="">管理招聘信息</a>
    <a href="">安排面试</a>
    <a href="">新培训</a>
    <a href="">培训计划管理</a>
    <a href="">员工管理</a>
    <a href="">员工考核</a>
    <a href="/admin/adminCompany.view">公司信息</a>
    <a href="/Dept/adminNewDept.entrance">新部门</a>
    <a href="/Dept/adminDept.view">部门管理</a>
    <a href="/job/adminAddJob.Entrance">新职位</a>
    <a href="/admin/adminCompany.view">职位管理</a>
</div>--%>

</body>
</html>
