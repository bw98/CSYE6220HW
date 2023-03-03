package com.example.csye6220hw.DAO;

import com.example.csye6220hw.Bean.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    public MovieDAO() {

    }

    public boolean addMovie(String title, String leadActor, String leadActress, String genre, int year) throws SQLException {
        String sql = "INSERT INTO movies (title, actor, actress, genre, year) VALUES (?, ?, ?, ?, ?)";
        int rowsInserted = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = SingletonConnection.getInstance().getMovieDBConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, leadActor);
            ps.setString(3, leadActress);
            ps.setString(4, genre);
            ps.setInt(5, year);
            rowsInserted = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsInserted > 0;
    }

    public List<Movie> searchByTitle(String title) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies WHERE title LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = SingletonConnection.getInstance().getMovieDBConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString("title"));
                movie.setLeadActor(resultSet.getString("actor"));
                movie.setLeadActress(resultSet.getString("actress"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setYear(resultSet.getInt("year"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public List<Movie> searchByActor(String actor) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies WHERE actor LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = SingletonConnection.getInstance().getMovieDBConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + actor + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString("title"));
                movie.setLeadActor(resultSet.getString("actor"));
                movie.setLeadActress(resultSet.getString("actress"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setYear(resultSet.getInt("year"));
                movies.add(movie);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }

    public List<Movie> searchByActress(String actress) throws SQLException {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movies WHERE actress LIKE ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = SingletonConnection.getInstance().getMovieDBConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + actress + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setTitle(resultSet.getString("title"));
                movie.setLeadActor(resultSet.getString("actor"));
                movie.setLeadActress(resultSet.getString("actress"));
                movie.setGenre(resultSet.getString("genre"));
                movie.setYear(resultSet.getInt("year"));
                movies.add(movie);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }
}
