<%@ page import="java.util.List"%>
<%@ page import="model.Film" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");


//Converts Array of film object to an array of Strings
List<String> filmString = new ArrayList<>(films.size());
for (Film film : films) {
    filmString.add(film != null ? film.toString() : null);
}
String test = "test";
response.getWriter().println(films); 
%>