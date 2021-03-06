<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spf" %>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户管理</title>
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
        <p>您现在的位置 &gt;&gt; 用户管理 &gt;&gt; 用户列表</p>
        <h1>用户详细信息:</h1>
	  
	    <spf:form id="form1" name="form1" modelAttribute="emp" method="post" action="userAdd.do">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">用户名称</td>
              <td class="tdcolor">用户密码</td>
              <td class="tdcolor">用户角色</td>
              <td class="tdcolor">真实姓名</td>
              <td class="tdcolor">入职时间</td>
              <td class="tdcolor">职位信息</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${userSelect}" var="emp" varStatus="status">    
            <tr>
              <td>${emp.employeeName }</td>
              <td>${emp.password }</td>
              <td>${emp.role.roleName}</td>
              <td>${emp.realName }</td>
              <td>${emp.enrollDate }</td>
              <td>${emp.duty }</td>
            </tr>
            </c:forEach>
          </table>
	      <p>
	      			<a>共${pb.lastPage}页</a>
					<a href="userSelect.do?pageNo=${pb.firstPage}&pageSize=${pb.pageSize}">首页</a>
			    	<a href="userSelect.do?pageNo=${pb.previousPage}&pageSize=${pb.pageSize}">上一页</a>
			    	<a href="userSelect.do?pageNo=${pb.nextPage}&pageSize=${pb.pageSize}">下一页</a>
			    	<a href="userSelect.do?pageNo=${pb.lastPage}&pageSize=${pb.pageSize}">尾页</a>
					<a>第${pb.pageNo }页</a> 
					<a>共${pb.count }条记录</a>
            <label>            
            <input name="Submit" type="submit" class="menu3" value="添加人员" />
            </label>
          </p>
        </spf:form>
        
	    <p>&nbsp;</p>
</div></td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="../images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
