<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>
<html>
<head>
    <base href="<%= basePath%>">
    <link href="/styles/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="/scripts/bootstrap.min.js"></script>
    <script src="/scripts/jquery-3.3.1.min.js"></script>
    <title>旅客注册</title>
    <style>
        .lab{
            height: 8px;
            width: 30px;
            background-color: gray;
            margin: 1px 3px;
            display: inline-block;
            visibility: hidden;
        }
    </style>
    <script>
        function showLab() {
            var labs=document.getElementsByClassName("lab");
            for(var i=0 ;i<labs.length;i++){
                labs[i].style.visibility="visible";
            }
        }
        function  checkPass(input) {
            var  inputValue=input.value;
            var labs=document.getElementsByClassName("lab");
            if (inputValue.trim().length==0){
                labs[0].style.backgroundColor="gray";
                labs[1].style.backgroundColor="gray";
                labs[2].style.backgroundColor="gray";
            }else if(inputValue.trim().length<6){
                labs[0].style.backgroundColor="red";
                labs[1].style.backgroundColor="gray";
                labs[2].style.backgroundColor="gray";
            }else if(inputValue.trim().length<10){
                labs[0].style.backgroundColor="red";
                labs[1].style.backgroundColor="yellow";
                labs[2].style.backgroundColor="gray";
            }else{
                labs[0].style.backgroundColor="red";
                labs[1].style.backgroundColor="yellow";
                labs[2].style.backgroundColor="green";
            }
        }
    </script>
    <script>
        function checkName(thisInput) {
            var checkNameResultIcon = document.getElementById("checkNameResultIcon");
            var nameReg = /^[a-zA-Z][a-zA-Z0-9_]{5,29}$/;
            if(nameReg.test(thisInput.value)){
            }else{
                checkNameResultIcon.setAttribute("class","glyphicon glyphicon-remove");
                $("#checkNameResult").html("用户名不合法！");
                return;
            }
            $.ajax({
                url:"visitor/checkName.oper",
                data:{"visitorName":thisInput.value},
                success:function (data) {
                    console.log(data);
                    $("#checkNameResult").html(data);
                    if(data.length==0){
                        checkNameResultIcon.setAttribute("class","glyphicon glyphicon-ok");
                    }else{
                        alert(data);
                        checkNameResultIcon.setAttribute("class","glyphicon glyphicon-remove");
                    }
                }
            });
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <form action="/visitor/visitorReg.do">
                <table class="table table-bordered">
                    用户名：<input type="text" name="vName" onblur="checkName(this)">
                    <span id="checkNameResultIcon"></span>
                    <span id="checkNameResult"></span><br/>
                    密码：<input type="password" name="vPassword" onfocus="showLab()" onkeypress="checkPass(this)">
                    <div class="lab"></div>
                    <div class="lab"></div>
                    <div class="lab"></div><br/>
                    邮箱：<input type="email" name="vEmail"><br/>
                    身份证：<input type="text" name="vIdentityCard"><br/>
                    性别：<input type="text" name="vGender"><br/>
                    年龄：<input type="number" name="vAge"><br/>
                    电话：<input type="tel" name="vPhone"><br/>
                    <%--           照片：<input type="file" name="vPhoto"></br>--%>
                    <button type="submit">提交</button><br/>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>