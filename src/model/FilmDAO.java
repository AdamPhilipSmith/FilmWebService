/**
* The purpose of this class is to construct

* access the database and retrieve the requested info  .
* @author Adam Smith Student Number: 19017627
* @version 1.0
*/

package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class FilmDAO {


	public static Object instance;
	Film oneFilm = null;
	Connection conn = null;
	Statement stmt = null;
	String user = "smitha";
	String password = "Moudpoil5";
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;

	public FilmDAO() {
	}

	private void openConnection() {

		// Loads the correct JDBC driver to access the mySQL database.
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}

		// Connects to the database using the username and password provided above.
		try {

			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	// Method to close connection
	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	
	// Method to get the next film from a set of results.
	private Film getNextFilm(ResultSet rs) {
		Film thisFilm = null;
		try {
			thisFilm = new Film(rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getString("director"),
					rs.getString("stars"), rs.getString("review"));
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return thisFilm;
	}

	public ArrayList<Film> getAllFilms() {

		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();

		// Creates an SQL statement to select all films, then executes it.
		try {
			String query = "select * from films";
			ResultSet rs1 = stmt.executeQuery(query);
			// Uses getNextFilm() method to get all the results and adds the to the Array List
			while (rs1.next()) {
				oneFilm = getNextFilm(rs1);
				allFilms.add(oneFilm);
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return allFilms;
	}

	public Film getFilmByID(int id) {

		openConnection();
		oneFilm = null;
		// Creates an SQL statement to select all films, then executes it.
		try {

			String query = "select * from films where id=" + id;
			ResultSet rs1 = stmt.executeQuery(query);
			// Uses getNextFilm() method to get all the results and adds the to the Array List
			while (rs1.next()) {
				oneFilm = getNextFilm(rs1);
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return oneFilm;
	}

	public ArrayList<Film> getFilmByTitle(String title) {

		ArrayList<Film> searchedFilms = new ArrayList<Film>();
		openConnection();
		oneFilm = null;
		// Creates an SQL statement to select all films, then executes it.
		try {
			String query = "select * from films where title like '%" + title + "%';";
			ResultSet rs1 = stmt.executeQuery(query);
			// Uses getNextFilm() method to get all the results and adds the to the Array List
			while (rs1.next()) {
				oneFilm = getNextFilm(rs1);
				searchedFilms.add(oneFilm);
			}

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return searchedFilms;
	}

	public int insertFilm(Film film) {
		int i = 0;
		openConnection();

		try {
			String query = "INSERT INTO films (id, title, year, director, stars, review) VALUES (" + film.getId() + ",'"
					+ film.getTitle() + "'," + film.getYear() + ",'" + film.getDirector() + "','" + film.getStars()
					+ "','" + film.getReview() + "');";
			// Inserts the films and returns integer. 1 being success and 0 being error.
			i = stmt.executeUpdate(query);

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return i;

	}

	public int updateID(int newID, int ID) {

		int i = 0;
		openConnection();

		try {

			String query = "UPDATE films " + "SET id = " + newID + " WHERE id = " + ID + ";";
			
			// Updates the film/s and returns integer showing how many films have been updated.
			i = stmt.executeUpdate(query);

			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}

		return i;
	}

	public int deleteFilm(int film_id) throws SQLException {

		openConnection();
		int i = 0;

		String query = "DELETE FROM films WHERE id = " + film_id + ";";

		try {
			// Deletes the film/s and returns integer showing how many films have been deleted.
			i = stmt.executeUpdate(query);
			stmt.close();
			closeConnection();

		} catch (SQLException se) {
			System.out.println(se);
		}

		return i;
	}

	

}
