package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;

public class FilmDAO {

	Film oneFilm = null;
	Connection conn = null;
	Statement stmt = null;
	String user = "smitha";
	String password = "Moudpoil5";
	// Note none default port used, 6306 not 3306
	String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/" + user;

	public FilmDAO() {
	}

	private void openConnection() {
		// loading jdbc driver for mysql
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}

		// connecting to database
		try {
			// connection string for demos database, username demos, password demos
			conn = DriverManager.getConnection(url, user, password);
			stmt = conn.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs) {
		Film thisFilm = null;
		try {
			thisFilm = new Film(rs.getInt("id"), rs.getString("title"), rs.getInt("year"), rs.getString("director"),
					rs.getString("stars"), rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thisFilm;
	}

	public ArrayList<Film> getAllFilms() {

		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();

		// Create select statement and execute it
		try {
			String query = "select * from films";
			ResultSet rs1 = stmt.executeQuery(query);
			// Retrieve the results
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
		// Create select statement and execute it
		try {
			String query = "select * from films where id=" + id;
			ResultSet rs1 = stmt.executeQuery(query);
			// Retrieve the results
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
		// Create select statement and execute it
		try {
			String query = "select * from films where title like '%" + title + "%';";
			ResultSet rs1 = stmt.executeQuery(query);
			// Retrieve the results
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

			i = stmt.executeUpdate(query);
			stmt.close();
			closeConnection();

		} catch (SQLException se) {
			System.out.println(se);
		}

		return i;
	}

}
