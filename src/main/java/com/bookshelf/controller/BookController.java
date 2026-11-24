package com.bookshelf.controller;

import com.bookshelf.dao.BookDao;
import com.bookshelf.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public List<Book> books() {
        return bookDao.findAll();
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> bookById(@PathVariable long id) {
        Book book = bookDao.findById(id);
        if (book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }
}