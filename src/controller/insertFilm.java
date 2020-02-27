package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class insertFilm
 */
@WebServlet("/insertFilm")
public class insertFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
FilmDAO fdao = new FilmDAO();
		
		int id = Integer.parseInt(request.getParameter("ID"));
		String filmname = request.getParameter("Filmname");
		int year = Integer.parseInt(request.getParameter("Year"));
		String director = request.getParameter("Director");
		String stars = request.getParameter("Stars");
		String review = request.getParameter("Review");
		
		
		Film f = new Film(id, filmname, year, director, stars, review);
		
		System.out.println(fdao.insertFilm(f));
		
		
		 
		
		
		
		 	
		//TODO add insert film/get film by ID etc.
				//TODO viewers below expects a list of items, so maybe need to use array for an individual.
		    String format = request.getParameter("format");
		    String outputPage;
		    if ("xml".equals(format)) {
		      response.setContentType("text/xml");
		      outputPage = "/WEB-INF/results/films-xml.jsp";
		    } else if ("json".equals(format)) {
		      response.setContentType("application/json");
		      outputPage = "/WEB-INF/results/films-json.jsp";
		    } else {
		    	//TODO Iterate over films list, one element at a time, printing each value. (Check Demo Datastore)
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
