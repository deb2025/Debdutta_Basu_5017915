package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.model.Book;

//Created a Book Repository to store information on Books
public interface BookRepository extends JpaRepository<Book, Long> {
}
