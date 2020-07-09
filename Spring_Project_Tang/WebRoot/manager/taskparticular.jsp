<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=gb2312" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>任务详细信息</title>
<link href="${pageContext.request.contextPath}/css/css.css" rel="stylesheet" type="text/css" />
</head>
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
		<script type="text/javascript">
			$(function() {
				$("input[type='submit']").attr('disabled', "true");
				$("input[type='radio']").click(function () {
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
        <p>您现在的位置 &gt;&gt; 查看任务 &gt;&gt; 任务详细信息</p>
        <h1>任务详细信息:</h1>
			<c:forEach items="${tasks}" var="t">
          <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">任务名称</td>
              <td width="579" colspan="5">${t.t.taskName}</td>
            </tr>
            <tr>
              <td class="tdcolor">任务描述</td>
              <td colspan="5">${t.t.taskDesc}</td>
            </tr>
            <tr>
              <td class="tdcolor">开始时间</td>
              <td width="15%">${t.t.beginDate}</td>
              <td width="20%" class="tdcolor">结束时间</td>
              <td width="50%" colspan="3"><p>&nbsp;${t.t.endDate}</p>              </td>
            </tr>
            <tr>
              <td class="tdcolor">实际开始时间</td>
              <td>&nbsp;${t.t.realbeginDate}</td>
              <td class="tdcolor">实际结束时间</td>
              <td colspan="3">&nbsp;${t.t.realendDate}</td>
            </tr>
            <tr>
              <td class="tdcolor">实施人</td>
              <td>&nbsp;${t.t.implementorId.realName}</td>
              <td class="tdcolor">任务状态</td>
              <td>${t.t.status}</td>
              <td class="tdcolor">计划数目</td>
              <td>${t.listPlan.size()}</td>
            </tr>
        </table>
        </c:forEach>
	    <form id="form1" name="form1" method="post" action="planById.do">
		  <h1>实施计划：</h1>
		  <table width="700" border="0" cellpadding="0" cellspacing="0" class="table">
            <tr>
              <td width="15%" class="tdcolor">计划名称</td>
              <td width="15%" class="tdcolor">完成状态</td>
              <td width="20%" class="tdcolor">是否反馈</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">结束时间</td>
              <td class="tdcolor">&nbsp;</td>
            </tr>
            <c:forEach items="${plans}" var="p">
            <tr>
              <td>${p.planName}</td>
              <td>${p.status}</td>
              <td>${p.isFeedback}</td>
              <td>${p.beginDate}</td>
              <td>${p.endDate}</td>
              <td><label>
                <input type="radio" name="radiobutton" value="${p.taskId}" />
              </label></td>
            </tr>
           </c:forEach>

          </table>
		  <p>
              <label>
              <input name="Submit" type="submit" class="menu3" value="详细信息" />
            </label>
          </p>
      </form>
      </div>
    </td></tr>
</table>
<!-- #BeginLibraryItem "/Library/bottom.lbi" --><div id="bottom"><img src="${pageContext.request.contextPath}/images/button.jpg" width="1002" height="17" /></div><!-- #EndLibraryItem --></body>
</html>
