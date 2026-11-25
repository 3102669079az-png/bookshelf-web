package com.bookshelf.dao;

import com.bookshelf.model.Book;
import com.bookshelf.model.EBook;
import com.bookshelf.model.PaperBook;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDao {

    private final JdbcTemplate jdbc;

    public BookDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Book> findAll() {
        String sql = "SELECT id, name, type, price, pages, file_size FROM book ORDER BY id";
        return jdbc.query(sql, (rs, rowNum) -> toBook(rs));
    }

    private Book toBook(ResultSet rs) throws SQLException {
        String type = rs.getString("type");
        Book book;
        if ("EBOOK".equals(type)) {
            book = new EBook(rs.getString("name"),
                    rs.getBigDecimal("price"),
                    rs.getInt("pages"),
                    rs.getInt("file_size"));
        } else {
            book = new PaperBook(rs.getString("name"),
                    rs.getBigDecimal("price"),
                    rs.getInt("pages"));
        }
        book.setId(rs.getLong("id"));
        return book;
    }

    public Book findById(long id){
        String sql = "SELECT id, name, type, price, pages, file_size FROM book WHERE id = ?";
        List<Book> list = jdbc.query(sql,(rs, rowNum) -> toBook(rs), id);
        return list.isEmpty() ? null : list.get(0);

    }

    public List<Book> findByType(String type) {
        String sql = "SELECT id, name, type, price, pages, file_size FROM book WHERE type = ? ORDER BY id";
        return jdbc.query(sql, (rs, rowNum) -> toBook(rs), type);
    }
}