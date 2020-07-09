<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<%@include file="commons/mytaglib.jsp" %>
<title>登录页面</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
</head>

<body>
	
<div id="logo"><img src="images/logo.jpg" alt="大唐电信首页" width="1002" height="392" /></div>
<div class="login" id="middle">
  <spf:form action="login.do" modelAttribute="form" method="post" name="form001"  id="form001">
    <p>
      <label>
      用户名：<spf:input path="emp.employeeName"/>
    </label></p>
    <p>  密 码：     
      <label>
    <spf:password path="emp.password" />
    </label></p>
    <p>角 色：
      <label>
      <spf:select path="role.roleId">
      	<option value="1" />请选择角色
      	<spf:options items="${requestScope.roles}" itemLabel="roleName" itemValue="roleId"/>
      </spf:select>
      </label>
    </p>
    <p>
      <label class="left007-bg">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
      <input name="Submit" type="submit" class="menu1" value="提交" />
      </label>
    </p>
  </spf:form>
</div>
<div id="nutton"><img src="images/button.jpg" width="1002" height="17" /></div>
</body>
</html>
