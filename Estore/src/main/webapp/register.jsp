<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> --%>
<html>
<head>
<meta charset="UTF-8">
<title>briup电子商务-注册页</title>
<%-- <base href="<%=basePath%>" /> --%>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="index.jsp"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current">用手机登陆</li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="login.jsp">登陆</a>
            </div>
        </div>
        <div class="content2">
        <form action="register" method="post">
			<ul class="reg_box">
            	<li>
                	<span><b>*</b>用户名：</span>
                    <input type="text" name="name"/>
                </li>
               <li>
                	<span><b>*</b>密码：</span>
                    <input type="password" name="password"/>
                </li>
                <li>
                	<span><b>*</b>邮编：</span>
                    <input type="text" name="zip"/>
                </li>
                <li>
                	<span><b>*</b>地址：</span>
                    <input type="text" name="address"/>
                </li>
                <li>
                	<span><b>*</b>电话：</span>
                    <input type="text" name="telephone"/>
                </li>
                <li>
                	<span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email"/>
                </li>
            </ul>
			<p>
            	<input type="checkbox" checked/>
               	 我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
           </form>
        </div>
   	</div>
</body>
</html>