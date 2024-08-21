package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

//Created Data Transfer Objects as required by Excercise 7
@Data
//Customized JSON Serialization
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO {
    
    @JsonProperty("book_id")
    private Long id;
    
    private String title;
    
    @JsonProperty("book_author")
    private String author;
    
    private Double price;
    
    private String isbn;
}
