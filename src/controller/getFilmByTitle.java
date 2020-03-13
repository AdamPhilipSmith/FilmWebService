/**
* The purpose of this class is to retrieve
* a film from the database.
* @author Adam Smith Student Number: 19017627
* @version 1.0
*/

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
 * Servlet implementation class getFilmByTitle
 */
@WebServlet("/getFilmByTitle")
public class getFilmByTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getFilmByTitle() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Creates new instance of FilmDAO
		FilmDAO filmDAO = new FilmDAO();

		String searchFilmName = request.getParameter("filmname");

		ArrayList<Film> films = filmDAO.getFilmByTitle(searchFilmName);

		request.setAttribute("films", films);

		// Prints out films to console for debugging
		System.out.println(films);

		// MVC used here. A view is accessed from here depending on the format given as parameter.
		request.setAttribute("films", films);
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

		doGet(request, response);
	}

}
