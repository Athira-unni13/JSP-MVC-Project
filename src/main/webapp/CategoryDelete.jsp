<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.mvc.beans.categoryBean"%>
<%@page import="com.mvc.dao.categoryDAO"%>

<%
	int catId = Integer.parseInt(request.getParameter("catId"));

	categoryBean categorybean = new categoryBean();
	categorybean.setCaId(catId);

	boolean flag = categoryDAO.deleteCategory(categorybean);

	if (flag) {
		response.sendRedirect("CategoryVED.jsp");
	} else {
		response.sendRedirect("Error.jsp");
	}
%>