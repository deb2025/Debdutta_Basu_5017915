package com.example.bookstoreapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


//Created Data Transfer Objects as required by Excercise 7
@Data
//Customized JSON Serialization
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {
    
    @JsonProperty("customer_id")
    private Long id;
    
    private String name;
    
    @JsonProperty("customer_email")
    private String email;
    
    private String address;
}
