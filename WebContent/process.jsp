<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Film</title>
</head>
<body>


<%



 
 	model.FilmDAO fdao = new model.FilmDAO();
	String title = request.getParameter("title");
	int id = Integer.parseInt(request.getParameter("id"));
	
	int year = Integer.parseInt(request.getParameter("year"));
	String director = request.getParameter("director");
	String stars = request.getParameter("stars");
	String review = request.getParameter("review");

	model.Film f = new model.Film(id, title, year, director, stars, review);
	
	//TODO remember what the int's were
	//Inserts film to database and prints out an int to console to advise if it was successful
	
	 
	System.out.println(fdao.insertFilm(f));
	
	if (fdao.insertFilm(f) == 1){
		
	}
 

/**
 * Sends the user back to the Dashboard once
 *they have added the film and then informs them
 *that it has been added.
 */ 
response.sendRedirect("index.html");

%>
</body>
</html>