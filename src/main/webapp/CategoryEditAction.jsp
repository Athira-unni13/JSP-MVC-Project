<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.mvc.beans.categoryBean"%>
<%@page import="com.mvc.dao.categoryDAO"%>

<%
	int id = Integer.parseInt(request.getParameter("cateId"));
	String catName = request.getParameter("catName");
	float price = Float.parseFloat(request.getParameter("catPrice"));

	categoryBean categorybean = new categoryBean();

	categorybean.setCaId(id);
	categorybean.setCaName(catName.toUpperCase().trim());
	categorybean.setPrice(price);

	boolean flag = categoryDAO.updateCategory(categorybean);

	if (flag) {
		response.sendRedirect("CategoryVED.jsp");
	} else {
		response.sendRedirect("Error.jsp");
	}
%>