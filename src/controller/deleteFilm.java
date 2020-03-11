package controller;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class deleteFilm
 */
@WebServlet("/deleteFilm")
public class deleteFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deleteFilm() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Creates new instance of FilmDAO
		FilmDAO filmDAO = new FilmDAO();
		
		//Gets the filmid parameter, converts it to an int.

		String deleteFilmId = request.getParameter("filmid");

		int deleteFilmIdInt = Integer.parseInt(deleteFilmId);
		
		
		// calls the DAO to delete the selected film
		int i = 0;
		try {
			i = filmDAO.deleteFilm(deleteFilmIdInt);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		// Prints to console alerting the user if a film has been deleted and how many.
		// (Multiple films may exist with the same ID)
		System.out.println(i);
		if (i == 1) {
			System.out.println("Your film has been deleted from the database.");
		} else if (i > 1) {
			System.out.println(i + " films have been deleted from the database.");
		} else {
			System.out.println("Your film was not deleted.");
		}

		String format = request.getParameter("format");
		String outputPage;
		
		if ("xml".equals(format)) {
			response.setContentType("text/xml");
			outputPage = "/WEB-INF/results/films-xml.jsp";
			
		} else if ("text".equals(format)) {
			response.setContentType("text/plain");
			outputPage = "/WEB-INF/results/films-string.jsp";
			
		} else {
			// no formating selected means JSON will be chosen as the default.
			response.setContentType("application/json");
			outputPage = "/WEB-INF/results/films-json.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(outputPage);
		dispatcher.include(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
