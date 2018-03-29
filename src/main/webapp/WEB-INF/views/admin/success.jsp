<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ERP系统-管理员首页</title>
    <link rel="stylesheet" type="text/css" href="/styles/reset.css" />
    <link rel="stylesheet" type="text/css" href="/styles/default.css">
    <!-- Styles -->
    <link href="/styles/style.css" rel="stylesheet">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,600,500,700,800' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300italic,400italic' rel='stylesheet' type='text/css'>
    <link href="http://cdn.bootcss.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">

    <script>
        $(document).ready(function(){
            $.ajax({
                url:"notice/adminGetNoticeNumRecruit.view",
                type:"post",
                success:function (data) {
                    $("#nociceNumberRecruit").html(data);
                    $("#allNociceNumber").html("新");
                }
            });$.ajax({
                url:"notice/adminGetNoticeNumInterView.view",
                type:"post",
                success:function (data) {
                    $("#nociceNumberInterview").html(data);
                    $("#allNociceNumber").html("新");
                }
            });/*$.ajax({
                url:"notice/nociceNumberSalay",
                type:"post",
                success:function (data) {
                    $("#nociceNumbSalay").html(data);
                    $("#allNociceNumber").html("新");
                }
            });工资提取成功后，不提示数目*/
        });
    </script>
</head>
<body>
<div id="container" style="width:280px;">
    <button class="toggle-nav" id="bars" style="z-index: 10"><i class="fa fa-bars"></i></button>
    <div id="canvas">
        <div id="nav">
            <h2 id="title"><i class="fa fa-sitemap"></i>欢迎 ${admin.AName}！</h2>
            <ul id="toggle">
                <li>
                    <div class="active border">
                        <span class="menu-icons fa fa-home"></span><a href="#">首页</a>
                    </div>
                </li>
                <li>
                    <div>
                        <span class="menu-icons  fa fa-user"></span><a href="/recruit/adminRecruit.entrance">招聘</a>
                        <span class="the-btn fa fa-plus"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/recruit/adminRecruit.entrance">新招聘</a>
                        </li>
                        <li>
                            <a href="#">招聘管理</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-briefcase"></span>
                        <a href="#">消息</a><span class="the-btn fa fa-plus"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/notice/adminViewNoticeNotRead.Recruitment">招聘面试</a><span id="nociceNumberRecruit"></span>
                        </li>
                        <li>
                            <a href="/notice/adminViewNoticeNotRead.interview">面试入职</a><span id="nociceNumberInterview"></span>
                        </li>
                    </ul>
                </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-briefcase"></span>
                        <a href="#">奖惩</a><span class="the-btn fa fa-plus"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/rewardAndPunish/adminNewRewardAndPunish.entrance">新建奖惩</a>
                        </li>
                        <li>
                            <a href="/rewardAndPunish/adminShowRewarnAndPunish.view">奖罚管理</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-briefcase"></span>
                        <a href="#">工资</a><span class="the-btn fa fa-plus"></span><span id="nociceNumberSalay"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/salay/adminPaySalay.entrance">发工资</a>
                        </li>
                        <li>
                            <a href="/notice/adminViewNoticeNotRead.salay">工资管理</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-briefcase"></span>
                        <a href="#">公司</a><span class="the-btn fa fa-plus"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/admin/adminCompany.view">公司信息</a>
                        </li>
                    </ul>
                </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-briefcase"></span>
                        <a href="#">部门</a><span class="the-btn fa fa-plus"></span>
                    </div>
                    <ul>
                        <li>
                            <a href="/Dept/adminNewDept.entrance">新部门</a>
                        </li><li>
                        <a href="/Dept/adminDept.view">部门管理</a>
                    </li>
                    </ul>
                </li>

                <li>
                <div>
                    <span class="menu-icons  fa fa-briefcase"></span>
                    <a href="#">职位</a><span class="the-btn fa fa-plus"></span>
                </div>
                <ul>
                    <li>
                        <a href="/job/adminAddJob.Entrance">新职位</a>
                    </li><li>
                    <a href="/deptAndJob/showJob.view">职位管理</a>
                </li>
                </ul>
            </li>

                <li>
                    <div>
                        <span class="menu-icons  fa fa-envelope"></span>
                        <a href="">考勤</a>
                    </div>
                </li><li>
                    <div>
                        <span class="menu-icons  fa fa-envelope"></span>
                        <a href="/logOut.do">退出</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<script src="/scripts/jquery.min.js"></script>
<script src="/scripts/custom.js"></script>
</body>
</html>
