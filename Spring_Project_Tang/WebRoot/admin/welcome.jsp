<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎光临大唐电信</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>

<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="${pageContext.request.contextPath}/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left3.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="left2">
       <p><a href="userSelect.do" target="_self" >用户管理</a></p>
      <p><a href="select.do" target="_self">员工管理</a></p>
      <p><a href="fuser.do" target="_self">分配人员</a></p>
      <p ><a href="loging.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 欢迎光临</p>
          <h1>欢迎${emp.employeeName}光临大唐电信</h1>
          
    </div></td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>