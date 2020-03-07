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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		FilmDAO fdao = new FilmDAO();
		
		String searchFilmName = request.getParameter("filmname");
		
		ArrayList<Film> films = fdao.getFilmByTitle(searchFilmName);
		 
		request.setAttribute("films", films);
		
		//TODO for debug. Remove later
				System.out.println(films);
		 	
		 	
		 	
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
				    	//no formating selected means Json will be chosen as the default
				      response.setContentType("application/json");
				      outputPage = "/WEB-INF/results/films-json.jsp";
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
