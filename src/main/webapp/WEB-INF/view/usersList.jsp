<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body> 

用户列表：
<table width="100%" border=1>
<tr>
	<td>用户ID</td>
	<td>用户姓名</td>
	<td>用户密码</td>
	<td>操作</td>
</tr>
<c:forEach items="${userList}" var="user">
<tr>
	<td>${user.id }</td>
	<td>${user.name }</td>	
	<td>${user.password }</td>
	<td><a href="${pageContext.request.contextPath }/a/user/id/${user.id}/update">修改</a></td>
	<td><a href="${pageContext.request.contextPath }/a/user/id/${user.id}/delete">删除</a></td>
	
</tr>
</c:forEach>

<tr>
	<td align="center"><a href="${pageContext.request.contextPath }/a/user/add">添加</a></td>
</tr>

</table>
</body>

</html>