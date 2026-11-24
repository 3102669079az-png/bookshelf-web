package com.bookshelf.controller;

import com.bookshelf.dao.BookDao;
import com.bookshelf.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
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
}