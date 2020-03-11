<%@ page import="java.util.List"%>
<%@ page import="model.Film" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.ArrayList" %>
<%
List<Film> films = (List<Film>) request.getAttribute("films");


//Outputs text formatted to be more readable
for(int i=0; i<films.size(); i++) {
	Film oneFilm = films.get(i);
	response.getWriter().println("Title: " + oneFilm.getTitle() + "\n" + "Year: " + oneFilm.getYear() + "\n" + "Director: " + oneFilm.getDirector() + "\n" + "Stars: " + oneFilm.getStars() + "\n" + "Review: " + oneFilm.getReview());
	response.getWriter().println("-------------------------------------------");
}


%>