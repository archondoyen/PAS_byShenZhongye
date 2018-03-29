<!doctype html>
<html>
<head>
    <title>Tab Form Widget Flat Responsive Widget Template :: w3layouts</title>
    <!-- for-mobile-apps -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="keywords" content="Tab Form Widget Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
    <!-- //for-mobile-apps -->
    <link href="//fonts.googleapis.com/css?family=Titillium+Web:200,200i,300,300i,400,400i,600,600i,700,700i,900" rel="stylesheet">
    <link href="/styles/font-awesome.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/styles/styleA.css" rel="stylesheet" type="text/css" media="all" />
    <script src="/scripts/jquery-2.1.4.min.js"></script>
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/styles/raccordion.css" />
    <script type="text/javascript">
        $(window).load(function () {
            $('#accordion-wrapper').raccordion({
                speed: 1000,
                sliderWidth: 700,
                sliderHeight: 300,
                autoCollapse: false
            });
        });
    </script>
</head>
<body>
<div class="content" id="Main-Content">
    <h1 class="w3_agileits-head"><span>E.</span>R.<span>P.</span>SYS<span>BY</span>SZY</h1>
    <div class="wrapper">
        <div id="accordion-wrapper">
            <div class="slide">
                <img src="/images/2.jpg" alt="image"/>
                <div class="caption">
                    <div class="w3layouts-info">
                        <div class="w3layouts-info-top">
                            <h3>Visitor Login</h3>
                        </div>
                        <div class="w3layouts-info-bottom">
                            <form action="/visitor/visitorLog.do" method="post" class="agile_form">
                                <input type="text" name="vName" placeholder="visitorName"/>
                                <input type="password" name="vPassword" class="password" placeholder="visitorPassword"/>
                                <span style="color: red">${info}</span>
                                <div class="w3ls-signin-bottom">
                                    <div class="agile-login">
                                        <input type="submit" value="LoginIn" />
                                        <a href="/visitor/visitorReg.entrance" style="color: orange;">Register!</a>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slide">
                <img src="/images/3.jpg" alt="image"/>
                <div class="caption">
                    <div class="w3layouts-info">
                        <div class="w3layouts-info-top">
                            <h3>Register!</h3>
                        </div>
                        <div class="w3layouts-info-bottom">
                            <span class="wthree fa fa-check-square-o" aria-hidden="true"></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="slide">
                <img src="/images/1.jpg" alt="image" />
                <div class="caption">
                    <div class="caption">
                        <div class="w3layouts-info">
                            <div class="w3layouts-info-top">
                                <h3>HR Login</h3>
                            </div>
                            <div class="w3layouts-info-bottom">
                                <form action="/admin/adminLog.do" method="post" class="agile_form">
                                    <input type="text" name="aName" placeholder="hrName" />
                                    <input type="password" name="aPassword" class="password" placeholder="hrPassword"/>
                                    <input type="submit" value="LoginIn" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--copyright-->
    <div class="w3ls-copyright">
        <p>© 2017 Tab Form Widget.All Rights Reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a> </p>
    </div>
    <!--//copyright-->
</div>
<script src="/scripts/jquery.raccordion.js" type="text/javascript"></script>
<script src="/scripts/jquery.animation.easing.js" type="text/javascript"></script>
</body>
</html>