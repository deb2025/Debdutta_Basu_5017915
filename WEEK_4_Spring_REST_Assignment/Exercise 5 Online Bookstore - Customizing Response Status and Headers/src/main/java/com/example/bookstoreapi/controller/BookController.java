package com.example.bookstoreapi.controller;

import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

//BookController class defined to test the REST Endpoints
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    //BookController class endpoints updated with HTTPS status mapping and custom HTTP headers as required by Excercise 5
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "GetAllBooks");
        return ResponseEntity.ok().headers(headers).body(books);
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "GetBookById");
        return ResponseEntity.ok().headers(headers).body(book);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "CreateBook");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(createdBook);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBook(id, bookDetails);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "UpdateBook");
        return ResponseEntity.ok().headers(headers).body(updatedBook);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "DeleteBook");
        return ResponseEntity.noContent().headers(headers).build();
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
