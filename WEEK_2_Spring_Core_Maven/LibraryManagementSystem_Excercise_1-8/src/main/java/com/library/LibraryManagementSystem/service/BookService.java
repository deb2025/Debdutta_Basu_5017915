package com.library.LibraryManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.LibraryManagementSystem.repository.BookRepository;

//@Service annotation added as part of Excercise 6 requirements
@Service
//BookService Class as required by Excercise 1 and Excercise 2
public class BookService {
    private BookRepository bookRepository;

    
    // Constructor for constructor injection as of Excercise 7
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // Setter for setter injection as of Excercise 7
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public void printService() {
        System.out.println("BookService is working with " + bookRepository);
    }
}
