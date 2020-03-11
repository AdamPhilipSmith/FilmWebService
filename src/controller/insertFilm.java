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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		FilmDAO fdao = new FilmDAO();

		int id = Integer.parseInt(request.getParameter("ID"));
		String title = request.getParameter("Title");
		int year = Integer.parseInt(request.getParameter("Year"));
		String director = request.getParameter("Director");
		String stars = request.getParameter("Stars");
		String review = request.getParameter("Review");

		Film f = new Film(id, title, year, director, stars, review);
		
		//TODO remember what the int's were
		//Inserts film to database and prints out a message to console to advise if it was successful
		if (fdao.insertFilm(f) == 1) {
			System.out.println("Your film has been added to the database.");	
		}
		else {
			System.out.println("Your film was not added.");
		}

		
		
		
		
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

}
