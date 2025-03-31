<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.mvc.beans.categoryBean"%>
<%@page import="com.mvc.dao.categoryDAO"%>
<%-- data from front end passed to database and the data from 
database is again given to front end --%>

<%
String catName = request.getParameter("catName");
float price = Float.parseFloat(request.getParameter("catPrice"));

categoryBean categorybean = new categoryBean();

categorybean.setCaName(catName.toUpperCase().trim());

categorybean.setPrice(price);

boolean flag = categoryDAO.insertCategory(categorybean);

if (flag) { //(if(flag==true))
	response.sendRedirect("CategoryVED.jsp");
} else {
	response.sendRedirect("Error.jsp");
}
%>