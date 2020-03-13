package controller;


import java.io.IOException;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


import model.FilmREST;
import model.Film;
import model.FilmDAO;


// Will map the resource to the URL todos
@Path("/Film")
public class ControllerREST {

	// Allows to insert contextual objects into the class, 
	// e.g. ServletContext, Request, Response, UriInfo
	@Context
	UriInfo uriInfo;
	@Context
	Request request;


	
	@GET
	@Produces(MediaType.TEXT_XML)
	public List<Film> getFilmWebService() {
		List<Film> films = new ArrayList<Film>();
		films.addAll( FilmDAO.instance.getModel().values() );
		return films; 
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Film> getTodos() {
		List<Film> films = new ArrayList<Film>();
		films.addAll( FilmDAO.instance.getModel().values() );
		return films; 
	}
	
	
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = Film.instance.getModel().size();
		return String.valueOf(count);
	}
	
	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void newTodo(
			@FormParam("id") int id,
			@FormParam("title") String title,
			@FormParam("year") int year,
			@FormParam("year") String director,
			@FormParam("year") String stars,
			@FormParam("year") String review,
			@Context HttpServletResponse servletResponse
	) throws IOException {
		Film film = new Film(id,title, year, director, stars, review);
		if (description!=null){
			film.setDescription(description);
			
			this.id = id;
			this.title = title;
			this.year = year;
			this.director = director;
			this.stars = stars;
			this.review = review;
		}
		}
		FilmDAO.instance.getModel().put(id, todo);
		
		servletResponse.sendRedirect("../create_todo.html");
	}
	
	
	// Defines that the next path parameter after todos is
	// treated as a parameter and passed to the TodoResources
	// Allows to type http://localhost:8080/com.democo.jersey.todo/rest/todos/1
	// 1 will be treated as parameter todo and passed to TodoResource
	@Path("{todo}")
	public TodoResource getTodo(
			@PathParam("todo") String id) {
		return new TodoResource(uriInfo, request, id);
	}
	
}
