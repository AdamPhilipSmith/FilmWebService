package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.FilmDAO;

/**
 * Servlet implementation class updateID
 */
@WebServlet("/updateID")
public class updateID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateID() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Creates new instance of FilmDAO
		FilmDAO filmDAO = new FilmDAO();

		
		// Gets the required parameters and converts them to ints.
		String currentFilmID = request.getParameter("currentFilmID");

		int currentFilmIDint = Integer.parseInt(currentFilmID);

		String newFilmID = request.getParameter("newFilmID");

		int newFilmIDint = Integer.parseInt(newFilmID);

		int i = filmDAO.updateID(newFilmIDint, currentFilmIDint);

		// Prints to console alerting the user if a film has been updated and if so, how
		// many. (Multiple films may exist with the same ID)
		System.out.println(i);
		if (i == 1) {
			System.out.println("Your film ID has been updated.");
		} else if (i > 1) {
			System.out.println(i + " films ID's have been updated.");
		} else {
			System.out.println("Your film was not updated. Please enter a valid ID");
		}
		
		
		// MVC used here. A view is accessed from here depending on the format given as parameter.
		String format = request.getParameter("format");
		String outputPage;
		if ("xml".equals(format)) {
			response.setContentType("text/xml");
			outputPage = "/WEB-INF/results/films-xml.jsp";
			
		} else if ("text".equals(format)) {
			response.setContentType("text/plain");
			outputPage = "/WEB-INF/results/films-string.jsp";
			
		} else {
			// no formating selected means Json will be chosen as the default
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
