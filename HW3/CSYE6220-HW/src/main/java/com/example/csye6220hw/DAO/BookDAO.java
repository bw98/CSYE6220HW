package com.example.csye6220hw.DAO;

import com.example.csye6220hw.Bean.Book;
import com.example.csye6220hw.Bean.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public BookDAO() {
    }

    public boolean insertBooks(List<Book> books) {
        Connection conn = null;
        PreparedStatement ps = null;
        boolean isSuccess = false;

        try {
            conn = SingletonConnection.getInstance().getBookDBConnection();
            conn.setAutoCommit(false);
            String sql = "INSERT INTO books (isbn, title, authors, price) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            for (Book book : books) {
                ps.setString(1, book.getIsbn());
                ps.setString(2, book.getTitle());
                ps.setString(3, book.getAuthors());
                ps.setFloat(4, book.getPrice());
                ps.addBatch();
            }

            int[] results = ps.executeBatch();
            for (int result : results) {
                if (result == PreparedStatement.EXECUTE_FAILED) {
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();
            isSuccess = true;

        } catch (SQLException e) {
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

        return isSuccess;
    }
}