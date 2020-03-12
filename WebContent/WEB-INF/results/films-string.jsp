<%@ page import="java.util.List"%>
<%@ page import="model.Film" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");


//Outputs text formatted to be more readable
for(int i=0; i<films.size(); i++) {
	Film film = films.get(i);
	response.getWriter().println("Title: " + film.getTitle() + "\n" + "Year: " + film.getYear() + "\n" + "Director: " + film.getDirector() + "\n" + "Stars: " + film.getStars() + "\n" + "Review: " + film.getReview());
	response.getWriter().println("-------------------------------------------");
}


%>