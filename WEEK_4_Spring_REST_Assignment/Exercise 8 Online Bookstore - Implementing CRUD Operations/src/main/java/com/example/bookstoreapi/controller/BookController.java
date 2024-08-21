package com.example.bookstoreapi.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.example.bookstoreapi.dto.BookDTO;
import com.example.bookstoreapi.mapper.BookMapper;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.service.BookService;

//BookController class defined to test the REST Endpoints
@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    //BookController class updated with the usage of BookDTO Data Transfer Objects as part of Excercise 7
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        List<BookDTO> bookDTOs = books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Book book = bookService.getBookById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        BookDTO bookDTO = BookMapper.INSTANCE.bookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }
    
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book createdBook = bookService.createBook(book);
        BookDTO createdBookDTO = BookMapper.INSTANCE.bookToBookDTO(createdBook);
        return ResponseEntity.status(201).body(createdBookDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book bookDetails = BookMapper.INSTANCE.bookDTOToBook(bookDTO);
        Book updatedBook = bookService.updateBook(id, bookDetails);
        BookDTO updatedBookDTO = BookMapper.INSTANCE.bookToBookDTO(updatedBook);
        return ResponseEntity.ok(updatedBookDTO);
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
