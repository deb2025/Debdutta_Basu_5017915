package com.example.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookstoreapi.model.Book;

//BookRepository class created to implement JPA Repository methods
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}