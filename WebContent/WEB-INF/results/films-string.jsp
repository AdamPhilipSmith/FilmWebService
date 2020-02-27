<%@ page import="java.util.List"%>
<%@ page import="model.Film" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");

response.getWriter().println(films); 
%>