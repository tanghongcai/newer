<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>未实施任务</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
		<script type="text/javascript">
			$(function() {
				$("input[type='submit']").attr('disabled', "true");
				$("input[type='checkbox']").click(function () {
				
				$("input[type='submit']").removeAttr("disabled");
				});
			});
		</script>
<%@include file="../commons/mytaglib.jsp" %>
<body><!-- #BeginLibraryItem "/Library/topbanner.lbi" -->
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
<div id="logo"><img src="${pageContext.request.contextPath}/images/top.jpg" width="1002" height="258" /></div>
<!-- #EndLibraryItem --><table width="1002" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="rightimg"><!-- #BeginLibraryItem "/Library/left.lbi" --><div id="left">
      <p><a href="AllTask.do" target="_self">查看任务</a></p>
      <p><a href="taskCreate.do" target="_self">制定任务</a></p>
      <p><a href="taskundone.do" target="_self">调整任务</a></p>
      <p><a href="intendance.do" target="_self">跟踪任务</a></p>
      <p><a href="checkper.do" target="_self">查看人员</a></p>
      <p><a href="invalidate.do" target="_self">退出系统</a></p>
</div><!-- #EndLibraryItem --><div id="right">
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 未实施任务信息</p>
        <h1>未实施任务信息:</h1>
        <form id="form1" name="form1" method="post" action="taskun.do">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor"><a href="#" target="_self">任务名称</a></td>
              <td class="tdcolor"><a href="#" target="_self">实施人</a></td>
              <td class="tdcolor"><a href="#" target="_self">开始时间</a></td>
              <td class="tdcolor"><a href="#" target="_self">结束时间</a></td>
              <td class="tdcolor"><a href="#" target="_self">任务状态</a></td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            
            <c:forEach items="${wsstask}" var="t">
            <tr>
              <td><a href="adjust.do?id=${t.t.taskId}">${t.t.taskName}</a></td>
              <td>${t.t.implementorId.realName}</td>
              <td>${t.t.beginDate}</td>
              <td>&nbsp;${t.t.endDate}</td>
              <td>${t.t.status}</td>
              <td><label>
                <input type="checkbox" name="radiobutton" value="${t.t.taskId}" />
              </label></td>
            </tr>
			</c:forEach>
          </table>
    <p>
            <label>
            		<a>共${pb.lastPage}页</a>
					<a href="taskundone.do?pageNo=${pb.firstPage}&pageSize=${pb.pageSize}">首页</a>
			    	<a href="taskundone.do?pageNo=${pb.previousPage}&pageSize=${pb.pageSize}">上一页</a>
			    	<a href="taskundone.do?pageNo=${pb.nextPage}&pageSize=${pb.pageSize}">下一页</a>
			    	<a href="taskundone.do?pageNo=${pb.lastPage}&pageSize=${pb.pageSize}">尾页</a>
					<a>第${pb.pageNo }页</a> 
					<a>共${pb.count }条记录</a>
            <input name="Submit" type="submit" class="menu4" value="删除" />
            </label>
          </p>
      </form>
    </div>    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
