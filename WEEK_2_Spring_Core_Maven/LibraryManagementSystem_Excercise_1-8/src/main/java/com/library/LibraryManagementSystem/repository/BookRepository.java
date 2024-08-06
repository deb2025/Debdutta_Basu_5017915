package com.library.LibraryManagementSystem.repository;

import org.springframework.stereotype.Repository;


//@Repository annotation added as part of Excercise 6 requirements
@Repository
//BookService Class as required by Excercise 1 and Excercise 2
public class BookRepository {
    public void printRepository() {
        System.out.println("BookRepository is working");
    }
}

