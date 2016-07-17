<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//如果用户登录信息不对，则不进行读取Cookie
	//用户直接访问登录界面
	if(request.getAttribute("curentUser")==null){
		String userName=null;
		String passWord=null;
		
		Cookie[] cookies=request.getCookies();
		for(int i=0;cookies!=null && i<cookies.length;i++){
			if(cookies[i].getName().equals("Dairy")){
				userName=cookies[i].getValue();
			}		
		}
		
		if(userName==null){
			userName="";
		}
		
		if(passWord==null){
			passWord="";
		}
		
		pageContext.setAttribute("name",userName);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>日记本登录界面</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.12.3.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<style type="text/css">
 body {
        padding-top: 200px;
        padding-bottom: 40px;
      }
      
      .form-signin-heading{
      	text-align: center;
      }

      .form-signin {
        max-width: 300px;
        padding: 19px 29px 0px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
      .form-signin .checkbox {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }

</style>
<script type="text/javascript">
	function verity(){
		var userName=$("#userName").val();
		var passWord=$("#passWord").val();
		if(userName==""||userName==null){
			$("#error").text("用户名不能为空");
			return false;
		}
		if(passWord==""||passWord==null){
			$("#error").text("密码不能为空");
			return false;
		}
		return true;
	}

</script>
</head>
<body>
	<div class="container">
      <form name="myForm" class="form-signin" action="UserLogin" method="post" onsubmit="return verity();">
        <h2 class="form-signin-heading">日记本</h2>
        <input id="userName" name="userName" type="text" class="input-block-level" placeholder="用户名" value="${name}" >
        <input id="passWord" name="passWord"   type="password" class="input-block-level" placeholder="密码" >
        <label class="checkbox">
          <input id="remember" name="remember" type="checkbox" value="remember-me">记住我 &nbsp;&nbsp;&nbsp;&nbsp; <font id="error">${error }</font>  
        </label>
        <button class="btn btn-large btn-primary" type="submit">登录</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="btn btn-large btn-primary" type="button" >重置</button>

<p align="center" style="padding-top: 15px;">欢迎使用日记本系统<br/><a href="http://www.iwebker.com" target="_blank">http://www.iwebker.com</a></p>
      </form>
</div>
</body>
</html>