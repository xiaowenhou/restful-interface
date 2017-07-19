<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新用户</title>

</head>
<body> 
	<form id="itemForm"	action="${pageContext.request.contextPath }/a/user/add" method="post">
		<input type="hidden" name="user" value="${user}" /> 添加新用户：
		<table width="100%" border=1>
			<tr>
				<td>用户ID</td>
				<td><input type="text" name="id" value="${user.id }" /></td>
			</tr>
			<tr>
				<td>用户姓名</td>
				<td><input type="text" name="name" value="${user.name }" /></td>
			</tr>
			 <tr>
				<td>用户密码</td>
				<td><input type="text" name="password" value="${user.password }" /></td>
			</tr>
			<tr>
				<td colspan="5" align="center"><input type="submit" value="提交" />
				</td>
			</tr>
		</table>

	</form>
</body>

</html>