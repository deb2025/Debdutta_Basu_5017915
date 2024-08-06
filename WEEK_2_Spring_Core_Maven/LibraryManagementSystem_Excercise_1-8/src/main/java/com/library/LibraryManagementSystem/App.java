package com.library.LibraryManagementSystem;


import com.library.LibraryManagementSystem.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//"App" is the class to load the Spring Context and test the application as required by all the excercise
public class App {
    public static void main(String[] args) {
        // Loading the Spring context i.e "applicationContext.xml"
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Getting the BookService bean using context.getBean("bookService")
        BookService bookService = (BookService) context.getBean("bookService");

        // Finally testing the configuration
        bookService.printService();
    }
}
