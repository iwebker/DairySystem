<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日记本主界面</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery-1.12.3.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="#">我的日记本</a>
          <div class="nav-collapse collapse">
            <ul class="nav">
              <li class="active"><a href="#"><i class="icon-home"></i>&nbsp;主页</a></li>
              <li class="active"><a href="#"><i class="icon-pencil"></i>&nbsp;写日记</a></li>
              <li class="active"><a href="#"><i class="icon-book"></i>&nbsp;日记分类管理</a></li>
              <li class="active"><a href="#"><i class="icon-user"></i>&nbsp;个人中心</a></li>
            </ul>
          </div>
          
          <form name="myForm" class="navbar-form pull-right" method="post" action="">
	 		 <input class="span2" id="s_title" name="s_title"  type="text" placeholder="往事如烟...">
	  		 <button type="submit" class="btn" onkeydown="if(event.keyCode==13) myForm.submit()"><i class="icon-search"></i>&nbsp;搜索日志</button>
		</form>
          
        </div>
      </div>
</div>
</body>
</html>