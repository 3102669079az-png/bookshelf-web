package com.bookshelf.controller;

import com.bookshelf.dao.BookDao;
import com.bookshelf.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @GetMapping("/books")
    public List<Book> books(@RequestParam(required = false) String type) {
        if (type == null || type.isBlank()){
            return bookDao.findAll();
        }
        return bookDao.findByType(type);
    }


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> bookById(@PathVariable long id) {
        Book book = bookDao.findById(id);
        if (book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> addBook(@RequestBody BookRequest req){
        int rows = bookDao.insert(
                req.getName(),
                req.getType(),
                req.getPrice(),
                req.getPages(),
                req.getFileSize()
        );
        if (rows == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(201).build();
    }
}