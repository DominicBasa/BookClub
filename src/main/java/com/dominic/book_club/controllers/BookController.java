package com.dominic.book_club.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dominic.book_club.models.Book;
import com.dominic.book_club.services.BookService;

@Controller
public class BookController {
  
  @Autowired BookService bookService;
  //! CREATE

  @GetMapping("/books/new")
  public String newBook(@ModelAttribute("book")Book book) {
    return "books/new.jsp";
  } 

  @PostMapping("/books")
  public String createBook(@ModelAttribute("book")Book book) {
    bookService.addBook(book);
    return "redirect:/books";
  }



  @GetMapping("/books")
  public String allBooks() {
    return "books/index.jsp";
  }



}
