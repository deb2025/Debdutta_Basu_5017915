package com.example.bookstoreapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

//BookController class defined to test the REST Endpoints
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        return ResponseEntity.ok(book);
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
    
    //BookController updated with @search endpoint to display the CRUD operations
    @GetMapping("/search")
    public List<Book> searchBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {
        if (title != null && author != null) {
            return bookService.getBooksByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookService.getBooksByTitle(title);
        } else if (author != null) {
            return bookService.getBooksByAuthor(author);
        } else {
            return bookService.getAllBooks();
        }
    }
}
