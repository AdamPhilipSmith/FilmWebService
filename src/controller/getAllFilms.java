package controller;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.google.gson.Gson;

//import coreservlets.String;
import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/getAllFilms")
public class getAllFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getAllFilms() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//PrintWriter out = response.getWriter();
		FilmDAO fdao = new FilmDAO();
		
		ArrayList<Film> films = fdao.getAllFilms();
		//TODO add insert film/get film by ID etc.
		//TODO viewers below expects a list of items, so maybe need to use array for an individual.
		
		
		
		
		//Film f = fdao.getFilmByID(10013) ;
		
		//TODO The following uses MVC. CHeck video Part 2 - 14:30
		 request.setAttribute("films", films);
		    String format = request.getParameter("format");
		    String outputPage;
		    if ("xml".equals(format)) {
		      response.setContentType("text/xml");
		      outputPage = "/WEB-INF/results/films-xml.jsp";
		    } else if ("json".equals(format)) {
		      response.setContentType("application/json");
		      outputPage = "/WEB-INF/results/films-json.jsp";
		    } else {
		    	//TODO Iterate over films list, one element at a time, priniting each value. (Check Demo Datastore)
		      response.setContentType("text/plain");
		      outputPage = "/WEB-INF/results/films-string.jsp";
		    }
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(outputPage);
		    dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
