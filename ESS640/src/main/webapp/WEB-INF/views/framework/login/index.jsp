<%@ page language="java" pageEncoding="UTF-8"%>
<%@include  file="/core/taglibs.jsp"%>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="<%=basePath%>framework/login/doLogin" method="post">
    User ID : <input type="input" name="asuserUserid" value="ADMIN1"/><br/>
    Password: <input type="password" name="asuserPwd" value="admin"/><br/>
   
   	<button type="submit">doLogin</button>
    </form>
   
  </body>
</html>
