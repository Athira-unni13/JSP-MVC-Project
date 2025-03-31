<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.mvc.beans.categoryBean"%>
<%@page import="com.mvc.dao.categoryDAO"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>category view|edit|delete</title>
</head>
<body>
<a href="categoryAdd.html">New</a><br><br>
<table border="1">
<tr>
	<th>SLNo</th>
	<th>Category Name</th>
	<th>Category Price</th>
	<th>Edit</th>
	<th>Delete</th>
	<%
			int i = 1;
			ArrayList<categoryBean> categoryList = categoryDAO.getAllCategories();
	for (categoryBean cat : categoryList) {
		%>
</tr>
<tr>
	<td><%=i%></td>
	<td><%=cat.getCaName()%></td>
	<td><%=cat.getPrice()%></td>
	<td><a href="CategoryEdit.jsp?catId=<%=cat.getCaId()%>">Edit</a></td>
	<td><a href="CategoryDelete.jsp?catId=<%=cat.getCaId()%>">Delete</a></td>
</tr>
<%
i++;
	}

%>
</table>
</body>
</html>