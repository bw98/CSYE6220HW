package com.example.csye6220hw.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static SingletonConnection instance;
    private final String USERNAME = "root";
    private final String PASSWORD = "12345678";

    private final String MOVIE_DB_URL = "jdbc:mysql://localhost/moviedb";
    private final String BOOK_DB_URL = "jdbc:mysql://localhost/booksdb";

    private SingletonConnection() {
        // private constructor to prevent instantiation from outside the class
    }

    public static SingletonConnection getInstance() {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    public Connection getMovieDBConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(MOVIE_DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public Connection getBookDBConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(BOOK_DB_URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
