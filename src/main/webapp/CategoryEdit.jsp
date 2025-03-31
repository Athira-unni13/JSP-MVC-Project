<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.mvc.beans.categoryBean"%>
<%@page import="com.mvc.dao.categoryDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Edit</title>
</head>
<body>
	<%
	int catId = Integer.parseInt(request.getParameter("catId"));
	categoryBean categorybean = new categoryBean();

	categorybean.setCaId(catId);
	ArrayList<categoryBean> categoryList = categoryDAO.fetchCategoryById(categorybean);
	%>
	<form name="categoryEdit" method="post" action="CategoryEditAction.jsp">
		<table>
			<%
				for (categoryBean cat : categoryList) {
			%>
			<tr>
				<td></td>
				<td><input name="cateId" type="hidden" value="<%=cat.getCaId()%>" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name="catName" type="text" value="<%=cat.getCaName()%>" /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input name="catPrice" type="text" value="<%=cat.getPrice()%>" /></td>
			</tr>
			<%
				}
			%>

			<tr>
				<td></td>
				<td><input type="submit" value="UPDATE" /></td>
			</tr>
		</table>
	</form>
</body>
</html>