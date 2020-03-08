package controller;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import model.Film;
import model.FilmDAO;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilmDAO fdao = new FilmDAO();
		
		ArrayList<Film> films = fdao.getAllFilms();
		
		
		
		//Prints out all films to String
		for(int i=0; i<films.size(); i++) {
			Film oneFilm = films.get(i);
			System.out.println("Title: " + oneFilm.getTitle() + "\n" + "Year: " + oneFilm.getYear() + "\n" + "Director: " + oneFilm.getDirector() + "\n" + "Stars: " + oneFilm.getStars() + "\n" + "Review: " + oneFilm.getReview());
			System.out.println("-------------------------------------------");
		}
		
		
		//Prints out all films to JSON
		Gson gson = new Gson();
		String allFilmsJson = gson.toJson(films);
		System.out.println(allFilmsJson);
		
		
		//Prints out a film searched by ID
		Film byID = fdao.getFilmByID(10013);
		System.out.println(byID.toString());
		
		//Prints out all films containing the chosen title
		ArrayList<Film> searchedFilms = fdao.getFilmByTitle("wars");
		
		for(int i=0; i<searchedFilms.size(); i++) {
		Film searchedFilm = searchedFilms.get(i);
				System.out.println(searchedFilm.toString());
		}
		
		
		
		
		//Inserts a film to the database and prints out an int to say if it was successful or not.
		Film insert = new Film (99, "test", 1984, "test", "test",
			"test");
	
		System.out.println(fdao.insertFilm(insert));
		
		
		
		
		//Updates a films ID with a new ID. Printing out an int to say if this was successful.
		System.out.println(fdao.updateID(88, 99));
		
		
		
			
		
		//Deletes the film with the given ID. Printing out an int to say if this was successful.
		try {
			System.out.println(fdao.deleteFilm(88));
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		
		
	}

}
